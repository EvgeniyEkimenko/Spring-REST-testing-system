package com.ekimenko.spring.rest.SpringRESTtestingsystem.service.test_service.impl;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.test.Test;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.repository.test_repos.TestRepository;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.service.test_service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class TestServiceImpl implements TestService {

    private final TestRepository testRepository;

    @Autowired
    public TestServiceImpl(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    @Override
    public List<Test> getAllTests() {
        List<Test> tests = testRepository.findAll();
        log.info("IN getAllTests - {} tests found", tests.size());
        return tests;
    }

    @Override
    public void addNewTest(Test test) {
        //TODO add log info
        testRepository.save(test);
    }

    @Override
    public void updateTest(Test test) {
        //TODO add log info
        testRepository.save(test);
    }


    @Override
    public Test getTestById(Long id) {
        Test test = testRepository.findById(id).orElse(null);
        if (test == null) {
            log.warn("IN getTestById - no tests found by id: {}", id);
            return null;
        }
        log.info("IN getTestById  - test: {} found by id: {}", test, id);
        return test;
    }

    @Override
    public void deleteTestById(Long id) {
        testRepository.deleteById(id);
        log.info("IN deleteTestById - Test with id: {} successfully deleted", id);
    }
}
