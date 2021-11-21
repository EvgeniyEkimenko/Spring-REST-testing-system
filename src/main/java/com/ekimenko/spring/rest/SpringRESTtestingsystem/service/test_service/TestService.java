package com.ekimenko.spring.rest.SpringRESTtestingsystem.service.test_service;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.dto.test_dto.TestDto;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.test.Test;

import java.util.List;

public interface TestService {

    Test toTest(TestDto testDto);

    TestDto fromTest(Test test);

    List<TestDto> getAllTestsDto();

    TestDto getTestDtoById(long id);

    List<Test> getAllTests();

    TestDto addNewTest(Test test);

    TestDto updateTest(Test test);

    Test getTestById(Long id);

    void deleteTestById(Long id);

}
