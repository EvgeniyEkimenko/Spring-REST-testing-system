package com.ekimenko.spring.rest.SpringRESTtestingsystem.repository.test_repos;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.test.TestResult;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TestResultRepository extends JpaRepository<TestResult, Long> {


    List<TestResult> findAllByScore(Double score);


}
