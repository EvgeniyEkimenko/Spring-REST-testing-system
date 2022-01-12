package com.ekimenko.spring.rest.SpringRESTtestingsystem.rest.question_rest;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.dto.question_dto.QuestionDto;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.answer.AnswerResult;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.answer.AnswerVariant;
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
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders;
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
@AutoConfigureRestDocs(outputDir = "target/generated-snippets/question")
@SpringBootTest
@AutoConfigureMockMvc
class QuestionRestControllerV1Test {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private QuestionService questionService;


    @Test
    void getQuestionById() throws Exception {
        QuestionDto expectedQuestionDto = new QuestionDto();
        expectedQuestionDto.setId(1L);
        expectedQuestionDto.setText("testText");
        expectedQuestionDto.setPosition(1);
        expectedQuestionDto.setAllowedParticleAnswer(false);
        expectedQuestionDto.setScore(1D);
        expectedQuestionDto.setAnswerResultsId(List.of(1L));
        expectedQuestionDto.setTestId(1L);
        expectedQuestionDto.setAnswerVariantsId(List.of(1L));

        when(questionService
                .getQuestionDtoById(1L))
                .thenReturn(expectedQuestionDto);

        mvc.perform(RestDocumentationRequestBuilders
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
        expectedQuestionDto.setAnswerResultsId(List.of(1L));
        expectedQuestionDto.setTestId(1L);
        expectedQuestionDto.setAnswerVariantsId(List.of(1L));

        List<QuestionDto> expectedQuestionDtoList = new ArrayList<>();
        expectedQuestionDtoList.add(expectedQuestionDto);

        when(questionService
                .getAllQuestionsDto())
                .thenReturn(expectedQuestionDtoList);

        mvc.perform(RestDocumentationRequestBuilders
                        .get("/api/v1/question/all")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void addNewQuestion() throws Exception {
        List<AnswerResult> answerResultList = new ArrayList<>();
        List<AnswerVariant> answerVariantList = new ArrayList<>();

        com.ekimenko.spring.rest.SpringRESTtestingsystem.model.test.Test test =
                new com.ekimenko.spring.rest.SpringRESTtestingsystem.model.test.Test();
        AnswerResult answerResult = new AnswerResult();
        AnswerVariant answerVariant = new AnswerVariant();

        test.setId(1L);
        answerResult.setId(1L);
        answerVariant.setId(1L);

        answerResultList.add(answerResult);
        answerVariantList.add(answerVariant);

        QuestionDto expectedQuestionDto = new QuestionDto();
        expectedQuestionDto.setId(1L);
        expectedQuestionDto.setText("testText");
        expectedQuestionDto.setPosition(1);
        expectedQuestionDto.setAllowedParticleAnswer(false);
        expectedQuestionDto.setScore(1D);
        expectedQuestionDto.setAnswerResultsId(List.of(1L));
        expectedQuestionDto.setTestId(1L);
        expectedQuestionDto.setAnswerVariantsId(List.of(1L));

        Question question = new Question();
        question.setText("testText");
        question.setPosition(1);
        question.setAllowedParticleAnswer(false);
        question.setScore(1D);
        question.setAnswerResults(answerResultList);
        question.setTest(test);
        question.setAnswerVariants(answerVariantList);

        QuestionDto inputQuestionDto = new QuestionDto();
        inputQuestionDto.setText("testText");
        inputQuestionDto.setPosition(1);
        inputQuestionDto.setAllowedParticleAnswer(false);
        inputQuestionDto.setScore(1D);
        inputQuestionDto.setAnswerResultsId(List.of(1L));
        inputQuestionDto.setTestId(1L);
        inputQuestionDto.setAnswerVariantsId(List.of(1L));

        when(questionService.
                toQuestion(inputQuestionDto))
                .thenReturn(question);

        when(questionService
                .addNewQuestion(question))
                .thenReturn(expectedQuestionDto);

        mvc.perform(RestDocumentationRequestBuilders
                        .post("/api/v1/question")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(inputQuestionDto)))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void updateQuestion() throws Exception {
        List<AnswerResult> answerResultList = new ArrayList<>();
        List<AnswerVariant> answerVariantList = new ArrayList<>();

        com.ekimenko.spring.rest.SpringRESTtestingsystem.model.test.Test test =
                new com.ekimenko.spring.rest.SpringRESTtestingsystem.model.test.Test();
        AnswerResult answerResult = new AnswerResult();
        AnswerVariant answerVariant = new AnswerVariant();

        test.setId(1L);
        answerResult.setId(1L);
        answerVariant.setId(1L);

        answerResultList.add(answerResult);
        answerVariantList.add(answerVariant);

        QuestionDto expectedQuestionDto = new QuestionDto();
        expectedQuestionDto.setId(1L);
        expectedQuestionDto.setText("testText");
        expectedQuestionDto.setPosition(1);
        expectedQuestionDto.setAllowedParticleAnswer(false);
        expectedQuestionDto.setScore(1D);
        expectedQuestionDto.setAnswerResultsId(List.of(1L));
        expectedQuestionDto.setTestId(1L);
        expectedQuestionDto.setAnswerVariantsId(List.of(1L));

        Question question = new Question();
        question.setId(1L);
        question.setText("testText");
        question.setPosition(1);
        question.setAllowedParticleAnswer(false);
        question.setScore(1D);
        question.setAnswerResults(answerResultList);
        question.setTest(test);
        question.setAnswerVariants(answerVariantList);

        QuestionDto inputQuestionDto = new QuestionDto();
        inputQuestionDto.setId(1L);
        inputQuestionDto.setText("testText");
        inputQuestionDto.setPosition(1);
        inputQuestionDto.setAllowedParticleAnswer(false);
        inputQuestionDto.setScore(1D);
        inputQuestionDto.setAnswerResultsId(List.of(1L));
        inputQuestionDto.setTestId(1L);
        inputQuestionDto.setAnswerVariantsId(List.of(1L));

        when(questionService.
                toQuestion(inputQuestionDto))
                .thenReturn(question);

        when(questionService
                .updateQuestion(question))
                .thenReturn(expectedQuestionDto);

        mvc.perform(RestDocumentationRequestBuilders
                        .put("/api/v1/question")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(inputQuestionDto)))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void deleteQuestionByID() throws Exception {
        mvc.perform(RestDocumentationRequestBuilders.delete("/api/v1/question/{id}", 1L))
                .andDo(print())
                .andExpect(status().isOk());
    }
}