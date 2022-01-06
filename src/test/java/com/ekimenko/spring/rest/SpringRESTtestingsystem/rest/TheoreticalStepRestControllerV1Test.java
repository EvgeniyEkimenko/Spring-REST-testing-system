package com.ekimenko.spring.rest.SpringRESTtestingsystem.rest;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.dto.TheoreticalStepDto;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.TheoreticalStep;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.service.theoretical_step_service.TheoreticalStepService;
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

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith({RestDocumentationExtension.class, SpringExtension.class})
@AutoConfigureRestDocs(outputDir = "target/generated-snippets")
class TheoreticalStepRestControllerV1Test {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private TheoreticalStepService theoreticalStepService;

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
    void getTheoreticalStepById() throws Exception {
        TheoreticalStepDto expectedTheoreticalStepDto = new TheoreticalStepDto();
        expectedTheoreticalStepDto.setId(1L);
        expectedTheoreticalStepDto.setLessonStepId(null);
        expectedTheoreticalStepDto.setUsefulText("text");
        expectedTheoreticalStepDto.setName("name");
        expectedTheoreticalStepDto.setDescription("desc");

        when(theoreticalStepService
                .getTheoreticalStepDtoById(1L))
                .thenReturn(expectedTheoreticalStepDto);

        mvc.perform(MockMvcRequestBuilders
                        .get("/api/v1/theoretical-step/{id}", 1L)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());

    }

    @Test
    void getAllTheoreticalSteps() throws Exception {
        List<TheoreticalStepDto> expectedTheoreticalStepDtoList = new ArrayList<>();

        TheoreticalStepDto expectedTheoreticalStepDto = new TheoreticalStepDto();
        expectedTheoreticalStepDto.setId(1L);
        expectedTheoreticalStepDto.setLessonStepId(null);
        expectedTheoreticalStepDto.setUsefulText("text");
        expectedTheoreticalStepDto.setName("name");
        expectedTheoreticalStepDto.setDescription("desc");

        expectedTheoreticalStepDtoList.add(expectedTheoreticalStepDto);

        when(theoreticalStepService
                .getAllTheoreticalStepsDto())
                .thenReturn(expectedTheoreticalStepDtoList);

        mvc.perform(MockMvcRequestBuilders
                        .get("/api/v1/theoretical-step/all")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void addNewTheoreticalStep() throws Exception {
        TheoreticalStepDto expectedTheoreticalStepDto = new TheoreticalStepDto();
        expectedTheoreticalStepDto.setId(1L);
        expectedTheoreticalStepDto.setLessonStepId(null);
        expectedTheoreticalStepDto.setUsefulText("text");
        expectedTheoreticalStepDto.setName("name");
        expectedTheoreticalStepDto.setDescription("desc");

        TheoreticalStepDto inputTheoreticalStepDto = new TheoreticalStepDto();
        inputTheoreticalStepDto.setLessonStepId(null);
        inputTheoreticalStepDto.setUsefulText("text");
        inputTheoreticalStepDto.setName("name");
        inputTheoreticalStepDto.setDescription("desc");

        TheoreticalStep theoreticalStep = new TheoreticalStep();
        theoreticalStep.setLessonStep(null);
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

        mvc.perform(MockMvcRequestBuilders
                        .post("/api/v1/theoretical-step")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(inputTheoreticalStepDto)))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void updateTheoreticalStep() throws Exception {
        TheoreticalStepDto expectedTheoreticalStepDto = new TheoreticalStepDto();
        expectedTheoreticalStepDto.setId(1L);
        expectedTheoreticalStepDto.setLessonStepId(null);
        expectedTheoreticalStepDto.setUsefulText("text");
        expectedTheoreticalStepDto.setName("name");
        expectedTheoreticalStepDto.setDescription("desc");

        TheoreticalStepDto inputTheoreticalStepDto = new TheoreticalStepDto();
        inputTheoreticalStepDto.setLessonStepId(null);
        inputTheoreticalStepDto.setUsefulText("text");
        inputTheoreticalStepDto.setName("name");
        inputTheoreticalStepDto.setDescription("desc");

        TheoreticalStep theoreticalStep = new TheoreticalStep();
        theoreticalStep.setLessonStep(null);
        theoreticalStep.setUsefulText("text");
        theoreticalStep.setName("name");
        theoreticalStep.setDescription("desc");

        when(theoreticalStepService.
                toTheoreticalStep(inputTheoreticalStepDto))
                .thenReturn(theoreticalStep);

        when(theoreticalStepService
                .updateTheoreticalStep(theoreticalStep))
                .thenReturn(expectedTheoreticalStepDto);

        mvc.perform(MockMvcRequestBuilders
                        .put("/api/v1/theoretical-step")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(inputTheoreticalStepDto)))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void deleteTheoreticalStepByID() throws Exception {
        mvc.perform(MockMvcRequestBuilders.delete("/api/v1/theoretical-step/{id}", 1L))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
