package com.ekimenko.spring.rest.SpringRESTtestingsystem.dto.test_dto;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.test.Test;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TestDto {
    private Long id;
    private String name;
    private Long requeredScore;
    private Long numberAttempt;

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

        return testDto;
    }
}