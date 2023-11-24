package pri.chaofan.mineblog.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import jakarta.servlet.http.HttpSession;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pri.chaofan.mineblog.pojo.User;
import pri.chaofan.mineblog.service.UserService;
import pri.chaofan.mineblog.util.Result;
import pri.chaofan.mineblog.util.TokenUtil;

@RestController()
@RequestMapping("/admin")
public class IndexController {
    @Autowired
    private UserService userService;
    @GetMapping()
    public Result<User> loginPage(){
        return Result.error(404,"wrong email or password");
    }

    @PostMapping(value = "/login",produces = "application/json")
    public Object login(@Param(value = "email") String email, @Param(value = "password") String password, HttpSession session){
        User user = userService.checkUser(email,password);
        if (user != null){
            String token = TokenUtil.getToken(user);
            System.out.println(token);
            return Result.success(200, token, Integer.toString(user.getId()));
        }else{
            return Result.error(401,"wrong email or password");
        }
    }
    @GetMapping("/logout")
    public String logout(HttpSession session){
        return null;
    }
}
