package com.ekimenko.spring.rest.SpringRESTtestingsystem.service.test_service;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.dto.test_dto.TestResultDto;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.test.TestResult;

import java.util.List;

public interface TestResultService {

    boolean checkAllTestResultsForCompletion(List<Long> testResultsId);

    TestResult toTestResult(TestResultDto testResultDto);

    TestResultDto startTest(Long id);

    TestResultDto finishTest(Long id);

    TestResultDto fromTestResult(TestResult testResult);

    List<TestResultDto> getAllTestResultsDto();

    TestResultDto getTestResultDtoById(long id);

    List<TestResult> getAllTestResults();

    void addNewTestResult(TestResult testRes);

    void updateTestResult(TestResult testRes);

    TestResult getTestResultById(Long id);

    void deleteTestResultById(Long id);

    List<TestResult> findAllTestResultByScore(Double score);


}
