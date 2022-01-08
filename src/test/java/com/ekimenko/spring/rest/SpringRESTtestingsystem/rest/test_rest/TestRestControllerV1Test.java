package com.ekimenko.spring.rest.SpringRESTtestingsystem.rest.test_rest;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.dto.test_dto.TestDto;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.service.test_service.TestService;
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
class TestRestControllerV1Test {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private TestService testService;

    @Test
    void getTestById() throws Exception {
        TestDto expectedTestDto = new TestDto();
        expectedTestDto.setId(1L);
        expectedTestDto.setName("testName");
        expectedTestDto.setNumberAttempt(1L);
        expectedTestDto.setQuestionsId(Collections.emptyList());
        expectedTestDto.setLessonStepId(null);
        expectedTestDto.setTestResultId(Collections.emptyList());

        when(testService
                .getTestDtoById(1L))
                .thenReturn(expectedTestDto);

        mvc.perform(MockMvcRequestBuilders
                        .get("/api/v1/test/{id}", 1L)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void getAllTests() throws Exception {
        TestDto expectedTestDto = new TestDto();
        expectedTestDto.setId(1L);
        expectedTestDto.setName("testName");
        expectedTestDto.setNumberAttempt(1L);
        expectedTestDto.setQuestionsId(Collections.emptyList());
        expectedTestDto.setLessonStepId(null);
        expectedTestDto.setTestResultId(Collections.emptyList());

        List<TestDto> expectedTestDtoList = new ArrayList<>();
        expectedTestDtoList.add(expectedTestDto);

        when(testService
                .getAllTestsDto())
                .thenReturn(expectedTestDtoList);

        mvc.perform(MockMvcRequestBuilders
                        .get("/api/v1/test/all")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void addNewTest() throws Exception {
        TestDto expectedTestDto = new TestDto();
        expectedTestDto.setId(1L);
        expectedTestDto.setName("testName");
        expectedTestDto.setNumberAttempt(1L);
        expectedTestDto.setQuestionsId(Collections.emptyList());
        expectedTestDto.setLessonStepId(null);
        expectedTestDto.setTestResultId(Collections.emptyList());

        com.ekimenko.spring.rest.SpringRESTtestingsystem.model.test.Test test =
                new com.ekimenko.spring.rest.SpringRESTtestingsystem.model.test.Test();
        test.setName("testName");
        test.setNumberAttempts(1L);
        test.setQuestions(Collections.emptyList());
        test.setLessonStep(null);
        test.setTestResults(Collections.emptyList());

        TestDto inputTestDto = new TestDto();
        inputTestDto.setName("testName");
        inputTestDto.setNumberAttempt(1L);
        inputTestDto.setQuestionsId(Collections.emptyList());
        inputTestDto.setLessonStepId(null);
        inputTestDto.setTestResultId(Collections.emptyList());

        when(testService.
                toTest(inputTestDto))
                .thenReturn(test);

        when(testService
                .addNewTest(test))
                .thenReturn(expectedTestDto);

        mvc.perform(MockMvcRequestBuilders
                        .post("/api/v1/test")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(inputTestDto)))
                .andDo(print())
                .andExpect(status().isOk());

    }

    @Test
    void updateTest() throws Exception {
        TestDto expectedTestDto = new TestDto();
        expectedTestDto.setId(1L);
        expectedTestDto.setName("testName");
        expectedTestDto.setNumberAttempt(1L);
        expectedTestDto.setQuestionsId(Collections.emptyList());
        expectedTestDto.setLessonStepId(null);
        expectedTestDto.setTestResultId(Collections.emptyList());

        com.ekimenko.spring.rest.SpringRESTtestingsystem.model.test.Test test =
                new com.ekimenko.spring.rest.SpringRESTtestingsystem.model.test.Test();
        test.setId(1L);
        test.setName("testName");
        test.setNumberAttempts(1L);
        test.setQuestions(Collections.emptyList());
        test.setLessonStep(null);
        test.setTestResults(Collections.emptyList());

        TestDto inputTestDto = new TestDto();
        inputTestDto.setId(1L);
        inputTestDto.setName("testName");
        inputTestDto.setNumberAttempt(1L);
        inputTestDto.setQuestionsId(Collections.emptyList());
        inputTestDto.setLessonStepId(null);
        inputTestDto.setTestResultId(Collections.emptyList());

        when(testService.
                toTest(inputTestDto))
                .thenReturn(test);

        when(testService
                .updateTest(test))
                .thenReturn(expectedTestDto);

        mvc.perform(MockMvcRequestBuilders
                        .put("/api/v1/test")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(inputTestDto)))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void deleteTestByID() throws Exception {
        mvc.perform(MockMvcRequestBuilders.delete("/api/v1/test/{id}", 1L))
                .andDo(print())
                .andExpect(status().isOk());
    }
}