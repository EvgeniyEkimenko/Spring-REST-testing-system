package com.ekimenko.spring.rest.SpringRESTtestingsystem.service.test_service.impl;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.test.Test;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.repository.test_repos.TestRepository;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.service.test_service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestServiceImpl implements TestService {

    private final TestRepository testRepository;

    @Autowired
    public TestServiceImpl(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    @Override
    public List<Test> getAllTests() {
        List<Test> tests = testRepository.findAll();
        //TODO add log info
        return tests;
    }

    @Override
    public void addNewTest(Test test) {
        testRepository.save(test);
    }

    @Override
    public void updateTest(Test test) {
        testRepository.save(test);
    }


    @Override
    public Test getTestById(Long id) {
        Test test = testRepository.findById(id).orElse(null);
        if (test == null) {
            //TODO add log info
            return null;
        }
        //TODO add log info
        return test;
    }

    @Override
    public void deleteTestById(Long id) {
        testRepository.deleteById(id);
        //TODO add log info
    }
}
