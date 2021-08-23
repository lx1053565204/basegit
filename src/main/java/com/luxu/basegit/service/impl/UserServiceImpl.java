package com.luxu.basegit.service.impl;

import com.luxu.basegit.entity.User;
import com.luxu.basegit.mapper.UserMapper;
import com.luxu.basegit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public User selectUserById(int id) {

        return userMapper.selectUserById(id);
    }

    @Override
    public User findUserById(String id) {
        return userMapper.findUserByIdserById(id);
    }

    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }
}
