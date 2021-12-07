package com.ekimenko.spring.rest.SpringRESTtestingsystem.service.test_service.impl;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.dto.test_dto.TestResultDto;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.test.TestResult;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.repository.test_repos.TestResultRepository;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.service.test_service.TestService;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.service.user_service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class TestResultServiceImplTest {

    @Mock
    private TestResultRepository testResultRepository;
    @Mock
    private TestService testService;
    @Mock
    private UserService userService;
    @InjectMocks
    private TestResultServiceImpl underTestResult;

    private TestResult testResult;

    @BeforeEach
    void setUp() {
        testResult = new TestResult();
        testResult.setId(1L);
        testResult.setTestScore(false);
        testResult.setScore(1D);
        testResult.setComplete(false);
        testResult.setUser(null);
        testResult.setTest(null);
        testResult.setAnswerResults(null);
    }

    @Test
    @Disabled
    void checkAllTestResultsForCompletion() {

    }

    @Test
    @Disabled
    void toTestResult() {
    }

    @Test
    void startTest() {
        //given
        TestResultDto expectedTestResultDto = new TestResultDto();
        expectedTestResultDto.setId(1L);
        expectedTestResultDto.setTestScore(false);
        expectedTestResultDto.setScore(0.0);
        expectedTestResultDto.setComplete(false);
        expectedTestResultDto.setUserId(null);
        expectedTestResultDto.setTestId(1L);
        expectedTestResultDto.setAnswerResultsId(Collections.emptyList());

        com.ekimenko.spring.rest.SpringRESTtestingsystem.model.test.Test test =
                new com.ekimenko.spring.rest.SpringRESTtestingsystem.model.test.Test();
        test.setId(1L);
        test.setName("testName");
        test.setNumberAttempts(1L);
        test.setRequeredScore(1L);
        test.setQuestions(null);
        test.setTestResults(null);
        test.setLessonStep(null);

        TestResult testResultS = new TestResult();
        testResultS.setId(null);
        testResultS.setTestScore(false);
        testResultS.setScore(0.0);
        testResultS.setComplete(false);
        testResultS.setUser(null);
        testResultS.setAnswerResults(null);
        testResultS.setTest(test);

        TestResult testResultReturn = new TestResult();
        testResultReturn.setId(1L);
        testResultReturn.setTestScore(false);
        testResultReturn.setScore(0.0);
        testResultReturn.setComplete(false);
        testResultReturn.setUser(null);
        testResultReturn.setAnswerResults(null);
        testResultReturn.setTest(test);
        //when
        Mockito.when(testService.getTestById(1L)).thenReturn(test);
        Mockito.when(testResultRepository.save(testResultS)).thenReturn(testResultReturn);
        TestResultDto actualTestResultDto = underTestResult.startTest(1L);
        //then
        assertThat(actualTestResultDto).isEqualTo(expectedTestResultDto);
    }

    @Test
    @Disabled
    void getUserByTestId() {
        //FIXME
    }

    @Test
    void finishTest() {
        //given
        com.ekimenko.spring.rest.SpringRESTtestingsystem.model.test.Test test =
                new com.ekimenko.spring.rest.SpringRESTtestingsystem.model.test.Test();
        test.setId(1L);
        test.setName("testName");
        test.setNumberAttempts(1L);
        test.setRequeredScore(2L);
        test.setQuestions(null);
        test.setTestResults(null);
        test.setLessonStep(null);

        TestResult testResultS = new TestResult();
        testResultS.setId(null);
        testResultS.setTestScore(false);
        testResultS.setScore(3.0);
        testResultS.setComplete(false);
        testResultS.setUser(null);
        testResultS.setAnswerResults(null);
        testResultS.setTest(test);

        TestResult testResultForUpdate = new TestResult();
        testResultForUpdate.setId(null);
        testResultForUpdate.setTestScore(true);
        testResultForUpdate.setScore(3.0);
        testResultForUpdate.setComplete(true);
        testResultForUpdate.setUser(null);
        testResultForUpdate.setAnswerResults(null);
        testResultForUpdate.setTest(test);

        TestResultDto expectedTestResult = new TestResultDto();
        expectedTestResult.setId(null);
        expectedTestResult.setTestScore(true);
        expectedTestResult.setScore(3.0);
        expectedTestResult.setComplete(true);
        expectedTestResult.setUserId(null);
        expectedTestResult.setAnswerResultsId(Collections.emptyList());
        expectedTestResult.setTestId(1L);

        //when
        Mockito.when(testResultRepository.findById(1L)).thenReturn(java.util.Optional.of(testResultS));
        Mockito.when(testResultRepository.save(testResultForUpdate)).thenReturn(testResultForUpdate);
        TestResultDto actualTestResultDto = underTestResult.finishTest(1L);
        //then
        assertThat(actualTestResultDto).isEqualTo(expectedTestResult);


    }

    @Test
    void fromTestResult() {
        //given
        TestResultDto expectedTestResultDto = new TestResultDto();
        expectedTestResultDto.setId(1L);
        expectedTestResultDto.setTestScore(false);
        expectedTestResultDto.setScore(1D);
        expectedTestResultDto.setComplete(false);
        expectedTestResultDto.setUserId(null);
        expectedTestResultDto.setTestId(null);
        expectedTestResultDto.setAnswerResultsId(Collections.emptyList());
        //when
        TestResultDto actualTestResultDto = underTestResult.fromTestResult(testResult);
        //then
        assertThat(actualTestResultDto).isEqualTo(expectedTestResultDto);
    }

    @Test
    void getAllTestResultsDto() {
        //given
        TestResult anotherTestResult = new TestResult();
        anotherTestResult.setId(2L);
        anotherTestResult.setTestScore(false);
        anotherTestResult.setScore(1D);
        anotherTestResult.setComplete(false);
        anotherTestResult.setUser(null);
        anotherTestResult.setTest(null);
        anotherTestResult.setAnswerResults(null);

        TestResultDto testResultDto = new TestResultDto();
        testResultDto.setId(1L);
        testResultDto.setTestScore(false);
        testResultDto.setScore(1D);
        testResultDto.setComplete(false);
        testResultDto.setUserId(null);
        testResultDto.setTestId(null);
        testResultDto.setAnswerResultsId(Collections.emptyList());

        TestResultDto anotherTestResultDto = new TestResultDto();
        anotherTestResultDto.setId(2L);
        anotherTestResultDto.setTestScore(false);
        anotherTestResultDto.setScore(1D);
        anotherTestResultDto.setComplete(false);
        anotherTestResultDto.setUserId(null);
        anotherTestResultDto.setTestId(null);
        anotherTestResultDto.setAnswerResultsId(Collections.emptyList());

        List<TestResult> testResultList = new ArrayList<>();
        List<TestResultDto> expectedTestResultDtoList = new ArrayList<>();
        testResultList.add(testResult);
        testResultList.add(anotherTestResult);
        expectedTestResultDtoList.add(testResultDto);
        expectedTestResultDtoList.add(anotherTestResultDto);
        //when
        Mockito.when(testResultRepository.findAll()).thenReturn(testResultList);
        List<TestResultDto> actualTestResultDtoList = underTestResult.getAllTestResultsDto();
        //then
        assertThat(actualTestResultDtoList).isEqualTo(expectedTestResultDtoList);
    }

    @Test
    void getTestResultDtoById() {
        //given
        TestResultDto expectedTestResultDto = new TestResultDto();
        expectedTestResultDto.setId(1L);
        expectedTestResultDto.setTestScore(false);
        expectedTestResultDto.setScore(1D);
        expectedTestResultDto.setComplete(false);
        expectedTestResultDto.setUserId(null);
        expectedTestResultDto.setTestId(null);
        expectedTestResultDto.setAnswerResultsId(Collections.emptyList());
        //when
        Mockito.when(testResultRepository.findById(1L)).thenReturn(java.util.Optional.ofNullable(testResult));
        TestResultDto actualTestResultDto = underTestResult.getTestResultDtoById(1L);
        //then
        assertThat(actualTestResultDto).isEqualTo(expectedTestResultDto);
    }

    @Test
    void getAllTestResults() {
        //given
        TestResult anotherTestResult = new TestResult();
        anotherTestResult.setId(2L);
        anotherTestResult.setTestScore(false);
        anotherTestResult.setScore(1D);
        anotherTestResult.setComplete(false);
        anotherTestResult.setUser(null);
        anotherTestResult.setTest(null);
        anotherTestResult.setAnswerResults(null);

        List<TestResult> expectedTestResultList = new ArrayList<>();
        expectedTestResultList.add(testResult);
        expectedTestResultList.add(anotherTestResult);
        //when
        Mockito.when(testResultRepository.findAll()).thenReturn(expectedTestResultList);
        List<TestResult> actualTestResultList = underTestResult.getAllTestResults();
        //then
        assertThat(actualTestResultList).isEqualTo(expectedTestResultList);
    }

    @Test
    void addNewTestResult() {
        //given
        TestResultDto expectedTestResultDto = new TestResultDto();
        expectedTestResultDto.setId(1L);
        expectedTestResultDto.setTestScore(false);
        expectedTestResultDto.setScore(1D);
        expectedTestResultDto.setComplete(false);
        expectedTestResultDto.setUserId(null);
        expectedTestResultDto.setTestId(null);
        expectedTestResultDto.setAnswerResultsId(Collections.emptyList());
        //when
        Mockito.when(testResultRepository.save(testResult)).thenReturn(testResult);
        TestResultDto actualTestResultDto = underTestResult.addNewTestResult(testResult);
        //then
        assertThat(actualTestResultDto).isEqualTo(expectedTestResultDto);
    }

    @Test
    void updateTestResult() {
        //given
        TestResultDto expectedTestResultDto = new TestResultDto();
        expectedTestResultDto.setId(1L);
        expectedTestResultDto.setTestScore(false);
        expectedTestResultDto.setScore(1D);
        expectedTestResultDto.setComplete(false);
        expectedTestResultDto.setUserId(null);
        expectedTestResultDto.setTestId(null);
        expectedTestResultDto.setAnswerResultsId(Collections.emptyList());
        //when
        Mockito.when(testResultRepository.save(testResult)).thenReturn(testResult);
        TestResultDto actualTestResultDto = underTestResult.updateTestResult(testResult);
        //then
        assertThat(actualTestResultDto).isEqualTo(expectedTestResultDto);
    }

    @Test
    void getTestResultById() {
        //given
        TestResult expectedTestResultDto = testResult;
        //when
        Mockito.when(testResultRepository.findById(1L)).thenReturn(java.util.Optional.ofNullable(testResult));
        TestResult actualTestResult = underTestResult.getTestResultById(1L);
        //then
        assertThat(actualTestResult).isEqualTo(expectedTestResultDto);
    }

    @Test
    void deleteTestResultById() {
        underTestResult.deleteTestResultById(1L);
        verify(testResultRepository).deleteById(1L);
    }
}