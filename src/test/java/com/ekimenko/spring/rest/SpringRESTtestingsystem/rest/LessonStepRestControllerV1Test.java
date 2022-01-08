package com.ekimenko.spring.rest.SpringRESTtestingsystem.rest;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.dto.LessonStepDto;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.LessonStep;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.service.lesson_service.LessonStepService;
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
class LessonStepRestControllerV1Test {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private LessonStepService lessonStepService;

    @Test
    void getLessonStepById() throws Exception {
        LessonStepDto expectedLessonStepDto = new LessonStepDto();
        expectedLessonStepDto.setId(1L);
        expectedLessonStepDto.setTestId(null);
        expectedLessonStepDto.setComplete(false);
        expectedLessonStepDto.setPositionInLesson(1);
        expectedLessonStepDto.setTheoreticalStepId(null);
        expectedLessonStepDto.setLessonId(null);

        when(lessonStepService
                .getLessonStepDtoById(1L))
                .thenReturn(expectedLessonStepDto);

        mvc.perform(MockMvcRequestBuilders
                        .get("/api/v1/lesson-step/{id}", 1L)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void getAllLessonSteps() throws Exception {
        List<LessonStepDto> expectedLessonStepDtoList = new ArrayList<>();

        LessonStepDto lessonStepDto = new LessonStepDto();
        lessonStepDto.setId(1L);
        lessonStepDto.setTestId(null);
        lessonStepDto.setComplete(false);
        lessonStepDto.setPositionInLesson(1);
        lessonStepDto.setTheoreticalStepId(null);
        lessonStepDto.setLessonId(null);

        expectedLessonStepDtoList.add(lessonStepDto);

        when(lessonStepService
                .getAllLessonStepsDto())
                .thenReturn(expectedLessonStepDtoList);

        mvc.perform(MockMvcRequestBuilders
                        .get("/api/v1/lesson-step/all")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void addNewLessonStep() throws Exception {
        LessonStepDto expectedLessonStepDto = new LessonStepDto();
        expectedLessonStepDto.setId(1L);
        expectedLessonStepDto.setTestId(null);
        expectedLessonStepDto.setComplete(false);
        expectedLessonStepDto.setPositionInLesson(1);
        expectedLessonStepDto.setTheoreticalStepId(null);
        expectedLessonStepDto.setLessonId(null);

        LessonStep lessonStep = new LessonStep();
        lessonStep.setTest(null);
        lessonStep.setComplete(false);
        lessonStep.setPositionInLesson(1);
        lessonStep.setTheoreticalStep(null);
        lessonStep.setLesson(null);

        LessonStepDto inputLessonStepDto = new LessonStepDto();
        inputLessonStepDto.setId(1L);
        inputLessonStepDto.setTestId(null);
        inputLessonStepDto.setComplete(false);
        inputLessonStepDto.setPositionInLesson(1);
        inputLessonStepDto.setTheoreticalStepId(null);
        inputLessonStepDto.setLessonId(null);

        when(lessonStepService.
                toLessonStep(inputLessonStepDto))
                .thenReturn(lessonStep);

        when(lessonStepService
                .addNewLessonStep(lessonStep))
                .thenReturn(expectedLessonStepDto);

        mvc.perform(MockMvcRequestBuilders
                        .post("/api/v1/lesson-step")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(inputLessonStepDto)))
                .andDo(print())
                .andExpect(status().isOk());

    }

    @Test
    void updateLessonStep() throws Exception {
        LessonStepDto expectedLessonStepDto = new LessonStepDto();
        expectedLessonStepDto.setId(1L);
        expectedLessonStepDto.setTestId(null);
        expectedLessonStepDto.setComplete(false);
        expectedLessonStepDto.setPositionInLesson(1);
        expectedLessonStepDto.setTheoreticalStepId(null);
        expectedLessonStepDto.setLessonId(null);

        LessonStep lessonStep = new LessonStep();
        lessonStep.setId(1L);
        lessonStep.setTest(null);
        lessonStep.setComplete(false);
        lessonStep.setPositionInLesson(1);
        lessonStep.setTheoreticalStep(null);
        lessonStep.setLesson(null);

        LessonStepDto inputLessonStepDto = new LessonStepDto();
        inputLessonStepDto.setId(1L);
        inputLessonStepDto.setTestId(null);
        inputLessonStepDto.setComplete(false);
        inputLessonStepDto.setPositionInLesson(1);
        inputLessonStepDto.setTheoreticalStepId(null);
        inputLessonStepDto.setLessonId(null);

        when(lessonStepService.
                toLessonStep(inputLessonStepDto))
                .thenReturn(lessonStep);

        when(lessonStepService
                .updateLessonStep(lessonStep))
                .thenReturn(expectedLessonStepDto);

        mvc.perform(MockMvcRequestBuilders
                        .put("/api/v1/lesson-step")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(inputLessonStepDto)))
                .andDo(print())
                .andExpect(status().isOk());

    }

    @Test
    void deleteLessonStepByID() throws Exception {
        mvc.perform(MockMvcRequestBuilders.delete("/api/v1/lesson-step/{id}", 1L))
                .andDo(print())
                .andExpect(status().isOk());
    }
}