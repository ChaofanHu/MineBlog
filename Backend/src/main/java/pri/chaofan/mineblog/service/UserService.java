package pri.chaofan.mineblog.service;

import pri.chaofan.mineblog.pojo.User;

public interface UserService {
    User checkUser(String email, String password);
    User selectByEmail(String email);


}
