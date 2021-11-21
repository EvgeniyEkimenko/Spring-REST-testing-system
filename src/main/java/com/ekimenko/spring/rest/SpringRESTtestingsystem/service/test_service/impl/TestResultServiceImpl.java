package com.ekimenko.spring.rest.SpringRESTtestingsystem.service.test_service.impl;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.dto.test_dto.TestResultDto;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.test.TestResult;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.user.User;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.repository.test_repos.TestResultRepository;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.service.service_util.ServiceUtil;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.service.test_service.TestResultService;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.service.test_service.TestService;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.service.user_service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class TestResultServiceImpl implements TestResultService {

    private final TestResultRepository testResultRepository;
    private final TestService testService;
    private final UserService userService;

    @Autowired
    public TestResultServiceImpl(TestResultRepository testResultRepository
            , @Lazy TestService testService
            , @Lazy UserService userService) {
        this.testResultRepository = testResultRepository;
        this.testService = testService;
        this.userService = userService;
    }

    @Override
    public boolean checkAllTestResultsForCompletion(List<Long> testResultsId) {

        for (Long testResult : testResultsId) {
            if (!getTestResultById(testResult).getTestScore()) return false;
        }
        return true;
    }

    @Override
    public TestResult toTestResult(TestResultDto testResultDto) {
        TestResult testResult = new TestResult();
        testResult.setId(testResultDto.getId());
        testResult.setTestScore(testResultDto.isTestScore());
        testResult.setScore(testResult.getScore());
        testResult.setComplete(testResultDto.isComplete());
        testResult.setTest(testService.getTestById(testResultDto.getTestId()));
        testResult.setUser(userService.findById(testResultDto.getUserId()));
        //testResult.setAnswerResults();
        return testResult;
    }

    @Override
    public TestResultDto startTest(Long id) {
        TestResult testResult = new TestResult();
        testResult.setTest(testService.getTestById(id));
        //FIXME testResult.setUser(getUserByTestId(id));
        testResult.setTestScore(false);
        testResult.setComplete(false);
        testResult.setScore(0D);
        addNewTestResult(testResult);
        return fromTestResult(testResult);
    }

    public User getUserByTestId(Long id) {
        //FIXME User user = testService.getTestById(id).getLessonStep().getLesson().getCourse()....
        //FIXME Temp functional
        User user = new User();
        user.setFirstName("TEMP_NAME");
        return user;
    }

    @Override
    public TestResultDto finishTest(Long id) {
        TestResult testResult = getTestResultById(id);
        if (testResult.getScore() >= testResult.getTest().getRequeredScore()) testResult.setTestScore(true);
        testResult.setComplete(true);
        updateTestResult(testResult);
        return fromTestResult(testResult);
    }

    @Override
    public TestResultDto fromTestResult(TestResult testResult) {
        TestResultDto testResultDto = new TestResultDto();
        testResultDto.setId(testResult.getId());
        testResultDto.setScore(testResult.getScore());
        testResultDto.setTestId(testResult.getTest().getId());
        testResultDto.setComplete(testResult.getComplete());
        //FIXME testResultDto.setUserId(testResult.getUser().getId()); Решить проблема получения user id
        testResultDto.setAnswerResultsId(ServiceUtil.getIds(testResult.getAnswerResults()));
        testResultDto.setTestScore(testResult.getTestScore());
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
    public TestResultDto addNewTestResult(TestResult testRes) {
        TestResult testResultResult = testResultRepository.save(testRes);
        //TODO add log info
        return fromTestResult(testResultResult);
    }

    @Override
    public TestResultDto updateTestResult(TestResult testRes) {
        TestResult testResultResult = testResultRepository.save(testRes);
        //TODO add log info
        return fromTestResult(testResultResult);
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
