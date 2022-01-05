package com.ekimenko.spring.rest.SpringRESTtestingsystem.rest;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.dto.LessonDto;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.Lesson;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.service.lesson_service.LessonService;
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

//ControllerAdvice (!)

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class LessonRestControllerV1Test {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private LessonService lessonService;

    @Test
    void getLessonById() throws Exception {

        LessonDto expectedLessonDto = new LessonDto();
        expectedLessonDto.setId(1L);
        expectedLessonDto.setName("testName");
        expectedLessonDto.setComplete(false);
        expectedLessonDto.setCourseId(null);
        expectedLessonDto.setLessonStepsId(Collections.emptyList());
        expectedLessonDto.setDescription("testDesc");

        when(lessonService
                .getLessonDtoById(1L))
                .thenReturn(expectedLessonDto);

        mvc.perform(MockMvcRequestBuilders
                        .get("/api/v1/lesson/{id}", 1L)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());

    }

    @Test
    void getAllLessons() throws Exception {

        List<LessonDto> expectedLessonDtoList = new ArrayList<>();

        LessonDto expectedLessonDto = new LessonDto();
        expectedLessonDto.setId(1L);
        expectedLessonDto.setName("testName");
        expectedLessonDto.setComplete(false);
        expectedLessonDto.setCourseId(null);
        expectedLessonDto.setLessonStepsId(Collections.emptyList());
        expectedLessonDto.setDescription("testDesc");

        LessonDto secondExpectedLessonDto = new LessonDto();
        secondExpectedLessonDto.setId(2L);
        secondExpectedLessonDto.setName("testName1");
        secondExpectedLessonDto.setComplete(false);
        secondExpectedLessonDto.setCourseId(null);
        secondExpectedLessonDto.setLessonStepsId(Collections.emptyList());
        secondExpectedLessonDto.setDescription("testDesc1");

        expectedLessonDtoList.add(expectedLessonDto);
        expectedLessonDtoList.add(secondExpectedLessonDto);

        when(lessonService
                .getAllLessonsDto())
                .thenReturn(expectedLessonDtoList);

        mvc.perform(MockMvcRequestBuilders
                        .get("/api/v1/lesson/all")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());

    }

    @Test
    void addNewLesson() throws Exception {
        LessonDto expectedLessonDto = new LessonDto();
        expectedLessonDto.setId(1L);
        expectedLessonDto.setName("testName");
        expectedLessonDto.setComplete(false);
        expectedLessonDto.setCourseId(null);
        expectedLessonDto.setLessonStepsId(Collections.emptyList());
        expectedLessonDto.setDescription("testDesc");

        Lesson lessonForAdd = new Lesson();
        lessonForAdd.setName("testName");
        lessonForAdd.setComplete(false);
        lessonForAdd.setCourse(null);
        lessonForAdd.setLessonSteps(Collections.emptyList());
        lessonForAdd.setDescription("testDesc");

        LessonDto inputLessonDto = new LessonDto();
        inputLessonDto.setName("testName");
        inputLessonDto.setComplete(false);
        inputLessonDto.setCourseId(null);
        inputLessonDto.setLessonStepsId(Collections.emptyList());
        inputLessonDto.setDescription("testDesc");

        when(lessonService
                .addNewLesson(lessonForAdd))
                .thenReturn(expectedLessonDto);

        mvc.perform(MockMvcRequestBuilders
                        .post("/api/v1/lesson")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(inputLessonDto)))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void updateLesson() throws Exception{
        LessonDto expectedLessonDto = new LessonDto();
        expectedLessonDto.setId(1L);
        expectedLessonDto.setName("testName");
        expectedLessonDto.setComplete(false);
        expectedLessonDto.setCourseId(null);
        expectedLessonDto.setLessonStepsId(Collections.emptyList());
        expectedLessonDto.setDescription("testDesc");

        Lesson lessonForAdd = new Lesson();
        lessonForAdd.setName("testName");
        lessonForAdd.setComplete(false);
        lessonForAdd.setCourse(null);
        lessonForAdd.setLessonSteps(Collections.emptyList());
        lessonForAdd.setDescription("testDesc");

        LessonDto inputLessonDto = new LessonDto();
        inputLessonDto.setName("testName");
        inputLessonDto.setComplete(false);
        inputLessonDto.setCourseId(null);
        inputLessonDto.setLessonStepsId(Collections.emptyList());
        inputLessonDto.setDescription("testDesc");

        when(lessonService
                .updateLesson(lessonForAdd))
                .thenReturn(expectedLessonDto);

        mvc.perform(MockMvcRequestBuilders
                        .post("/api/v1/lesson")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(inputLessonDto)))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void deleteLessonByID() throws Exception {
        mvc.perform(MockMvcRequestBuilders.delete("/api/v1/lesson/{id}" , 1L))
                .andDo(print())
                .andExpect(status().isOk());
    }
}