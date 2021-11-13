package com.ekimenko.spring.rest.SpringRESTtestingsystem.dto.test_dto;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.test.TestResult;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.service.answer_service.AnswerServiceUtil.AnswerResultServiceUtil;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

//FIXME new fields have been added (userId , testId)

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TestResultDto {
    private Long id;
    private Double score;
    private Long testId;
    private Long userId;
    private List<Long> answerResultsId;

    public TestResult toTestResult(){
        TestResult testResult = new TestResult();
        testResult.setId(id);
        testResult.setScore(score);
        //TODO

        return testResult;
    }

    public static TestResultDto fromTestResult(TestResult testResult) {
        TestResultDto testResultDto = new TestResultDto();
        testResultDto.setId(testResult.getId());
        testResultDto.setScore(testResult.getScore());
        testResultDto.setTestId(testResult.getTest().getId());
        testResultDto.setUserId(testResult.getUser().getId());
        testResultDto.setAnswerResultsId(AnswerResultServiceUtil.getAllIdFromAnswerResultList(testResult.getAnswerResults()));

        return testResultDto;
    }
}
