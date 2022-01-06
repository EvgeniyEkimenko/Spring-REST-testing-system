package com.ekimenko.spring.rest.SpringRESTtestingsystem.rest.answer_rest;


import com.ekimenko.spring.rest.SpringRESTtestingsystem.dto.answer_dto.AnswerVariantDto;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.answer.AnswerVariant;
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
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class AnswerVariantRestControllerV1Test {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private AnswerVariantService answerVariantService;

    @Test
    void getAnswerVariantById() throws Exception {
        AnswerVariantDto expectedAnswerVariantDto = new AnswerVariantDto();
        expectedAnswerVariantDto.setId(1L);
        expectedAnswerVariantDto.setCorrect(false);
        expectedAnswerVariantDto.setText("testText");
        expectedAnswerVariantDto.setAnswerResultId(null);
        expectedAnswerVariantDto.setQuestionId(null);

        when(answerVariantService
                .getAnswerVariantDtoById(1L))
                .thenReturn(expectedAnswerVariantDto);

        mvc.perform(MockMvcRequestBuilders
                        .get("/api/v1/answer-variant/{id}", 1L)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void getAllAnswerVariants() throws Exception {
        AnswerVariantDto expectedAnswerVariantDto = new AnswerVariantDto();
        expectedAnswerVariantDto.setId(1L);
        expectedAnswerVariantDto.setCorrect(false);
        expectedAnswerVariantDto.setText("testText");
        expectedAnswerVariantDto.setAnswerResultId(null);
        expectedAnswerVariantDto.setQuestionId(null);

        List<AnswerVariantDto> expectedAnswerVariantDtoList = new ArrayList<>();
        expectedAnswerVariantDtoList.add(expectedAnswerVariantDto);

        when(answerVariantService
                .getAllAnswerVariantsDto())
                .thenReturn(expectedAnswerVariantDtoList);

        mvc.perform(MockMvcRequestBuilders
                        .get("/api/v1/answer-variant/all")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void addNewAnswerVariant() throws Exception {
        AnswerVariantDto expectedAnswerVariantDto = new AnswerVariantDto();
        expectedAnswerVariantDto.setId(1L);
        expectedAnswerVariantDto.setCorrect(false);
        expectedAnswerVariantDto.setText("testText");
        expectedAnswerVariantDto.setAnswerResultId(null);
        expectedAnswerVariantDto.setQuestionId(null);

        AnswerVariant answerVariant = new AnswerVariant();
        answerVariant.setCorrect(false);
        answerVariant.setText("testText");
        answerVariant.setAnswerResult(null);
        answerVariant.setQuestion(null);

        AnswerVariantDto inputAnswerVariantDto = new AnswerVariantDto();
        inputAnswerVariantDto.setCorrect(false);
        inputAnswerVariantDto.setText("testText");
        inputAnswerVariantDto.setAnswerResultId(null);
        inputAnswerVariantDto.setQuestionId(null);

        when(answerVariantService
                .addNewAnswerVariant(answerVariant))
                .thenReturn(expectedAnswerVariantDto);

        mvc.perform(MockMvcRequestBuilders
                        .post("/api/v1/answer-variant")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(inputAnswerVariantDto)))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void updateAnswerVariant() throws Exception {
        AnswerVariantDto expectedAnswerVariantDto = new AnswerVariantDto();
        expectedAnswerVariantDto.setId(1L);
        expectedAnswerVariantDto.setCorrect(false);
        expectedAnswerVariantDto.setText("testText");
        expectedAnswerVariantDto.setAnswerResultId(null);
        expectedAnswerVariantDto.setQuestionId(null);

        AnswerVariant answerVariant = new AnswerVariant();
        answerVariant.setId(1L);
        answerVariant.setCorrect(false);
        answerVariant.setText("testText");
        answerVariant.setAnswerResult(null);
        answerVariant.setQuestion(null);

        AnswerVariantDto inputAnswerVariantDto = new AnswerVariantDto();
        inputAnswerVariantDto.setId(1L);
        inputAnswerVariantDto.setCorrect(false);
        inputAnswerVariantDto.setText("testText");
        inputAnswerVariantDto.setAnswerResultId(null);
        inputAnswerVariantDto.setQuestionId(null);

        when(answerVariantService
                .updateAnswerVariant(answerVariant))
                .thenReturn(expectedAnswerVariantDto);

        mvc.perform(MockMvcRequestBuilders
                        .post("/api/v1/answer-variant")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(inputAnswerVariantDto)))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void deleteAnswerVariantByID() throws Exception {
        mvc.perform(MockMvcRequestBuilders.delete("/api/v1/answer-variant/{id}", 1L))
                .andDo(print())
                .andExpect(status().isOk());
    }
}