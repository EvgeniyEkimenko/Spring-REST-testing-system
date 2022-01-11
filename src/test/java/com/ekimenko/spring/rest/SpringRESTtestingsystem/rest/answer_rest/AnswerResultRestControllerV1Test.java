package com.ekimenko.spring.rest.SpringRESTtestingsystem.rest.answer_rest;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.dto.answer_dto.AnswerResultDto;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.answer.AnswerResult;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.answer.AnswerVariant;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.question.Question;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.test.TestResult;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.service.answer_service.AnswerResultService;
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
@AutoConfigureRestDocs(outputDir = "target/generated-snippets/answer-result")
@SpringBootTest
@AutoConfigureMockMvc
class AnswerResultRestControllerV1Test {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private AnswerResultService answerResultService;

    @BeforeEach
    public void setUp(WebApplicationContext webApplicationContext,
                      RestDocumentationContextProvider restDocumentation) {

        this.mvc = MockMvcBuilders
                .webAppContextSetup(webApplicationContext)
                .apply(documentationConfiguration(restDocumentation))
                .alwaysDo(document("answer-result/{method-name}",
                        preprocessRequest(prettyPrint()), preprocessResponse(prettyPrint())))
                .build();
    }

    @Test
    void getAnswerResultById() throws Exception {
        AnswerResultDto expectedAnswerResultDto = new AnswerResultDto();
        expectedAnswerResultDto.setId(1L);
        expectedAnswerResultDto.setScore(0D);
        expectedAnswerResultDto.setQuestionId(1L);
        expectedAnswerResultDto.setAnswerVariantsId(List.of(1L));
        expectedAnswerResultDto.setTestResultId(1L);

        when(answerResultService
                .getAnswerResultDtoById(1L))
                .thenReturn(expectedAnswerResultDto);

        mvc.perform(MockMvcRequestBuilders
                        .get("/api/v1/answer-result/{id}", 1L)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void getAllAnswerResult() throws Exception {
        AnswerResultDto expectedAnswerResultDto = new AnswerResultDto();
        expectedAnswerResultDto.setId(1L);
        expectedAnswerResultDto.setScore(0D);
        expectedAnswerResultDto.setQuestionId(1L);
        expectedAnswerResultDto.setAnswerVariantsId(List.of(1L));
        expectedAnswerResultDto.setTestResultId(1L);

        List<AnswerResultDto> expectedAnswerResultDtoList = new ArrayList<>();
        expectedAnswerResultDtoList.add(expectedAnswerResultDto);

        when(answerResultService
                .getAllAnswerResultDto())
                .thenReturn(expectedAnswerResultDtoList);

        mvc.perform(MockMvcRequestBuilders
                        .get("/api/v1/answer-result/all")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void addNewAnswerResult() throws Exception {
        List<AnswerVariant> answerVariantList = new ArrayList<>();

        AnswerVariant answerVariant = new AnswerVariant();
        Question question = new Question();
        TestResult testResult = new TestResult();

        answerVariant.setId(1L);
        question.setId(1L);
        testResult.setId(1L);

        answerVariantList.add(answerVariant);

        AnswerResultDto expectedAnswerResultDto = new AnswerResultDto();
        expectedAnswerResultDto.setId(1L);
        expectedAnswerResultDto.setScore(0D);
        expectedAnswerResultDto.setQuestionId(1L);
        expectedAnswerResultDto.setAnswerVariantsId(List.of(1L));
        expectedAnswerResultDto.setTestResultId(1L);

        AnswerResult answerResult = new AnswerResult();
        answerResult.setScore(0D);
        answerResult.setQuestion(question);
        answerResult.setAnswerVariants(answerVariantList);
        answerResult.setTestResult(testResult);

        AnswerResultDto inputAnswerResultDto = new AnswerResultDto();
        inputAnswerResultDto.setScore(0D);
        inputAnswerResultDto.setQuestionId(1L);
        inputAnswerResultDto.setAnswerVariantsId(List.of(1L));
        inputAnswerResultDto.setTestResultId(1L);

        when(answerResultService.
                toAnswerResult(inputAnswerResultDto))
                .thenReturn(answerResult);

        when(answerResultService
                .addNewAnswerResult(answerResult))
                .thenReturn(expectedAnswerResultDto);

        mvc.perform(MockMvcRequestBuilders
                        .post("/api/v1/answer-result")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(inputAnswerResultDto)))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void updateAnswerResult() throws Exception {
        List<AnswerVariant> answerVariantList = new ArrayList<>();

        AnswerVariant answerVariant = new AnswerVariant();
        Question question = new Question();
        TestResult testResult = new TestResult();

        answerVariant.setId(1L);
        question.setId(1L);
        testResult.setId(1L);

        answerVariantList.add(answerVariant);

        AnswerResultDto expectedAnswerResultDto = new AnswerResultDto();
        expectedAnswerResultDto.setId(1L);
        expectedAnswerResultDto.setScore(0D);
        expectedAnswerResultDto.setQuestionId(1L);
        expectedAnswerResultDto.setAnswerVariantsId(List.of(1L));
        expectedAnswerResultDto.setTestResultId(1L);

        AnswerResult answerResult = new AnswerResult();
        answerResult.setId(1L);
        answerResult.setScore(0D);
        answerResult.setQuestion(question);
        answerResult.setAnswerVariants(answerVariantList);
        answerResult.setTestResult(testResult);

        AnswerResultDto inputAnswerResultDto = new AnswerResultDto();
        inputAnswerResultDto.setId(1L);
        inputAnswerResultDto.setScore(0D);
        inputAnswerResultDto.setQuestionId(1L);
        inputAnswerResultDto.setAnswerVariantsId(List.of(1L));
        inputAnswerResultDto.setTestResultId(1L);

        when(answerResultService.
                toAnswerResult(inputAnswerResultDto))
                .thenReturn(answerResult);

        when(answerResultService
                .updateAnswerResult(answerResult))
                .thenReturn(expectedAnswerResultDto);

        mvc.perform(MockMvcRequestBuilders
                        .put("/api/v1/answer-result")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(inputAnswerResultDto)))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void deleteAnswerResultByID() throws Exception {
        mvc.perform(MockMvcRequestBuilders.delete("/api/v1/answer-result/{id}", 1L))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void setPointsForTheAnswer() throws Exception {
        AnswerResultDto expectedAnswerResultDto = new AnswerResultDto();
        expectedAnswerResultDto.setId(1L);
        expectedAnswerResultDto.setScore(0D);
        expectedAnswerResultDto.setQuestionId(1L);
        expectedAnswerResultDto.setAnswerVariantsId(List.of(1L));
        expectedAnswerResultDto.setTestResultId(1L);

        AnswerResultDto inputAnswerResultDto = new AnswerResultDto();
        inputAnswerResultDto.setId(1L);
        inputAnswerResultDto.setScore(0D);
        inputAnswerResultDto.setQuestionId(1L);
        inputAnswerResultDto.setAnswerVariantsId(List.of(1L));
        inputAnswerResultDto.setTestResultId(1L);

        when(answerResultService
                .setPoints(inputAnswerResultDto))
                .thenReturn(expectedAnswerResultDto);

        mvc.perform(MockMvcRequestBuilders
                        .post("/api/v1/answer-result/check_answer")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(inputAnswerResultDto)))
                .andDo(print())
                .andExpect(status().isOk());

    }
}