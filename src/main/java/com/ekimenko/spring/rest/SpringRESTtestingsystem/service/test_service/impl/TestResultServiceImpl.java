package com.ekimenko.spring.rest.SpringRESTtestingsystem.service.test_service.impl;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.dto.test_dto.TestResultDto;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.test.TestResult;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.repository.test_repos.TestResultRepository;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.service.service_util.ServiceUtil;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.service.test_service.TestResultService;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.service.test_service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class TestResultServiceImpl implements TestResultService {

    private final TestResultRepository testResultRepository;
    private final TestService testService;

    @Autowired
    public TestResultServiceImpl(TestResultRepository testResultRepository, TestService testService) {
        this.testResultRepository = testResultRepository;
        this.testService = testService;
    }

    @Override
    public void startTest(Long id) {
        TestResult testResult = new TestResult();
        testResult.setTest(testService.getTestById(id));
        testResult.setScore(0D);
        testResult.setComplete(false);
        addNewTestResult(testResult);
    }

    @Override
    public void finishTest(Long id) {
        TestResult testResult = getTestResultById(id);
        if (testResult.getScore() >= testResult.getTest().getRequeredScore()) testResult.setComplete(true);
    }

    @Override
    public TestResultDto fromTestResult(TestResult testResult) {
        TestResultDto testResultDto = new TestResultDto();
        testResultDto.setId(testResult.getId());
        testResultDto.setScore(testResult.getScore());
        testResultDto.setTestId(testResult.getTest().getId());
        testResultDto.setUserId(testResult.getUser().getId());
        testResultDto.setAnswerResultsId(ServiceUtil.getIds(testResult.getAnswerResults()));

        return testResultDto;
    }

    @Override
    public List<TestResultDto> getAllTestResultsDto() {
        List<TestResult> results = getAllTestResults();

        List<TestResultDto> testResultDtoList = new ArrayList<>();
        for (TestResult result : results) {
            testResultDtoList.add(fromTestResult(result));
        }
        return testResultDtoList;
    }

    @Override
    public TestResultDto getTestResultDtoById(long id) {
        return fromTestResult(getTestResultById(id));
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
