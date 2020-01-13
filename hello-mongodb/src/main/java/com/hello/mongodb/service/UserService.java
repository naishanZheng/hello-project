package com.hello.mongodb.service;

import com.hello.mongodb.entity.User;
import org.springframework.data.mongodb.core.query.Criteria;

public interface UserService {

    void saveUser(User user);

    User findUserByUserName(String userName);

    long updateUser(User user);

    void deleteUserById(Long id);
}


