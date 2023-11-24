package pri.chaofan.mineblog.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import pri.chaofan.mineblog.pojo.User;

import java.util.Date;

public class TokenUtil {
    private static final String KEY = "hcf991025";
    public static String getToken(User user){
        Date start = new Date();
        long currentTime = System.currentTimeMillis() + 10*60* 60 * 1000;//十小时有效时间
        Date end = new Date(currentTime);
        String token = "";

        token = JWT.create().withAudience(String.valueOf(user.getEmail())).withIssuedAt(start).withExpiresAt(end)
                .sign(Algorithm.HMAC256(KEY));
        return token;
    }

    public static void verify(String token) throws Exception{

        try {
            DecodedJWT verify = JWT.require(Algorithm.HMAC256(KEY)).build().verify(token);
            String email = verify.getClaim("email").asString();
            System.out.println(email);
        } catch (JWTVerificationException e) {
            throw  new RuntimeException("token wrong");
        }catch (NullPointerException e){
            throw new NullPointerException("don't have token");
        }
    }
}
