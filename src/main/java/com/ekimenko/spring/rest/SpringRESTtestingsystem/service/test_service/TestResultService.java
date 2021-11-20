package com.ekimenko.spring.rest.SpringRESTtestingsystem.service.test_service;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.dto.question_dto.QuestionDto;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.dto.test_dto.TestResultDto;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.question.Question;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.test.TestResult;

import java.util.List;

public interface TestResultService {


    void startTest(Long id);

    void finishTest(Long id);

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
