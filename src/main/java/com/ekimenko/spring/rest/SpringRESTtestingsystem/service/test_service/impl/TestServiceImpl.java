package com.ekimenko.spring.rest.SpringRESTtestingsystem.service.test_service.impl;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.dto.test_dto.TestDto;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.question.Question;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.test.Test;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.repository.test_repos.TestRepository;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.service.lesson_service.LessonStepService;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.service.question_service.QuestionService;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.service.service_util.ServiceUtil;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.service.test_service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class TestServiceImpl implements TestService {

    private final TestRepository testRepository;
    private final LessonStepService lessonService;
    private final QuestionService questionService;

    @Autowired
    public TestServiceImpl(TestRepository testRepository, LessonStepService lessonService, QuestionService questionService) {
        this.testRepository = testRepository;
        this.lessonService = lessonService;
        this.questionService = questionService;
    }

    @Override
    public Test toTest(TestDto testDto) {
        Test test = new Test();
        test.setId(testDto.getId());
        test.setNumberAttempts(testDto.getNumberAttempt());
        test.setRequeredScore(testDto.getRequeredScore());
        test.setName(testDto.getName());
        test.setLessonStep(lessonService.getLessonStepById(testDto.getLessonStepId()));
        test.setQuestions(getQuestionListByListId(testDto.getQuestionsId()));
        return test;
    }

    public List<Question> getQuestionListByListId(List<Long> questionsId) {
        List<Question> questionList = new ArrayList<>();
        for (int i = 0; i < questionsId.size(); i++) {
            questionList.add(questionService.getQuestionById(questionsId.get(i)));
        }
        return questionList;
    }


    @Override
    public TestDto fromTest(Test test) {
        TestDto testDto = new TestDto();
        testDto.setId(test.getId());
        testDto.setName(test.getName());
        testDto.setRequeredScore(test.getRequeredScore());
        testDto.setNumberAttempt(test.getNumberAttempts());
        testDto.setLessonStepId(test.getLessonStep().getId());
        testDto.setQuestionsId(ServiceUtil.getIds(test.getQuestions()));
        testDto.setTestResultId(ServiceUtil.getIds(test.getTestResults()));

        return testDto;
    }

    @Override
    public List<TestDto> getAllTestsDto() {
        List<Test> results = getAllTests();

        List<TestDto> testDtoList = new ArrayList<>();
        for (Test result : results) {
            testDtoList.add(fromTest(result));
        }
        return testDtoList;
    }


    @Override
    public TestDto getTestDtoById(long id) {
        return fromTest(getTestById(id));
    }

    @Override
    public List<Test> getAllTests() {
        List<Test> tests = testRepository.findAll();
        log.info("IN getAllTests - {} tests found", tests.size());
        return tests;
    }

    @Override
    public void addNewTest(Test test) {
        //TODO add log info
        testRepository.save(test);
    }

    @Override
    public void updateTest(Test test) {
        //TODO add log info
        testRepository.save(test);
    }


    @Override
    public Test getTestById(Long id) {
        Test test = testRepository.findById(id).orElse(null);
        if (test == null) {
            log.warn("IN getTestById - no tests found by id: {}", id);
            return null;
        }
        log.info("IN getTestById  - test: {} found by id: {}", test, id);
        return test;
    }

    @Override
    public void deleteTestById(Long id) {
        testRepository.deleteById(id);
        log.info("IN deleteTestById - Test with id: {} successfully deleted", id);
    }
}
