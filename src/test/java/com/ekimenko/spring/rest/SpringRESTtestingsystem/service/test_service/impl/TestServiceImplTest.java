package com.ekimenko.spring.rest.SpringRESTtestingsystem.service.test_service.impl;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.dto.test_dto.TestDto;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.repository.test_repos.TestRepository;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.service.lesson_service.LessonStepService;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.service.question_service.QuestionService;
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
class TestServiceImplTest {

    @Mock
    private TestRepository testRepository;
    @Mock
    private LessonStepService lessonService;
    @Mock
    private QuestionService questionService;
    @InjectMocks
    private TestServiceImpl underTest;

    private com.ekimenko.spring.rest.SpringRESTtestingsystem.model.test.Test test;

    @BeforeEach
    void setUp() {
        test = new com.ekimenko.spring.rest.SpringRESTtestingsystem.model.test.Test();
        test.setId(1L);
        test.setName("testName");
        test.setNumberAttempts(1L);
        test.setQuestions(null);
        test.setLessonStep(null);
        test.setTestResults(null);
    }

    @Test
    @Disabled
    void toTest() {
    }

    @Test
    @Disabled
    void getQuestionListByListId() {
    }

    @Test
    void fromTest() {
        //given
        TestDto expectedTestDto = new TestDto();
        expectedTestDto.setId(1L);
        expectedTestDto.setName("testName");
        expectedTestDto.setNumberAttempt(1L);
        expectedTestDto.setQuestionsId(Collections.emptyList());
        expectedTestDto.setLessonStepId(null);
        expectedTestDto.setTestResultId(Collections.emptyList());
        //when
        TestDto actualTestDto = underTest.fromTest(test);
        //then
        assertThat(actualTestDto).isEqualTo(expectedTestDto);
    }

    @Test
    void getAllTestsDto() {
        //given
        com.ekimenko.spring.rest.SpringRESTtestingsystem.model.test.Test anotherTest
                = new com.ekimenko.spring.rest.SpringRESTtestingsystem.model.test.Test();
        anotherTest.setId(2L);
        anotherTest.setName("testName");
        anotherTest.setNumberAttempts(1L);
        anotherTest.setQuestions(null);
        anotherTest.setLessonStep(null);
        anotherTest.setTestResults(null);

        TestDto testDto = new TestDto();
        testDto.setId(1L);
        testDto.setName("testName");
        testDto.setNumberAttempt(1L);
        testDto.setQuestionsId(Collections.emptyList());
        testDto.setLessonStepId(null);
        testDto.setTestResultId(Collections.emptyList());

        TestDto anotherTestDto = new TestDto();
        anotherTestDto.setId(2L);
        anotherTestDto.setName("testName");
        anotherTestDto.setNumberAttempt(1L);
        anotherTestDto.setQuestionsId(Collections.emptyList());
        anotherTestDto.setLessonStepId(null);
        anotherTestDto.setTestResultId(Collections.emptyList());

        List<com.ekimenko.spring.rest.SpringRESTtestingsystem.model.test.Test> testList = new ArrayList<>();
        List<TestDto> expectedTestDtoList = new ArrayList<>();
        testList.add(test);
        testList.add(anotherTest);
        expectedTestDtoList.add(testDto);
        expectedTestDtoList.add(anotherTestDto);
        //when
        Mockito.when(testRepository.findAll()).thenReturn(testList);
        List<TestDto> actualTestDtoList = underTest.getAllTestsDto();
        //then
        assertThat(actualTestDtoList).isEqualTo(expectedTestDtoList);
    }

    @Test
    void getTestDtoById() {
        //given
        TestDto expectedTestDto = new TestDto();
        expectedTestDto.setId(1L);
        expectedTestDto.setName("testName");
        expectedTestDto.setNumberAttempt(1L);
        expectedTestDto.setQuestionsId(Collections.emptyList());
        expectedTestDto.setLessonStepId(null);
        expectedTestDto.setTestResultId(Collections.emptyList());
        //when
        Mockito.when(testRepository.findById(1L)).thenReturn(java.util.Optional.ofNullable(test));
        TestDto actualTestDto = underTest.getTestDtoById(1L);
        //then
        assertThat(actualTestDto).isEqualTo(expectedTestDto);
    }

    @Test
    void getAllTests() {
        //given
        com.ekimenko.spring.rest.SpringRESTtestingsystem.model.test.Test anotherTest
                = new com.ekimenko.spring.rest.SpringRESTtestingsystem.model.test.Test();
        anotherTest.setId(2L);
        anotherTest.setName("testName");
        anotherTest.setNumberAttempts(1L);
        anotherTest.setQuestions(null);
        anotherTest.setLessonStep(null);
        anotherTest.setTestResults(null);

        List<com.ekimenko.spring.rest.SpringRESTtestingsystem.model.test.Test> expectedTestDtoList
                = new ArrayList<>();
        expectedTestDtoList.add(test);
        expectedTestDtoList.add(anotherTest);
        //when
        Mockito.when(testRepository.findAll()).thenReturn(expectedTestDtoList);
        List<com.ekimenko.spring.rest.SpringRESTtestingsystem.model.test.Test> actualTestList
                = underTest.getAllTests();
        //then
        assertThat(actualTestList).isEqualTo(expectedTestDtoList);
    }

    @Test
    void addNewTest() {
        //given
        TestDto expectedTestDto = new TestDto();
        expectedTestDto.setId(1L);
        expectedTestDto.setName("testName");
        expectedTestDto.setNumberAttempt(1L);
        expectedTestDto.setQuestionsId(Collections.emptyList());
        expectedTestDto.setLessonStepId(null);
        expectedTestDto.setTestResultId(Collections.emptyList());
        //when
        Mockito.when(testRepository.save(test)).thenReturn(test);
        TestDto actualTestDto = underTest.addNewTest(test);
        //then
        assertThat(actualTestDto).isEqualTo(expectedTestDto);
    }

    @Test
    void updateTest() {
        //given
        TestDto expectedTestDto = new TestDto();
        expectedTestDto.setId(1L);
        expectedTestDto.setName("testName");
        expectedTestDto.setNumberAttempt(1L);
        expectedTestDto.setQuestionsId(Collections.emptyList());
        expectedTestDto.setLessonStepId(null);
        expectedTestDto.setTestResultId(Collections.emptyList());
        //when
        Mockito.when(testRepository.save(test)).thenReturn(test);
        TestDto actualTestDto = underTest.updateTest(test);
        //then
        assertThat(actualTestDto).isEqualTo(expectedTestDto);
    }

    @Test
    void getTestById() {
        //given
        com.ekimenko.spring.rest.SpringRESTtestingsystem.model.test.Test expectedTest = test;
        //when
        Mockito.when(testRepository.findById(1L)).thenReturn(java.util.Optional.ofNullable(test));
        com.ekimenko.spring.rest.SpringRESTtestingsystem.model.test.Test actualTest
                = underTest.getTestById(1L);
        //then
        assertThat(actualTest).isEqualTo(expectedTest);
    }

    @Test
    void deleteTestById() {
        underTest.deleteTestById(1L);
        verify(testRepository).deleteById(1L);
    }
}