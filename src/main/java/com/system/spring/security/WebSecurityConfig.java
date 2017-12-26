package com.system.spring.security;

import com.system.spring.entity.Users;
import com.system.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import java.util.Collection;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "/index").permitAll()
                .anyRequest().authenticated();
        http
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .permitAll();
    }

    @Configuration
    protected static class AuthenticationConfiguration extends
            GlobalAuthenticationConfigurerAdapter {

        final UserService userService;

        @Autowired
        public AuthenticationConfiguration(UserService userService) {
            this.userService = userService;
        }

        @Override
        public void init(AuthenticationManagerBuilder auth) throws Exception {
            Collection<Users> users = userService.findAll();

            for (Users user : users) {
                System.out.println(user.getLogin() + " " + user.getPassword());
                auth
                        .inMemoryAuthentication()
                        .withUser(user.getLogin())
                        .password(user.getPassword())
                        .roles(user.getRole());
            }
        }

    }

}
