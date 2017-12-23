package com.system.spring.service;

import com.system.spring.entity.User;

import java.util.Collection;

public interface UserService {
    Collection<User> findAll();

    String isAuth(String login, String password);
}
