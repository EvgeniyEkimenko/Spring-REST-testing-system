package com.ekimenko.spring.rest.SpringRESTtestingsystem.rest.test_rest;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.dto.test_dto.TestDto;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.LessonStep;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.question.Question;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.test.TestResult;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.service.test_service.TestService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith({RestDocumentationExtension.class, SpringExtension.class})
@AutoConfigureRestDocs(outputDir = "target/generated-snippets")
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
        expectedTestDto.setQuestionsId(List.of(1L));
        expectedTestDto.setLessonStepId(1L);
        expectedTestDto.setTestResultId(List.of(1L));

        when(testService
                .getTestDtoById(1L))
                .thenReturn(expectedTestDto);

        mvc.perform(RestDocumentationRequestBuilders
                        .get("/api/v1/test/{id}", 1L)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andDo(document("test/{method-name}", preprocessRequest(prettyPrint())
                        , preprocessResponse(prettyPrint()), pathParameters(parameterWithName("id")
                                .description("Test Unique Identifier"))));
    }

    @Test
    void getTestByIdResponseFieldDocumentation() throws Exception {
        TestDto expectedTestDto = new TestDto();
        expectedTestDto.setId(1L);
        expectedTestDto.setName("testName");
        expectedTestDto.setNumberAttempt(1L);
        expectedTestDto.setQuestionsId(List.of(1L));
        expectedTestDto.setLessonStepId(1L);
        expectedTestDto.setTestResultId(List.of(1L));

        when(testService
                .getTestDtoById(1L))
                .thenReturn(expectedTestDto);

        mvc.perform(RestDocumentationRequestBuilders
                        .get("/api/v1/test/{id}", 1L)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andDo(document("test/{method-name}", preprocessRequest(prettyPrint())
                        , preprocessResponse(prettyPrint()), pathParameters(parameterWithName("id")
                                .description("Test Unique Identifier")), responseFields(fieldWithPath("id")
                                        .description("Test Unique Identifier"),
                                fieldWithPath("name").description("Test name"),
                                fieldWithPath("requeredScore").description("The number of points required to successfully complete the test"),
                                fieldWithPath("numberAttempt").description("Number of attempts"),
                                fieldWithPath("questionsId").description("Question Unique Identifier"),
                                fieldWithPath("testResultId").description("Test Result Unique Identifier"),
                                fieldWithPath("lessonStepId").description("Lesson Unique Identifier"))));
    }

    @Test
    void getAllTests() throws Exception {
        TestDto expectedTestDto = new TestDto();
        expectedTestDto.setId(1L);
        expectedTestDto.setName("testName");
        expectedTestDto.setNumberAttempt(1L);
        expectedTestDto.setQuestionsId(List.of(1L));
        expectedTestDto.setLessonStepId(1L);
        expectedTestDto.setTestResultId(List.of(1L));
        expectedTestDto.setRequeredScore(10L);

        List<TestDto> expectedTestDtoList = new ArrayList<>();
        expectedTestDtoList.add(expectedTestDto);

        when(testService
                .getAllTestsDto())
                .thenReturn(expectedTestDtoList);

        mvc.perform(RestDocumentationRequestBuilders
                        .get("/api/v1/test/all")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andDo(document("test/{method-name}", preprocessRequest(prettyPrint())
                        , preprocessResponse(prettyPrint())));

    }

    @Test
    void addNewTest() throws Exception {
        List<Question> questionList = new ArrayList<>();
        List<TestResult> testResultList = new ArrayList<>();

        Question question = new Question();
        TestResult testResult = new TestResult();
        LessonStep lessonStep = new LessonStep();

        question.setId(1L);
        testResult.setId(1L);
        lessonStep.setId(1L);

        questionList.add(question);
        testResultList.add(testResult);

        TestDto expectedTestDto = new TestDto();
        expectedTestDto.setId(1L);
        expectedTestDto.setName("testName");
        expectedTestDto.setNumberAttempt(1L);
        expectedTestDto.setQuestionsId(List.of(1L));
        expectedTestDto.setLessonStepId(1L);
        expectedTestDto.setTestResultId(List.of(1L));
        expectedTestDto.setRequeredScore(10L);

        com.ekimenko.spring.rest.SpringRESTtestingsystem.model.test.Test test =
                new com.ekimenko.spring.rest.SpringRESTtestingsystem.model.test.Test();
        test.setName("testName");
        test.setNumberAttempts(1L);
        test.setQuestions(questionList);
        test.setLessonStep(lessonStep);
        test.setTestResults(testResultList);
        test.setRequeredScore(10L);

        TestDto inputTestDto = new TestDto();
        inputTestDto.setName("testName");
        inputTestDto.setNumberAttempt(1L);
        inputTestDto.setQuestionsId(List.of(1L));
        inputTestDto.setLessonStepId(1L);
        inputTestDto.setTestResultId(List.of(1L));
        inputTestDto.setRequeredScore(10L);

        when(testService.
                toTest(inputTestDto))
                .thenReturn(test);

        when(testService
                .addNewTest(test))
                .thenReturn(expectedTestDto);

        mvc.perform(RestDocumentationRequestBuilders
                        .post("/api/v1/test")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(inputTestDto)))
                .andDo(print())
                .andExpect(status().isOk())
                .andDo(document("test/{method-name}", preprocessRequest(prettyPrint())
                        , preprocessResponse(prettyPrint())));

    }

    @Test
    void updateTest() throws Exception {
        List<Question> questionList = new ArrayList<>();
        List<TestResult> testResultList = new ArrayList<>();

        Question question = new Question();
        TestResult testResult = new TestResult();
        LessonStep lessonStep = new LessonStep();

        question.setId(1L);
        testResult.setId(1L);
        lessonStep.setId(1L);

        questionList.add(question);
        testResultList.add(testResult);

        TestDto expectedTestDto = new TestDto();
        expectedTestDto.setId(1L);
        expectedTestDto.setName("testName");
        expectedTestDto.setNumberAttempt(1L);
        expectedTestDto.setQuestionsId(List.of(1L));
        expectedTestDto.setLessonStepId(1L);
        expectedTestDto.setTestResultId(List.of(1L));
        expectedTestDto.setRequeredScore(10L);

        com.ekimenko.spring.rest.SpringRESTtestingsystem.model.test.Test test =
                new com.ekimenko.spring.rest.SpringRESTtestingsystem.model.test.Test();
        test.setId(1L);
        test.setName("testName");
        test.setNumberAttempts(1L);
        test.setQuestions(questionList);
        test.setLessonStep(lessonStep);
        test.setTestResults(testResultList);
        test.setRequeredScore(10L);

        TestDto inputTestDto = new TestDto();
        inputTestDto.setId(1L);
        inputTestDto.setName("testName");
        inputTestDto.setNumberAttempt(1L);
        inputTestDto.setQuestionsId(List.of(1L));
        inputTestDto.setLessonStepId(1L);
        inputTestDto.setTestResultId(List.of(1L));
        inputTestDto.setRequeredScore(10L);

        when(testService.
                toTest(inputTestDto))
                .thenReturn(test);

        when(testService
                .updateTest(test))
                .thenReturn(expectedTestDto);

        mvc.perform(RestDocumentationRequestBuilders
                        .put("/api/v1/test")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(inputTestDto)))
                .andDo(print())
                .andExpect(status().isOk())
                .andDo(document("test/{method-name}", preprocessRequest(prettyPrint())
                        , preprocessResponse(prettyPrint())));
    }

    @Test
    void deleteTestByID() throws Exception {
        mvc.perform(RestDocumentationRequestBuilders.delete("/api/v1/test/{id}", 1L))
                .andDo(print())
                .andExpect(status().isOk())
                .andDo(document("test/{method-name}", preprocessRequest(prettyPrint())
                        , preprocessResponse(prettyPrint()), pathParameters(parameterWithName("id")
                                .description("Test Unique Identifier"))));
    }
}