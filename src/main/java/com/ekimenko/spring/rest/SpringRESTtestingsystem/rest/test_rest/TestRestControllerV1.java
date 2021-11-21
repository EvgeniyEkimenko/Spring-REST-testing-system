package com.ekimenko.spring.rest.SpringRESTtestingsystem.rest.test_rest;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.dto.test_dto.TestDto;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.service.test_service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

        TestDto testDto = testService.getTestDtoById(id);

        return new ResponseEntity<>(testDto, HttpStatus.OK);
    }

    @GetMapping(value = "")
    public ResponseEntity<List<TestDto>> getAllTests() {

        List<TestDto> testDtoList = testService.getAllTestsDto();

        return new ResponseEntity<>(testDtoList, HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<TestDto> addNewTest(@RequestBody TestDto testDto) {

        TestDto testDtoRes = testService
                .addNewTest(testService
                        .toTest(testDto));

        return new ResponseEntity<>(testDtoRes, HttpStatus.OK);
    }

    @PutMapping(value = "")
    public ResponseEntity<TestDto> updateTest(@RequestBody TestDto testDto) {

        TestDto testDtoRes = testService
                .updateTest(testService
                        .toTest(testDto));

        return new ResponseEntity<>(testDtoRes, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteTestByID(@PathVariable long id) {

        testService.deleteTestById(id);

    }

}
