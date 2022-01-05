package com.ekimenko.spring.rest.SpringRESTtestingsystem.rest;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.dto.TheoreticalStepDto;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.TheoreticalStep;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.service.theoretical_step_service.TheoreticalStepService;
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
class TheoreticalStepRestControllerV1Test {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private TheoreticalStepService theoreticalStepService;

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
        expectedTheoreticalStepDto.setLessonStepId(null);
        expectedTheoreticalStepDto.setUsefulText("text");
        expectedTheoreticalStepDto.setName("name");
        expectedTheoreticalStepDto.setDescription("desc");

        TheoreticalStep theoreticalStep = new TheoreticalStep();
        theoreticalStep.setLessonStep(null);
        theoreticalStep.setUsefulText("text");
        theoreticalStep.setName("name");
        theoreticalStep.setDescription("desc");

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
        expectedTheoreticalStepDto.setLessonStepId(null);
        expectedTheoreticalStepDto.setUsefulText("text");
        expectedTheoreticalStepDto.setName("name");
        expectedTheoreticalStepDto.setDescription("desc");

        TheoreticalStep theoreticalStep = new TheoreticalStep();
        theoreticalStep.setLessonStep(null);
        theoreticalStep.setUsefulText("text");
        theoreticalStep.setName("name");
        theoreticalStep.setDescription("desc");

        when(theoreticalStepService
                .updateTheoreticalStep(theoreticalStep))
                .thenReturn(expectedTheoreticalStepDto);

        mvc.perform(MockMvcRequestBuilders
                        .post("/api/v1/theoretical-step")
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
