package com.wink.service.impl;

import com.wink.domain.User;
import com.wink.mapper.UserMapper;
import com.wink.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper um;

    @Override
    public User login(User user) throws Exception{
        //验证格式
        if(user.getUsUsername().length()<3 || user.getUsUsername().length()>16) {
            throw new Exception("账号格式不正确");
        }
        if (user.getUsPassword().length()<3 || user.getUsPassword().length()>16) {
            throw new Exception("密码格式不对");
        }

        User u=um.selectByUsername(user.getUsUsername());
        if (u==null) {
            throw new Exception("账号不存在");
        }
        if(!u.getUsPassword().equals(user.getUsPassword())){
            throw new Exception("密码不正确");
        }

        return u;
    }

    @Override
    public int reg(User user, String repassword) {
        return 0;
    }
}
