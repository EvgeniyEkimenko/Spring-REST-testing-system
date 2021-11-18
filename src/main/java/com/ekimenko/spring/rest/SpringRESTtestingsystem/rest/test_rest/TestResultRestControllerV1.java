package com.ekimenko.spring.rest.SpringRESTtestingsystem.rest.test_rest;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.dto.test_dto.TestResultDto;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.test.TestResult;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.service.test_service.TestResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/api/v1/test_result")
public class TestResultRestControllerV1 {

    private final TestResultService testResultService;

    @Autowired
    public TestResultRestControllerV1(TestResultService testResult) {
        this.testResultService = testResult;
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<TestResultDto> getTestResultById(@PathVariable long id) {

        TestResultDto resultDto = testResultService.getTestResultDtoById(id);

        return new ResponseEntity<>(resultDto, HttpStatus.OK);
    }

    @GetMapping(value = "")
    public ResponseEntity<List<TestResultDto>> getAllTestResults() {

        List<TestResultDto> testResultDtoLists = testResultService.getAllTestResultsDto();

        return new ResponseEntity<>(testResultDtoLists, HttpStatus.OK);
    }

    @PostMapping(value = "")
    public void addNewTestResult(@RequestBody TestResultDto testResultDto) {

        TestResult testResult = testResultDto.toTestResult();
        testResultService.addNewTestResult(testResult);
    }

    @PutMapping(value = "")
    public void updateTestResult(@RequestBody TestResultDto testResultDto) {

        TestResult testResult = testResultDto.toTestResult();
        testResultService.updateTestResult(testResult);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteTestResultById(@PathVariable long id) {    //доделать

        testResultService.deleteTestResultById(id);

    }

}
