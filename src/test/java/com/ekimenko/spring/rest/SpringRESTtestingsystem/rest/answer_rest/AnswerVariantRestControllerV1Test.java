package com.ekimenko.spring.rest.SpringRESTtestingsystem.rest.answer_rest;


import com.ekimenko.spring.rest.SpringRESTtestingsystem.dto.answer_dto.AnswerVariantDto;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.answer.AnswerResult;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.answer.AnswerVariant;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.question.Question;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.service.answer_service.AnswerVariantService;
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
@AutoConfigureRestDocs(outputDir = "target/generated-snippets/answer-variant")
@SpringBootTest
@AutoConfigureMockMvc
class AnswerVariantRestControllerV1Test {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private AnswerVariantService answerVariantService;

    @BeforeEach
    public void setUp(WebApplicationContext webApplicationContext,
                      RestDocumentationContextProvider restDocumentation) {

        this.mvc = MockMvcBuilders
                .webAppContextSetup(webApplicationContext)
                .apply(documentationConfiguration(restDocumentation))
                .alwaysDo(document("answer-variant/{method-name}",
                        preprocessRequest(prettyPrint()), preprocessResponse(prettyPrint())))
                .build();
    }

    @Test
    void getAnswerVariantById() throws Exception {
        AnswerVariantDto expectedAnswerVariantDto = new AnswerVariantDto();
        expectedAnswerVariantDto.setId(1L);
        expectedAnswerVariantDto.setCorrect(false);
        expectedAnswerVariantDto.setText("testText");
        expectedAnswerVariantDto.setAnswerResultId(1L);
        expectedAnswerVariantDto.setQuestionId(1L);

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
        expectedAnswerVariantDto.setAnswerResultId(1L);
        expectedAnswerVariantDto.setQuestionId(1L);

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
        AnswerResult answerResult = new AnswerResult();
        Question question = new Question();

        answerResult.setId(1L);
        question.setId(1L);

        AnswerVariantDto expectedAnswerVariantDto = new AnswerVariantDto();
        expectedAnswerVariantDto.setId(1L);
        expectedAnswerVariantDto.setCorrect(false);
        expectedAnswerVariantDto.setText("testText");
        expectedAnswerVariantDto.setAnswerResultId(1L);
        expectedAnswerVariantDto.setQuestionId(1L);

        AnswerVariant answerVariant = new AnswerVariant();
        answerVariant.setCorrect(false);
        answerVariant.setText("testText");
        answerVariant.setAnswerResult(answerResult);
        answerVariant.setQuestion(question);

        AnswerVariantDto inputAnswerVariantDto = new AnswerVariantDto();
        inputAnswerVariantDto.setCorrect(false);
        inputAnswerVariantDto.setText("testText");
        inputAnswerVariantDto.setAnswerResultId(1L);
        inputAnswerVariantDto.setQuestionId(1L);

        when(answerVariantService.
                toAnswerVariant(inputAnswerVariantDto))
                .thenReturn(answerVariant);

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
        AnswerResult answerResult = new AnswerResult();
        Question question = new Question();

        answerResult.setId(1L);
        question.setId(1L);

        AnswerVariantDto expectedAnswerVariantDto = new AnswerVariantDto();
        expectedAnswerVariantDto.setId(1L);
        expectedAnswerVariantDto.setCorrect(false);
        expectedAnswerVariantDto.setText("testText");
        expectedAnswerVariantDto.setAnswerResultId(1L);
        expectedAnswerVariantDto.setQuestionId(1L);

        AnswerVariant answerVariant = new AnswerVariant();
        answerVariant.setId(1L);
        answerVariant.setCorrect(false);
        answerVariant.setText("testText");
        answerVariant.setAnswerResult(answerResult);
        answerVariant.setQuestion(question);

        AnswerVariantDto inputAnswerVariantDto = new AnswerVariantDto();
        inputAnswerVariantDto.setId(1L);
        inputAnswerVariantDto.setCorrect(false);
        inputAnswerVariantDto.setText("testText");
        inputAnswerVariantDto.setAnswerResultId(1L);
        inputAnswerVariantDto.setQuestionId(1L);

        when(answerVariantService.
                toAnswerVariant(inputAnswerVariantDto))
                .thenReturn(answerVariant);

        when(answerVariantService
                .updateAnswerVariant(answerVariant))
                .thenReturn(expectedAnswerVariantDto);

        mvc.perform(MockMvcRequestBuilders
                        .put("/api/v1/answer-variant")
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