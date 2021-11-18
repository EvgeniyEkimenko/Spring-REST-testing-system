package com.ekimenko.spring.rest.SpringRESTtestingsystem.dto.test_dto;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.test.TestResult;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;



@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TestResultDto {
    private Long id;
    private Double score;
    private Long testId;
    private Long userId;
    private boolean complete;
    private List<Long> answerResultsId;

    public TestResult toTestResult(){
        TestResult testResult = new TestResult();
        testResult.setId(id);
        //TODO add code
        return testResult;
    }

}
