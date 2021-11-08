package com.ekimenko.spring.rest.SpringRESTtestingsystem.service.test_service.impl;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.test.TestResult;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.repository.test_repos.TestResultRepository;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.service.test_service.TestResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TestResultServiceImpl implements TestResultService {

    private final TestResultRepository testResultRepository;

    @Autowired
    public TestResultServiceImpl(TestResultRepository testResultRepository) {
        this.testResultRepository = testResultRepository;
    }


    @Override
    public List<TestResult> getAllTestResults() {
        List<TestResult> testRes = testResultRepository.findAll();
        //TODO add log info
        return testRes;
    }

    @Override
    public void addNewTestResult(TestResult testRes) {
        testResultRepository.save(testRes);
    }

    @Override
    public void updateTestResult(TestResult testRes) {
        testResultRepository.save(testRes);
    }


    @Override
    public TestResult getTestResultById(Long id) {

        Optional<TestResult> result = testResultRepository.findById(id);

        if (result.isPresent()) return result.get();
        //FIXME
        else throw new NullPointerException();
    }

    @Override
    public void deleteTestResultById(Long id) {
        testResultRepository.deleteById(id);
        //TODO add log info
    }

    @Override
    public List<TestResult> findAllTestResultByScore(Double score) {
        List<TestResult> testRes = testResultRepository.findAllByScore(score);
        //TODO add log info
        return testRes;
    }
}
