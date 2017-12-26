package com.system.spring.repository;

import com.system.spring.entity.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface UserRepository extends CrudRepository<Users, Long> {

    Set<Users> findAll();

    Users findUserByLogin(String login);

    Users findUserByLoginAndPassword(String login, String password);
}
