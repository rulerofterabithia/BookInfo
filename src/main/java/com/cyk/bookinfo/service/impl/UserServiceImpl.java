package com.cyk.bookinfo.service.impl;

import com.cyk.bookinfo.entity.User;
import com.cyk.bookinfo.mapper.UserMapper;
import com.cyk.bookinfo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public void saveUser(User user) {
        userMapper.save(user);
    }

    @Override
    public User findUserByNameAndPwd(User user) {
        return userMapper.findUserByNameAndPwd(user);
    }
}
