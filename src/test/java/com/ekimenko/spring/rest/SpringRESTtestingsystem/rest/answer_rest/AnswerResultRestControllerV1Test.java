package com.ekimenko.spring.rest.SpringRESTtestingsystem.rest.answer_rest;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.dto.answer_dto.AnswerResultDto;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.answer.AnswerResult;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.service.answer_service.AnswerResultService;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.service.answer_service.AnswerVariantService;
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
class AnswerResultRestControllerV1Test {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private AnswerResultService answerResultService;

    @Test
    void getAnswerResultById() throws Exception {
        AnswerResultDto expectedAnswerResultDto = new AnswerResultDto();
        expectedAnswerResultDto.setId(1L);
        expectedAnswerResultDto.setScore(0D);
        expectedAnswerResultDto.setQuestionId(1L);
        expectedAnswerResultDto.setAnswerVariantsId(Collections.emptyList());
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
    void getAllAnswerResult() throws Exception{
        AnswerResultDto expectedAnswerResultDto = new AnswerResultDto();
        expectedAnswerResultDto.setId(1L);
        expectedAnswerResultDto.setScore(0D);
        expectedAnswerResultDto.setQuestionId(1L);
        expectedAnswerResultDto.setAnswerVariantsId(Collections.emptyList());
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
    void addNewAnswerResult() throws Exception{
        AnswerResultDto expectedAnswerResultDto = new AnswerResultDto();
        expectedAnswerResultDto.setId(1L);
        expectedAnswerResultDto.setScore(0D);
        expectedAnswerResultDto.setQuestionId(null);
        expectedAnswerResultDto.setAnswerVariantsId(Collections.emptyList());
        expectedAnswerResultDto.setTestResultId(null);

        AnswerResult answerResult = new AnswerResult();
        answerResult.setScore(0D);
        answerResult.setQuestion(null);
        answerResult.setAnswerVariants(Collections.emptyList());
        answerResult.setTestResult(null);

        AnswerResultDto inputAnswerResultDto = new AnswerResultDto();
        inputAnswerResultDto.setScore(0D);
        inputAnswerResultDto.setQuestionId(null);
        inputAnswerResultDto.setAnswerVariantsId(Collections.emptyList());
        inputAnswerResultDto.setTestResultId(null);

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
    void updateAnswerResult() throws Exception{
        AnswerResultDto expectedAnswerResultDto = new AnswerResultDto();
        expectedAnswerResultDto.setId(1L);
        expectedAnswerResultDto.setScore(0D);
        expectedAnswerResultDto.setQuestionId(null);
        expectedAnswerResultDto.setAnswerVariantsId(Collections.emptyList());
        expectedAnswerResultDto.setTestResultId(null);

        AnswerResult answerResult = new AnswerResult();
        answerResult.setId(1L);
        answerResult.setScore(0D);
        answerResult.setQuestion(null);
        answerResult.setAnswerVariants(Collections.emptyList());
        answerResult.setTestResult(null);

        AnswerResultDto inputAnswerResultDto = new AnswerResultDto();
        inputAnswerResultDto.setId(1L);
        inputAnswerResultDto.setScore(0D);
        inputAnswerResultDto.setQuestionId(null);
        inputAnswerResultDto.setAnswerVariantsId(Collections.emptyList());
        inputAnswerResultDto.setTestResultId(null);

        when(answerResultService
                .updateAnswerResult(answerResult))
                .thenReturn(expectedAnswerResultDto);

        mvc.perform(MockMvcRequestBuilders
                        .post("/api/v1/answer-result")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(inputAnswerResultDto)))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void deleteAnswerResultByID() throws Exception{
        mvc.perform(MockMvcRequestBuilders.delete("/api/v1/answer-result/{id}", 1L))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void setPointsForTheAnswer() throws Exception{
        AnswerResultDto expectedAnswerResultDto = new AnswerResultDto();
        expectedAnswerResultDto.setId(1L);
        expectedAnswerResultDto.setScore(0D);
        expectedAnswerResultDto.setQuestionId(null);
        expectedAnswerResultDto.setAnswerVariantsId(Collections.emptyList());
        expectedAnswerResultDto.setTestResultId(null);

        AnswerResultDto inputAnswerResultDto = new AnswerResultDto();
        inputAnswerResultDto.setId(1L);
        inputAnswerResultDto.setScore(0D);
        inputAnswerResultDto.setQuestionId(null);
        inputAnswerResultDto.setAnswerVariantsId(Collections.emptyList());
        inputAnswerResultDto.setTestResultId(null);

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