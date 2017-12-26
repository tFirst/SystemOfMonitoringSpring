package com.system.spring.service;

import com.system.spring.entity.Users;
import com.system.spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;

@Service
public class UserServiceImpl implements UserService {

    final
    UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Collection<Users> findAll() {
        return userRepository.findAll();
    }

    @Override
    public ModelAndView isAuth(Authentication authentication) {
        if (authentication.isAuthenticated()) {
            return new ModelAndView("hello");
        } else {
            return new ModelAndView("login");
        }
    }
}
