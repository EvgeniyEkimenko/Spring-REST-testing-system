package com.ekimenko.spring.rest.SpringRESTtestingsystem.dto.test_dto;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.test.TestResult;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

//FIXME new fields have been added (userId , testId)

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TestResultDto {
    private Long id;
    private Double score;
    private Long testId;

    public TestResult toTestResult(){
        TestResult testResult = new TestResult();
        testResult.setId(id);
        testResult.setScore(score);
        //FIXME testResult.setTestId(testId);

        return testResult;
    }

    public static TestResultDto fromTestResult(TestResult testResult) {
        TestResultDto testResultDto = new TestResultDto();
        testResultDto.setId(testResult.getId());
        testResultDto.setScore(testResult.getScore());

        testResultDto.setTestId(testResult.getTestId().getId());

        return testResultDto;
    }
}
