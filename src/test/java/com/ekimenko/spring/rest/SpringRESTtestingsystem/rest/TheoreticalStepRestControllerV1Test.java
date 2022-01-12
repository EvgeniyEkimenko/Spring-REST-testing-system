package com.ekimenko.spring.rest.SpringRESTtestingsystem.rest;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.dto.TheoreticalStepDto;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.LessonStep;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.TheoreticalStep;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.service.theoretical_step_service.TheoreticalStepService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Nested;
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
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith({RestDocumentationExtension.class, SpringExtension.class})
@AutoConfigureRestDocs(outputDir = "target/generated-snippets/theoretical-step")
class TheoreticalStepRestControllerV1Test {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private TheoreticalStepService theoreticalStepService;

    @Test
    void getTheoreticalStepById() throws Exception {
        TheoreticalStepDto expectedTheoreticalStepDto = new TheoreticalStepDto();
        expectedTheoreticalStepDto.setId(1L);
        expectedTheoreticalStepDto.setLessonStepId(1L);
        expectedTheoreticalStepDto.setUsefulText("text");
        expectedTheoreticalStepDto.setName("name");
        expectedTheoreticalStepDto.setDescription("desc");

        when(theoreticalStepService
                .getTheoreticalStepDtoById(1L))
                .thenReturn(expectedTheoreticalStepDto);

        mvc.perform(RestDocumentationRequestBuilders
                        .get("/api/v1/theoretical-step/{id}", 1L)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andDo(document("theoretical-step/{method-name}", preprocessRequest(prettyPrint())
                        , preprocessResponse(prettyPrint()), pathParameters(parameterWithName("id")
                        .description("Theoretical Step DTO Unique Identifier"))));
    }

    @Test
    void getTheoreticalStepByIdResponseFieldDocumentation() throws Exception {
        TheoreticalStepDto expectedTheoreticalStepDto = new TheoreticalStepDto();
        expectedTheoreticalStepDto.setId(1L);
        expectedTheoreticalStepDto.setLessonStepId(1L);
        expectedTheoreticalStepDto.setUsefulText("text");
        expectedTheoreticalStepDto.setName("name");
        expectedTheoreticalStepDto.setDescription("desc");

        when(theoreticalStepService
                .getTheoreticalStepDtoById(1L))
                .thenReturn(expectedTheoreticalStepDto);

        mvc.perform(RestDocumentationRequestBuilders
                        .get("/api/v1/theoretical-step/{id}", 1L)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andDo(document("theoretical-step/{method-name}",preprocessRequest(prettyPrint())
                        , preprocessResponse(prettyPrint()), pathParameters(parameterWithName("id")
                        .description("Theoretical Step DTO Unique Identifier")), responseFields(fieldWithPath("id")
                                .description("Theoretical Step DTO Unique Identifier"),
                        fieldWithPath("name").description("Name of the product"),
                        fieldWithPath("description").description("Product Description"),
                        fieldWithPath("usefulText").description("Product Price"),
                        fieldWithPath("lessonStepId").description("Product stock"))));
    }

    @Test
    void getAllTheoreticalSteps() throws Exception {
        List<TheoreticalStepDto> expectedTheoreticalStepDtoList = new ArrayList<>();

        TheoreticalStepDto expectedTheoreticalStepDto = new TheoreticalStepDto();
        expectedTheoreticalStepDto.setId(1L);
        expectedTheoreticalStepDto.setLessonStepId(1L);
        expectedTheoreticalStepDto.setUsefulText("text");
        expectedTheoreticalStepDto.setName("name");
        expectedTheoreticalStepDto.setDescription("desc");

        expectedTheoreticalStepDtoList.add(expectedTheoreticalStepDto);

        when(theoreticalStepService
                .getAllTheoreticalStepsDto())
                .thenReturn(expectedTheoreticalStepDtoList);

        mvc.perform(RestDocumentationRequestBuilders
                        .get("/api/v1/theoretical-step/all")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andDo(document("theoretical-step/{method-name}", preprocessRequest(prettyPrint())
                        , preprocessResponse(prettyPrint())));
    }

    @Test
    void addNewTheoreticalStep() throws Exception {
        LessonStep lessonStep = new LessonStep();
        lessonStep.setId(1L);

        TheoreticalStepDto expectedTheoreticalStepDto = new TheoreticalStepDto();
        expectedTheoreticalStepDto.setId(1L);
        expectedTheoreticalStepDto.setLessonStepId(1L);
        expectedTheoreticalStepDto.setUsefulText("text");
        expectedTheoreticalStepDto.setName("name");
        expectedTheoreticalStepDto.setDescription("desc");

        TheoreticalStepDto inputTheoreticalStepDto = new TheoreticalStepDto();
        inputTheoreticalStepDto.setLessonStepId(1L);
        inputTheoreticalStepDto.setUsefulText("text");
        inputTheoreticalStepDto.setName("name");
        inputTheoreticalStepDto.setDescription("desc");

        TheoreticalStep theoreticalStep = new TheoreticalStep();
        theoreticalStep.setLessonStep(lessonStep);
        theoreticalStep.setUsefulText("text");
        theoreticalStep.setName("name");
        theoreticalStep.setDescription("desc");

        String tr = new ObjectMapper().writeValueAsString(inputTheoreticalStepDto);

        when(theoreticalStepService.
                toTheoreticalStep(inputTheoreticalStepDto))
                .thenReturn(theoreticalStep);

        when(theoreticalStepService
                .addNewTheoreticalStep(theoreticalStep))
                .thenReturn(expectedTheoreticalStepDto);

        mvc.perform(RestDocumentationRequestBuilders
                        .post("/api/v1/theoretical-step")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(inputTheoreticalStepDto)))
                .andDo(print())
                .andExpect(status().isOk())
                .andDo(document("theoretical-step/{method-name}", preprocessRequest(prettyPrint())
                        , preprocessResponse(prettyPrint())));
    }

    @Test
    void updateTheoreticalStep() throws Exception {
        LessonStep lessonStep = new LessonStep();
        lessonStep.setId(1L);

        TheoreticalStepDto expectedTheoreticalStepDto = new TheoreticalStepDto();
        expectedTheoreticalStepDto.setId(1L);
        expectedTheoreticalStepDto.setLessonStepId(1L);
        expectedTheoreticalStepDto.setUsefulText("text");
        expectedTheoreticalStepDto.setName("name");
        expectedTheoreticalStepDto.setDescription("desc");

        TheoreticalStepDto inputTheoreticalStepDto = new TheoreticalStepDto();
        inputTheoreticalStepDto.setId(1L);
        inputTheoreticalStepDto.setLessonStepId(1L);
        inputTheoreticalStepDto.setUsefulText("text");
        inputTheoreticalStepDto.setName("name");
        inputTheoreticalStepDto.setDescription("desc");

        TheoreticalStep theoreticalStep = new TheoreticalStep();
        theoreticalStep.setId(1L);
        theoreticalStep.setLessonStep(lessonStep);
        theoreticalStep.setUsefulText("text");
        theoreticalStep.setName("name");
        theoreticalStep.setDescription("desc");

        when(theoreticalStepService.
                toTheoreticalStep(inputTheoreticalStepDto))
                .thenReturn(theoreticalStep);

        when(theoreticalStepService
                .updateTheoreticalStep(theoreticalStep))
                .thenReturn(expectedTheoreticalStepDto);

        mvc.perform(RestDocumentationRequestBuilders
                        .put("/api/v1/theoretical-step")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(inputTheoreticalStepDto)))
                .andDo(print())
                .andExpect(status().isOk())
                .andDo(document("theoretical-step/{method-name}", preprocessRequest(prettyPrint())
                        , preprocessResponse(prettyPrint())));
    }

    @Test
    void deleteTheoreticalStepByID() throws Exception {
        mvc.perform(RestDocumentationRequestBuilders.delete("/api/v1/theoretical-step/{id}", 1L))
                .andDo(print())
                .andExpect(status().isOk())
                .andDo(document("theoretical-step/{method-name}", preprocessRequest(prettyPrint())
                        , preprocessResponse(prettyPrint()), pathParameters(parameterWithName("id")
                                .description("Theoretical Step DTO Unique Identifier"))));
    }
}
