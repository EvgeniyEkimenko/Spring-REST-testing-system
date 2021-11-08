package com.ekimenko.spring.rest.SpringRESTtestingsystem.service.user_service;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.user.User;

import java.util.List;

public interface UserService {
    User register(User user);

    List<User> getAll();

    User findByUsername(String username);

    User findById(Long id);

    void delete(Long id);
}
