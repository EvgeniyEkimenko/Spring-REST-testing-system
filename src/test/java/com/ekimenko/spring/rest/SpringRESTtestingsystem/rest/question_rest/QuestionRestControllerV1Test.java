package com.ekimenko.spring.rest.SpringRESTtestingsystem.rest.question_rest;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.dto.question_dto.QuestionDto;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.question.Question;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.service.question_service.QuestionService;
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
        expectedQuestionDto.setText("testText");
        expectedQuestionDto.setPosition(1);
        expectedQuestionDto.setAllowedParticleAnswer(false);
        expectedQuestionDto.setScore(1D);
        expectedQuestionDto.setAnswerResultsId(Collections.emptyList());
        expectedQuestionDto.setTestId(null);
        expectedQuestionDto.setAnswerVariantsId(Collections.emptyList());

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
        expectedQuestionDto.setText("testText");
        expectedQuestionDto.setPosition(1);
        expectedQuestionDto.setAllowedParticleAnswer(false);
        expectedQuestionDto.setScore(1D);
        expectedQuestionDto.setAnswerResultsId(Collections.emptyList());
        expectedQuestionDto.setTestId(null);
        expectedQuestionDto.setAnswerVariantsId(Collections.emptyList());

        when(questionService
                .updateQuestion(question))
                .thenReturn(expectedQuestionDto);

        mvc.perform(MockMvcRequestBuilders
                        .post("/api/v1/question")
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