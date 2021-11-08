package com.ekimenko.spring.rest.SpringRESTtestingsystem.repository.user_repos;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.user.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
