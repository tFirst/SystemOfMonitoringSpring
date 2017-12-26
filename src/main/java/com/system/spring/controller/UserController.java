package com.system.spring.controller;

import com.system.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@RestController
@RequestMapping("/")
public class UserController extends WebMvcConfigurerAdapter {

    final UserService userService;


    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addRedirectViewController("/", "/index");

        registry.addViewController("/index")
                .setViewName("/index");
    }

    @RequestMapping(value = "index**", method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView model = new ModelAndView();
        model.addObject("title", "Spring Security Custom Login Form");
        model.addObject("message", "This is protected page!");
        model.setViewName("index");

        return model;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(@RequestParam(value = "error", required = false) String error,
                              @RequestParam(value = "logout", required = false) String logout,
                              @RequestParam(value = "login", required = false) String login) {
        System.out.println("ERROR " + error);
        System.out.println("LOGIN " + login);
        ModelAndView model = new ModelAndView();
        if (error != null) {
            model.addObject("error", "Invalid username and password!");
        }

        if (logout != null) {
            model.addObject("msg", "You've been logged out successfully.");
        }

        if (error == null && logout == null && login != null) {
            model.setViewName("forward:/hello");
        } else {
            model.setViewName("login");
        }

        return model;
    }

    @RequestMapping(value = "/isAuth", method = RequestMethod.GET)
    public ModelAndView isAuth(Authentication authentication) {
        return userService.isAuth(authentication);
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public ModelAndView hello() {
        return new ModelAndView("hello");
    }

    @RequestMapping(value = "/goBack", method = RequestMethod.GET)
    public ModelAndView goBack(@RequestParam(value = "message", required = false) String message) {
        ModelAndView model = new ModelAndView();

        if (message != null) {
            model.addObject("msg", "You've been logged out successfully.");
        }
        model.setViewName("index");

        return model;
    }

    @RequestMapping(value = "/error", method = RequestMethod.GET)
    public ModelAndView error() {
        return new ModelAndView("error");
    }
}
