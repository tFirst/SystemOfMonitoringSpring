package com.system.spring.repository;

import com.system.spring.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    Set<User> findAll();

    User findUserByLogin(String login);

    User findUserByLoginAndHashPassword(String login, String password);
}
