package pri.chaofan.mineblog.interceptor;


import com.alibaba.fastjson.JSONObject;

import com.auth0.jwt.exceptions.*;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import pri.chaofan.mineblog.service.UserService;
import pri.chaofan.mineblog.util.TokenUtil;

import java.io.PrintWriter;
import java.lang.invoke.MethodHandle;

public class LoginInterceptor implements HandlerInterceptor {
    @Autowired
    UserService userService;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        if(!(handler instanceof MethodHandle)){
            return false;
        }
        System.out.println(token);
        JSONObject jsonObject = new JSONObject();
        try {
            if(token==null) {
                jsonObject.put("msg", "token can't be null");
            }
            TokenUtil.verify(token); //verify token
            return true;
        } catch (SignatureVerificationException e) {

            jsonObject.put("msg","invalid signature");
        } catch (TokenExpiredException e) {

            jsonObject.put("msg", "token expired");

        } catch (AlgorithmMismatchException e) {
            jsonObject.put("msg", "algorithm wrong");
        } catch (Exception e) {

            jsonObject.put("msg", "other exceptions");
        }
        jsonObject.put("state", false);
        //map转换为json

        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        out.print(jsonObject.toString());
        out.close();
        return false;
    }
}
