package com.wink.service;

import com.wink.domain.User;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface UserService {

    User login(User user) throws Exception;



    int reg(User user,String repassword);
}
