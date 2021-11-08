package com.ekimenko.spring.rest.SpringRESTtestingsystem.service.test_service;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.test.TestResult;

import java.util.List;

public interface TestResultService {

    List<TestResult> getAllTestResults();

    void addNewTestResult(TestResult testRes);

    void updateTestResult(TestResult testRes);

    TestResult getTestResultById(Long id);

    void deleteTestResultById(Long id);

    List<TestResult> findAllTestResultByScore(Double score);


}
