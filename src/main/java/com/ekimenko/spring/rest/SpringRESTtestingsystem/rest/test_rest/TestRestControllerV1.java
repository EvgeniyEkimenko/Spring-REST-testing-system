package com.ekimenko.spring.rest.SpringRESTtestingsystem.rest.test_rest;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.dto.test_dto.TestDto;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.test.Test;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.service.test_service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/test")
public class TestRestControllerV1 {

    private final TestService testService;

    @Autowired
    public TestRestControllerV1(TestService testService) {
        this.testService = testService;
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<TestDto> getTestById(@PathVariable long id) {
        Test test = testService.getTestById(id);

        TestDto testDto = TestDto.fromTest(test);

        return new ResponseEntity<>(testDto, HttpStatus.OK);
    }

    @GetMapping(value = "")
    public ResponseEntity<List<TestDto>> getAllTests() {
        List<Test> testList = testService.getAllTests();

        List<TestDto> testDtoList = new ArrayList<>();
        for (Test test : testList) {
            testDtoList.add(TestDto.fromTest(test));
        }
        return new ResponseEntity<>(testDtoList, HttpStatus.OK);
    }

    @PostMapping(value = "")
    public void addNewTest(@RequestBody TestDto answerResultDto) {

        //TODO solve the problem of implementing the save and update methods
    }

    @PutMapping(value = "")
    public void updateTest(@RequestBody TestDto answerResultDto) {

        //TODO solve the problem of implementing the save and update methods

    }

    @DeleteMapping(value = "/{id}")
    public void deleteTestByID(@PathVariable long id) {

        testService.deleteTestById(id);

    }

}
