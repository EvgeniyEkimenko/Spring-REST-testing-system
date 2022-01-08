package com.ekimenko.spring.rest.SpringRESTtestingsystem.rest.test_rest;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.dto.test_dto.TestResultDto;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.answer.AnswerResult;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.test.TestResult;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.user.User;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.service.test_service.TestResultService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith({RestDocumentationExtension.class, SpringExtension.class})
@AutoConfigureRestDocs(outputDir = "target/generated-snippets")
@SpringBootTest
@AutoConfigureMockMvc
class TestResultRestControllerV1Test {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private TestResultService testResultService;

    @BeforeEach
    public void setUp(WebApplicationContext webApplicationContext,
                      RestDocumentationContextProvider restDocumentation) {

        this.mvc = MockMvcBuilders
                .webAppContextSetup(webApplicationContext)
                .apply(documentationConfiguration(restDocumentation))
                .alwaysDo(document("{method-name}",
                        preprocessRequest(prettyPrint()), preprocessResponse(prettyPrint())))
                .build();
    }

    @Test
    void getTestResultById() throws Exception {
        TestResultDto expectedTestResultDto = new TestResultDto();
        expectedTestResultDto.setId(1L);
        expectedTestResultDto.setTestScore(false);
        expectedTestResultDto.setScore(0.0);
        expectedTestResultDto.setComplete(false);
        expectedTestResultDto.setUserId(1L);
        expectedTestResultDto.setTestId(1L);
        expectedTestResultDto.setAnswerResultsId(List.of(1L));

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
        expectedTestResultDto.setUserId(1L);
        expectedTestResultDto.setTestId(1L);
        expectedTestResultDto.setAnswerResultsId(List.of(1L));

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
        User user = new User();
        com.ekimenko.spring.rest.SpringRESTtestingsystem.model.test.Test test =
                new com.ekimenko.spring.rest.SpringRESTtestingsystem.model.test.Test();

        test.setId(1L);
        user.setId(1L);

        List<AnswerResult> answerResultList = new ArrayList<>();
        AnswerResult answerResult = new AnswerResult();
        answerResult.setId(1L);
        answerResultList.add(answerResult);

        TestResultDto expectedTestResultDto = new TestResultDto();
        expectedTestResultDto.setId(1L);
        expectedTestResultDto.setTestScore(false);
        expectedTestResultDto.setScore(0.0);
        expectedTestResultDto.setComplete(false);
        expectedTestResultDto.setUserId(1L);
        expectedTestResultDto.setTestId(1L);
        expectedTestResultDto.setAnswerResultsId(List.of(1L));

        TestResult testResult = new TestResult();
        testResult.setTestScore(false);
        testResult.setScore(0.0);
        testResult.setComplete(false);
        testResult.setUser(user);
        testResult.setTest(test);
        testResult.setAnswerResults(answerResultList);

        TestResultDto inputTestResultDto = new TestResultDto();
        inputTestResultDto.setTestScore(false);
        inputTestResultDto.setScore(0.0);
        inputTestResultDto.setComplete(false);
        inputTestResultDto.setUserId(1L);
        inputTestResultDto.setTestId(1L);
        inputTestResultDto.setAnswerResultsId(List.of(1L));

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
        User user = new User();
        com.ekimenko.spring.rest.SpringRESTtestingsystem.model.test.Test test =
                new com.ekimenko.spring.rest.SpringRESTtestingsystem.model.test.Test();

        test.setId(1L);
        user.setId(1L);

        List<AnswerResult> answerResultList = new ArrayList<>();
        AnswerResult answerResult = new AnswerResult();
        answerResult.setId(1L);
        answerResultList.add(answerResult);

        TestResultDto expectedTestResultDto = new TestResultDto();
        expectedTestResultDto.setId(1L);
        expectedTestResultDto.setTestScore(false);
        expectedTestResultDto.setScore(0.0);
        expectedTestResultDto.setComplete(false);
        expectedTestResultDto.setUserId(1L);
        expectedTestResultDto.setTestId(1L);
        expectedTestResultDto.setAnswerResultsId(List.of(1L));

        TestResult testResult = new TestResult();
        testResult.setId(1L);
        testResult.setTestScore(false);
        testResult.setScore(0.0);
        testResult.setComplete(false);
        testResult.setUser(user);
        testResult.setTest(test);
        testResult.setAnswerResults(answerResultList);

        TestResultDto inputTestResultDto = new TestResultDto();
        inputTestResultDto.setId(1L);
        inputTestResultDto.setTestScore(false);
        inputTestResultDto.setScore(0.0);
        inputTestResultDto.setComplete(false);
        inputTestResultDto.setUserId(1L);
        inputTestResultDto.setTestId(1L);
        inputTestResultDto.setAnswerResultsId(List.of(1L));

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
        expectedTestResultDto.setUserId(1L);
        expectedTestResultDto.setTestId(1L);
        expectedTestResultDto.setAnswerResultsId(List.of(1L));

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
        expectedTestResultDto.setUserId(1L);
        expectedTestResultDto.setTestId(1L);
        expectedTestResultDto.setAnswerResultsId(List.of(1L));

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