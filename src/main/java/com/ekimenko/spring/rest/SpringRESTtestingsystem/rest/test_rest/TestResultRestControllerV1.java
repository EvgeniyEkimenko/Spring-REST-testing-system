package com.ekimenko.spring.rest.SpringRESTtestingsystem.rest.test_rest;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.dto.test_dto.TestResultDto;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.test.TestResult;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.service.test_service.TestResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping(value = "/api/v1/test_result")
public class TestResultRestControllerV1 {

    private final TestResultService testResultService;

    @Autowired
    public TestResultRestControllerV1(TestResultService testResult) {
        this.testResultService = testResult;
    }


 /*   @GetMapping(value = "/{id}")
    public ResponseEntity<TestResultDto> getTestResultById(@PathVariable long id){
        TestResult result = testResultService.getTestResultById(id);
        TestResultDto resultDto = TestResultDto.fromTestResult(result);
        return new ResponseEntity<>(resultDto, HttpStatus.OK);
    }

    @GetMapping(value = "")
    public ResponseEntity<List<TestResultDto>> getAllTestResults() {
        List<TestResult> testResultList = testResultService.getAllTestResults();

        List<TestResultDto> testResultDtoLists = new ArrayList<>();
        for (TestResult result : testResultList) {
            testResultDtoLists.add(TestResultDto.fromTestResult(result));
        }
        return new ResponseEntity<>(testResultDtoLists , HttpStatus.OK);
    }

    @PostMapping(value = "")
    public void addNewTestResult(@RequestBody TestResultDto testResultDto) {

        //TODO solve the problem of implementing the save and update methods
    }

    @PutMapping(value = "")
    public void updateTestResult(@RequestBody TestResultDto testResultDto) {

        //TODO solve the problem of implementing the save and update methods

    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<HttpStatus> deleteTestResultById(@PathVariable long id) {    //доделать

        testResultService.deleteTestResultById(id);  //должна возвращать подтверждение операции или исключение

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/all/{score}")
    public ResponseEntity<List<TestResultDto>> findAllTestResultByScore(@PathVariable double score) {
        List<TestResult> testResultList = testResultService.findAllTestResultByScore(score);

        List<TestResultDto> testResultDtoLists = new ArrayList<>();
        for (TestResult result : testResultList) {
            testResultDtoLists.add(TestResultDto.fromTestResult(result));
        }
        return new ResponseEntity<>(testResultDtoLists , HttpStatus.OK);
    }
*/
}
