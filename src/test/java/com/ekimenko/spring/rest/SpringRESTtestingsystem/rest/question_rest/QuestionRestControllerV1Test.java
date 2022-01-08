package com.ekimenko.spring.rest.SpringRESTtestingsystem.rest.question_rest;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.dto.question_dto.QuestionDto;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.question.Question;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.service.question_service.QuestionService;
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
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith({RestDocumentationExtension.class, SpringExtension.class})
@AutoConfigureRestDocs(outputDir = "target/generated-snippets")
@SpringBootTest
@AutoConfigureMockMvc
class QuestionRestControllerV1Test {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private QuestionService questionService;

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
    void getQuestionById() throws Exception {
        QuestionDto expectedQuestionDto = new QuestionDto();
        expectedQuestionDto.setId(1L);
        expectedQuestionDto.setText("testText");
        expectedQuestionDto.setPosition(1);
        expectedQuestionDto.setAllowedParticleAnswer(false);
        expectedQuestionDto.setScore(1D);
        expectedQuestionDto.setAnswerResultsId(Collections.emptyList());
        expectedQuestionDto.setTestId(null);
        expectedQuestionDto.setAnswerVariantsId(Collections.emptyList());

        when(questionService
                .getQuestionDtoById(1L))
                .thenReturn(expectedQuestionDto);

        mvc.perform(MockMvcRequestBuilders
                        .get("/api/v1/question/{id}", 1L)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void getAllQuestions() throws Exception {
        QuestionDto expectedQuestionDto = new QuestionDto();
        expectedQuestionDto.setId(1L);
        expectedQuestionDto.setText("testText");
        expectedQuestionDto.setPosition(1);
        expectedQuestionDto.setAllowedParticleAnswer(false);
        expectedQuestionDto.setScore(1D);
        expectedQuestionDto.setAnswerResultsId(Collections.emptyList());
        expectedQuestionDto.setTestId(null);
        expectedQuestionDto.setAnswerVariantsId(Collections.emptyList());

        List<QuestionDto> expectedQuestionDtoList = new ArrayList<>();
        expectedQuestionDtoList.add(expectedQuestionDto);

        when(questionService
                .getAllQuestionsDto())
                .thenReturn(expectedQuestionDtoList);

        mvc.perform(MockMvcRequestBuilders
                        .get("/api/v1/question/all")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void addNewQuestion() throws Exception {
        QuestionDto expectedQuestionDto = new QuestionDto();
        expectedQuestionDto.setId(1L);
        expectedQuestionDto.setText("testText");
        expectedQuestionDto.setPosition(1);
        expectedQuestionDto.setAllowedParticleAnswer(false);
        expectedQuestionDto.setScore(1D);
        expectedQuestionDto.setAnswerResultsId(Collections.emptyList());
        expectedQuestionDto.setTestId(null);
        expectedQuestionDto.setAnswerVariantsId(Collections.emptyList());

        Question question = new Question();
        question.setText("testText");
        question.setPosition(1);
        question.setAllowedParticleAnswer(false);
        question.setScore(1D);
        question.setAnswerResults(Collections.emptyList());
        question.setTest(null);
        question.setAnswerVariants(Collections.emptyList());

        QuestionDto inputQuestionDto = new QuestionDto();
        inputQuestionDto.setText("testText");
        inputQuestionDto.setPosition(1);
        inputQuestionDto.setAllowedParticleAnswer(false);
        inputQuestionDto.setScore(1D);
        inputQuestionDto.setAnswerResultsId(Collections.emptyList());
        inputQuestionDto.setTestId(null);
        inputQuestionDto.setAnswerVariantsId(Collections.emptyList());

        when(questionService.
                toQuestion(inputQuestionDto))
                .thenReturn(question);

        when(questionService
                .addNewQuestion(question))
                .thenReturn(expectedQuestionDto);

        mvc.perform(MockMvcRequestBuilders
                        .post("/api/v1/question")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(inputQuestionDto)))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void updateQuestion() throws Exception {
        QuestionDto expectedQuestionDto = new QuestionDto();
        expectedQuestionDto.setId(1L);
        expectedQuestionDto.setText("testText");
        expectedQuestionDto.setPosition(1);
        expectedQuestionDto.setAllowedParticleAnswer(false);
        expectedQuestionDto.setScore(1D);
        expectedQuestionDto.setAnswerResultsId(Collections.emptyList());
        expectedQuestionDto.setTestId(null);
        expectedQuestionDto.setAnswerVariantsId(Collections.emptyList());

        Question question = new Question();
        question.setId(1L);
        question.setText("testText");
        question.setPosition(1);
        question.setAllowedParticleAnswer(false);
        question.setScore(1D);
        question.setAnswerResults(Collections.emptyList());
        question.setTest(null);
        question.setAnswerVariants(Collections.emptyList());

        QuestionDto inputQuestionDto = new QuestionDto();
        inputQuestionDto.setTestId(1L);
        inputQuestionDto.setText("testText");
        inputQuestionDto.setPosition(1);
        inputQuestionDto.setAllowedParticleAnswer(false);
        inputQuestionDto.setScore(1D);
        inputQuestionDto.setAnswerResultsId(Collections.emptyList());
        inputQuestionDto.setTestId(null);
        inputQuestionDto.setAnswerVariantsId(Collections.emptyList());

        when(questionService.
                toQuestion(inputQuestionDto))
                .thenReturn(question);

        when(questionService
                .updateQuestion(question))
                .thenReturn(expectedQuestionDto);

        mvc.perform(MockMvcRequestBuilders
                        .put("/api/v1/question")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(inputQuestionDto)))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void deleteQuestionByID() throws Exception {
        mvc.perform(MockMvcRequestBuilders.delete("/api/v1/question/{id}", 1L))
                .andDo(print())
                .andExpect(status().isOk());
    }
}