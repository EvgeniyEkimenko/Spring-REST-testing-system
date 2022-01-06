package com.ekimenko.spring.rest.SpringRESTtestingsystem.service.user_service.impl;


import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.user.User;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.repository.user_repos.RoleRepository;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.repository.user_repos.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;
    @Mock
    private RoleRepository roleRepository;
    @Mock
    private BCryptPasswordEncoder passwordEncoder;
    @InjectMocks
    private UserServiceImpl underTestUser;

    private User user;

    @BeforeEach
    void setUp() {
        user = new User();
        user.setId(1L);
        user.setFirstName("test");
        user.setEmail("testEmail");
        user.setLastName("testName");
        user.setCourse(null);
        user.setTestResults(null);
    }

    @Test
    void fromUser() {
    }

    @Test
    void getAllUsersDto() {
    }

    @Test
    void getUserDtoById() {
    }

    @Test
    @Disabled
    void register() {
        //FIXME
    }

    @Test
    void getAll() {
    }

    @Test
    void findByUsername() {
    }

    @Test
    void findById() {
    }

    @Test
    void delete() {
    }
}