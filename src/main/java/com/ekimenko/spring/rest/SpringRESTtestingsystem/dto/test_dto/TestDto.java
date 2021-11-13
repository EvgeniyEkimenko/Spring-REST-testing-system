package com.ekimenko.spring.rest.SpringRESTtestingsystem.dto.test_dto;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.test.Test;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.service.question_service.question_service_util.QuestionServiceUtil;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.service.test_service.test_result_service_util.TestResultServiceUtil;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TestDto {
    private Long id;
    private String name;
    private Long requeredScore;
    private Long numberAttempt;

    private List<Long> questionId;
    private List<Long> testResultId;
    private Long lessonStepId;


    public Test toTestResult(){
        Test test = new Test();
        test.setId(id);
        test.setName(name);
        test.setRequeredScore(requeredScore);
        test.setNumberAttempts(numberAttempt);

        return test;
    }

    public static TestDto fromTest(Test test) {
        TestDto testDto = new TestDto();
        testDto.setId(test.getId());
        testDto.setName(test.getName());
        testDto.setRequeredScore(test.getRequeredScore());
        testDto.setNumberAttempt(test.getNumberAttempts());

        testDto.setLessonStepId(test.getLessonStep().getId());
        testDto.setTestResultId(TestResultServiceUtil.getAllIdFromTestResultList(test.getTestResults()));
        testDto.setQuestionId(QuestionServiceUtil.getAllIdFromQuestionList(test.getQuestions()));

        return testDto;
    }


}