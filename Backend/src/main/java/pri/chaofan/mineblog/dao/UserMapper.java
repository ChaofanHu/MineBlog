package pri.chaofan.mineblog.dao;

import org.apache.ibatis.annotations.Param;
import pri.chaofan.mineblog.pojo.User;

public interface UserMapper {
    User selectUser(@Param("email") String email, @Param("password") String password);
    User selectByEmail(@Param("email") String email);
}
