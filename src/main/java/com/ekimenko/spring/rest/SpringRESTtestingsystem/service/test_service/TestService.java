package com.ekimenko.spring.rest.SpringRESTtestingsystem.service.test_service;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.test.Test;

import java.util.List;

public interface TestService {

    List<Test> getAllTests();

    void addNewTest(Test test);

    void updateTest(Test test);

    Test getTestById(Long id);

    void deleteTestById(Long id);

}
