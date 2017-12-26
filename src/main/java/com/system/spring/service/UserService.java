package com.system.spring.service;

import com.system.spring.entity.Users;
import org.springframework.security.core.Authentication;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;

public interface UserService {
    Collection<Users> findAll();

    ModelAndView isAuth(Authentication authentication);
}
