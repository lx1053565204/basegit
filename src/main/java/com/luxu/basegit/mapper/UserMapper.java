package com.luxu.basegit.mapper;


import com.luxu.basegit.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 */
@Mapper
public interface UserMapper {

    public User selectUserById(int id);

    public User findUserByIdserById(String id);


    public List<User> findAll();
}

