package com.myth.springboot.service;

import com.myth.springboot.entity.User;
import com.myth.springboot.dao.LoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    LoginMapper mapper;
    //登陆
    public User login(String username){
        User user=mapper.selectUser(username);
        user.toString();
        return user;
    }
    public int updatePassword(String u_password,String u_name){
        return mapper.updatePassword(u_password,u_name);
    }
}
