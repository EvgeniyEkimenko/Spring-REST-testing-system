package com.ekimenko.spring.rest.SpringRESTtestingsystem.repository.test_repos;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.test.Test;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<Test, Long> {
}
