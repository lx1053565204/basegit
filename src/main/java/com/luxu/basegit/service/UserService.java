package com.luxu.basegit.service;

import com.luxu.basegit.entity.User;

import java.util.List;

/**
 *
 */
//@Service
public interface UserService {
    public User selectUserById(int id);
    public User findUserById(String id);

    public List<User> findAll();

}
