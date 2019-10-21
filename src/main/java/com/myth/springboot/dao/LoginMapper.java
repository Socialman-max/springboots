package com.myth.springboot.dao;

import com.myth.springboot.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginMapper {
    //查找用户
    User selectUser(String name);

    int updatePassword(String u_password,String u_name);
}
