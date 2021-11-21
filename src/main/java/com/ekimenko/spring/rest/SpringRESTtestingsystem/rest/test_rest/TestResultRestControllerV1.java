package com.ekimenko.spring.rest.SpringRESTtestingsystem.rest.test_rest;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.dto.test_dto.TestDto;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.dto.test_dto.TestResultDto;
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
    public ResponseEntity<TestResultDto> addNewTestResult(@RequestBody TestResultDto testResultDto) {

        TestResultDto testResultDtoRes = testResultService
                .addNewTestResult(testResultService
                        .toTestResult(testResultDto));

        return new ResponseEntity<>(testResultDtoRes, HttpStatus.OK);
    }

    @PutMapping(value = "")
    public ResponseEntity<TestResultDto> updateTestResult(@RequestBody TestResultDto testResultDto) {

        TestResultDto testResultDtoRes = testResultService
                .updateTestResult(testResultService
                        .toTestResult(testResultDto));

        return new ResponseEntity<>(testResultDtoRes, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteTestResultById(@PathVariable long id) {    //TODO repair

        testResultService.deleteTestResultById(id);

    }

    @PostMapping(value = "/start/{id}")
    public ResponseEntity<TestResultDto> start(@PathVariable Long id) {
        TestResultDto testResultDto = testResultService.startTest(id);
        return new ResponseEntity<>(testResultDto, HttpStatus.OK);
    }

    @PostMapping(value = "/finish/{id}")
    public ResponseEntity<TestResultDto> finish(@PathVariable Long id) {
        TestResultDto testResultDto = testResultService.finishTest(id);
        return new ResponseEntity<>(testResultDto, HttpStatus.OK);
    }

}
