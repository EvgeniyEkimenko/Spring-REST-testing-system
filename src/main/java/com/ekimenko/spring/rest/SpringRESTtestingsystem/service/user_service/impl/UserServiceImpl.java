package com.ekimenko.spring.rest.SpringRESTtestingsystem.service.user_service.impl;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.dto.user_dto.UserDto;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.user.Role;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.user.Status;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.user.User;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.repository.user_repos.RoleRepository;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.repository.user_repos.UserRepository;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.service.user_service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository
            ,@Lazy RoleRepository roleRepository
            ,@Lazy BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public UserDto fromUser(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setUsername(user.getUsername());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setEmail(user.getEmail());

        return userDto;
    }

    @Override
    public List<UserDto> getAllUsersDto() {
        List<User> results = getAll();

        List<UserDto> userDtoList = new ArrayList<>();
        for (User result : results) {
            userDtoList.add(fromUser(result));
        }
        return userDtoList;
    }

    @Override
    public UserDto getUserDtoById(long id) {
        return fromUser(findById(id));
    }

    //TODO implement api for registration
    @Override
    public User register(User user) {
        Role roleUser = roleRepository.findByName("ROLE_USER");
        List<Role> userRoles = new ArrayList<>();
        userRoles.add(roleUser);

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(userRoles);
        user.setCreated(new Date());
        user.setUpdated(new Date());
        user.setStatus(Status.ACTIVE);

        //user.setTestResult(null);

        User registeredUser = userRepository.save(user);

        log.info("IN register - user: {} successfully registered", registeredUser);
        return registeredUser;
    }

    @Override
    public List<User> getAll() {
        List<User> result = userRepository.findAll();
        log.info("IN getAll - {} users found", result.size());
        return result;
    }

    @Override
    public User findByUsername(String username) {
        User result = userRepository.findByUsername(username);
        log.info("IN findByUsername - user: {} found by username: {}", result, username);
        return result;
    }

    @Override
    public User findById(Long id) {
        User result = userRepository.findById(id).orElse(null);
        if (result == null) {
            log.warn("IN findById - no user found by id: {}", id);
            return null;
        }
        log.info("IN findById  - user: {} found by id: {}", result, id);
        return result;
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
        log.info("IN delete - user with id: {} successfully deleted", id);
    }
}
