package com.ekimenko.spring.rest.SpringRESTtestingsystem.service.test_service.impl;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.test.TestResult;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.repository.test_repos.TestResultRepository;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.service.test_service.TestResultService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class TestResultServiceImpl implements TestResultService {

    private final TestResultRepository testResultRepository;

    @Autowired
    public TestResultServiceImpl(TestResultRepository testResultRepository) {
        this.testResultRepository = testResultRepository;
    }


    @Override
    public List<TestResult> getAllTestResults() {
        List<TestResult> testRes = testResultRepository.findAll();
        log.info("IN getAllTestResults - {} TestResults found", testRes.size());
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

        TestResult result = testResultRepository.findById(id).orElse(null);
        if (result == null) {
            log.warn("IN getTestResultById - no results found by id: {}", id);
            return null;
        }
        log.info("IN getTestResultById  - result: {} found by id: {}", result, id);
        return result;
    }

    @Override
    public void deleteTestResultById(Long id) {
        testResultRepository.deleteById(id);
        log.info("IN deleteTestResultById - TestResult with id: {} successfully deleted", id);
    }

    @Override
    public List<TestResult> findAllTestResultByScore(Double score) {
        List<TestResult> testRes = testResultRepository.findAllByScore(score);
        //TODO add log info
        return testRes;
    }
}
