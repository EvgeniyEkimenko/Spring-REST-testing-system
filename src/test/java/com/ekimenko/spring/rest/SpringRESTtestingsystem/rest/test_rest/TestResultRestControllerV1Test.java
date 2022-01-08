package com.ekimenko.spring.rest.SpringRESTtestingsystem.rest.test_rest;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.dto.test_dto.TestResultDto;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.test.TestResult;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.service.test_service.TestResultService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class TestResultRestControllerV1Test {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private TestResultService testResultService;

    @Test
    void getTestResultById() throws Exception {
        TestResultDto expectedTestResultDto = new TestResultDto();
        expectedTestResultDto.setId(1L);
        expectedTestResultDto.setTestScore(false);
        expectedTestResultDto.setScore(0.0);
        expectedTestResultDto.setComplete(false);
        expectedTestResultDto.setUserId(null);
        expectedTestResultDto.setTestId(1L);
        expectedTestResultDto.setAnswerResultsId(Collections.emptyList());

        when(testResultService
                .getTestResultDtoById(1L))
                .thenReturn(expectedTestResultDto);

        mvc.perform(MockMvcRequestBuilders
                        .get("/api/v1/test-result/{id}", 1L)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());

    }

    @Test
    void getAllTestResults() throws Exception {
        TestResultDto expectedTestResultDto = new TestResultDto();
        expectedTestResultDto.setId(1L);
        expectedTestResultDto.setTestScore(false);
        expectedTestResultDto.setScore(0.0);
        expectedTestResultDto.setComplete(false);
        expectedTestResultDto.setUserId(null);
        expectedTestResultDto.setTestId(1L);
        expectedTestResultDto.setAnswerResultsId(Collections.emptyList());

        List<TestResultDto> expectedTestResultDtoList = new ArrayList<>();
        expectedTestResultDtoList.add(expectedTestResultDto);

        when(testResultService
                .getAllTestResultsDto())
                .thenReturn(expectedTestResultDtoList);

        mvc.perform(MockMvcRequestBuilders
                        .get("/api/v1/test-result/all")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void addNewTestResult() throws Exception {
        TestResultDto expectedTestResultDto = new TestResultDto();
        expectedTestResultDto.setId(1L);
        expectedTestResultDto.setTestScore(false);
        expectedTestResultDto.setScore(0.0);
        expectedTestResultDto.setComplete(false);
        expectedTestResultDto.setUserId(null);
        expectedTestResultDto.setTestId(null);
        expectedTestResultDto.setAnswerResultsId(Collections.emptyList());

        TestResult testResult = new TestResult();
        testResult.setTestScore(false);
        testResult.setScore(0.0);
        testResult.setComplete(false);
        testResult.setUser(null);
        testResult.setTest(null);
        testResult.setAnswerResults(Collections.emptyList());

        TestResultDto inputTestResultDto = new TestResultDto();
        inputTestResultDto.setTestScore(false);
        inputTestResultDto.setScore(0.0);
        inputTestResultDto.setComplete(false);
        inputTestResultDto.setUserId(null);
        inputTestResultDto.setTestId(null);
        inputTestResultDto.setAnswerResultsId(Collections.emptyList());

        when(testResultService.
                toTestResult(inputTestResultDto))
                .thenReturn(testResult);

        when(testResultService
                .addNewTestResult(testResult))
                .thenReturn(expectedTestResultDto);

        mvc.perform(MockMvcRequestBuilders
                        .post("/api/v1/test-result")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(inputTestResultDto)))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void updateTestResult() throws Exception {
        TestResultDto expectedTestResultDto = new TestResultDto();
        expectedTestResultDto.setId(1L);
        expectedTestResultDto.setTestScore(false);
        expectedTestResultDto.setScore(0.0);
        expectedTestResultDto.setComplete(false);
        expectedTestResultDto.setUserId(null);
        expectedTestResultDto.setTestId(null);
        expectedTestResultDto.setAnswerResultsId(Collections.emptyList());

        TestResult testResult = new TestResult();
        expectedTestResultDto.setId(1L);
        testResult.setTestScore(false);
        testResult.setScore(0.0);
        testResult.setComplete(false);
        testResult.setUser(null);
        testResult.setTest(null);
        testResult.setAnswerResults(Collections.emptyList());

        TestResultDto inputTestResultDto = new TestResultDto();
        expectedTestResultDto.setId(1L);
        inputTestResultDto.setTestScore(false);
        inputTestResultDto.setScore(0.0);
        inputTestResultDto.setComplete(false);
        inputTestResultDto.setUserId(null);
        inputTestResultDto.setTestId(null);
        inputTestResultDto.setAnswerResultsId(Collections.emptyList());

        when(testResultService.
                toTestResult(inputTestResultDto))
                .thenReturn(testResult);

        when(testResultService
                .updateTestResult(testResult))
                .thenReturn(expectedTestResultDto);

        mvc.perform(MockMvcRequestBuilders
                        .put("/api/v1/test-result")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(inputTestResultDto)))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void deleteTestResultById() throws Exception {
        mvc.perform(MockMvcRequestBuilders.delete("/api/v1/test-result/{id}", 1L))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void start() throws Exception {
        TestResultDto expectedTestResultDto = new TestResultDto();
        expectedTestResultDto.setId(1L);
        expectedTestResultDto.setTestScore(false);
        expectedTestResultDto.setScore(0.0);
        expectedTestResultDto.setComplete(false);
        expectedTestResultDto.setUserId(null);
        expectedTestResultDto.setTestId(null);
        expectedTestResultDto.setAnswerResultsId(Collections.emptyList());

        when(testResultService
                .startTest(1L))
                .thenReturn(expectedTestResultDto);

        mvc.perform(MockMvcRequestBuilders
                        .post("/api/v1/test-result/start/{id}", 1L)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void finish() throws Exception {
        TestResultDto expectedTestResultDto = new TestResultDto();
        expectedTestResultDto.setId(1L);
        expectedTestResultDto.setTestScore(false);
        expectedTestResultDto.setScore(0.0);
        expectedTestResultDto.setComplete(false);
        expectedTestResultDto.setUserId(null);
        expectedTestResultDto.setTestId(null);
        expectedTestResultDto.setAnswerResultsId(Collections.emptyList());

        when(testResultService
                .finishTest(1L))
                .thenReturn(expectedTestResultDto);

        mvc.perform(MockMvcRequestBuilders
                        .post("/api/v1/test-result/finish/{id}", 1L)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }
}