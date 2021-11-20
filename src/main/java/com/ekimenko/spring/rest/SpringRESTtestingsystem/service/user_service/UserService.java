package com.ekimenko.spring.rest.SpringRESTtestingsystem.service.user_service;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.dto.TheoreticalStepDto;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.dto.user_dto.UserDto;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.TheoreticalStep;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.user.User;

import java.util.List;

public interface UserService {

    UserDto fromUser(User user);

    List<UserDto> getAllUsersDto();

    UserDto getUserDtoById(long id);

    User register(User user);

    List<User> getAll();

    User findByUsername(String username);

    User findById(Long id);

    void delete(Long id);
}
