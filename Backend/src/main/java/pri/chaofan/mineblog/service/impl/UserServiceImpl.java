package pri.chaofan.mineblog.service.impl;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pri.chaofan.mineblog.dao.UserMapper;
import pri.chaofan.mineblog.service.UserService;
import pri.chaofan.mineblog.pojo.User;
import pri.chaofan.mineblog.util.MD5Util;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public User checkUser(String email, String password) {
        User user = userMapper.selectUser(email, MD5Util.code(password));
        return user;
    }

    @Override
    public User selectByEmail(String email) {
        User user = userMapper.selectByEmail(email);
        return user;
    }
}
