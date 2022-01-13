package com.ekimenko.spring.rest.SpringRESTtestingsystem.rest.answer_rest;


import com.ekimenko.spring.rest.SpringRESTtestingsystem.dto.answer_dto.AnswerVariantDto;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.answer.AnswerResult;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.answer.AnswerVariant;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.question.Question;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.service.answer_service.AnswerVariantService;
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
        expectedAnswerVariantDto.setAnswerResultId(1L);
        expectedAnswerVariantDto.setQuestionId(1L);

        when(answerVariantService
                .getAnswerVariantDtoById(1L))
                .thenReturn(expectedAnswerVariantDto);

        mvc.perform(RestDocumentationRequestBuilders
                        .get("/api/v1/answer-variant/{id}", 1L)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andDo(document("answer-variant/{method-name}", preprocessRequest(prettyPrint())
                        , preprocessResponse(prettyPrint()), pathParameters(parameterWithName("id")
                                .description("Answer Variant Unique Identifier"))));
    }

    @Test
    void getAnswerVariantByIdResponseFieldDocumentation() throws Exception {
        AnswerVariantDto expectedAnswerVariantDto = new AnswerVariantDto();
        expectedAnswerVariantDto.setId(1L);
        expectedAnswerVariantDto.setCorrect(false);
        expectedAnswerVariantDto.setText("testText");
        expectedAnswerVariantDto.setAnswerResultId(1L);
        expectedAnswerVariantDto.setQuestionId(1L);

        when(answerVariantService
                .getAnswerVariantDtoById(1L))
                .thenReturn(expectedAnswerVariantDto);

        mvc.perform(RestDocumentationRequestBuilders
                        .get("/api/v1/answer-variant/{id}", 1L)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andDo(document("answer-variant/{method-name}", preprocessRequest(prettyPrint())
                        , preprocessResponse(prettyPrint()), pathParameters(parameterWithName("id")
                                .description("Answer Variant Unique Identifier")), responseFields(fieldWithPath("id")
                                        .description("Answer Variant Unique Identifier"),
                                fieldWithPath("text").description("Text of the Answer Variant"),
                                fieldWithPath("correct").description("Correct Answer Variant"),
                                fieldWithPath("questionId").description("Question Unique Identifier"),
                                fieldWithPath("answerResultId").description("Answer Result Unique Identifier"))));
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

        mvc.perform(RestDocumentationRequestBuilders
                        .get("/api/v1/answer-variant/all")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andDo(document("answer-variant/{method-name}", preprocessRequest(prettyPrint())
                        , preprocessResponse(prettyPrint())));
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

        mvc.perform(RestDocumentationRequestBuilders
                        .post("/api/v1/answer-variant")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(inputAnswerVariantDto)))
                .andDo(print())
                .andExpect(status().isOk())
                .andDo(document("answer-variant/{method-name}", preprocessRequest(prettyPrint())
                        , preprocessResponse(prettyPrint())));
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

        mvc.perform(RestDocumentationRequestBuilders
                        .put("/api/v1/answer-variant")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(inputAnswerVariantDto)))
                .andDo(print())
                .andExpect(status().isOk())
                .andDo(document("answer-variant/{method-name}", preprocessRequest(prettyPrint())
                        , preprocessResponse(prettyPrint())));
    }

    @Test
    void deleteAnswerVariantByID() throws Exception {
        mvc.perform(RestDocumentationRequestBuilders.delete("/api/v1/answer-variant/{id}", 1L))
                .andDo(print())
                .andExpect(status().isOk())
                .andDo(document("answer-variant/{method-name}", preprocessRequest(prettyPrint())
                        , preprocessResponse(prettyPrint()), pathParameters(parameterWithName("id")
                                .description("Answer Variant Unique Identifier"))));
    }
}