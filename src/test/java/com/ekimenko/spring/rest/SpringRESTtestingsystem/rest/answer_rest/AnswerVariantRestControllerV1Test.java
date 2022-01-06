package com.ekimenko.spring.rest.SpringRESTtestingsystem.rest.answer_rest;



import com.ekimenko.spring.rest.SpringRESTtestingsystem.dto.answer_dto.AnswerVariantDto;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.service.answer_service.AnswerVariantService;
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
    void getAllAnswerVariants() throws Exception{
    }

    @Test
    void addNewAnswerVariant() throws Exception{
    }

    @Test
    void updateAnswerVariant() throws Exception{
    }

    @Test
    void deleteAnswerVariantByID() throws Exception{
    }
}