package com.ekimenko.spring.rest.SpringRESTtestingsystem.repository.user_repos;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User , Long> {
    User findByUsername(String name);
}
