package com.ekimenko.spring.rest.SpringRESTtestingsystem.rest;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.dto.LessonDto;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.Course;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.Lesson;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.LessonStep;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.service.lesson_service.LessonService;
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
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders;
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

//ControllerAdvice (!)

@ExtendWith({RestDocumentationExtension.class, SpringExtension.class})
@AutoConfigureRestDocs(outputDir = "target/generated-snippets/lesson")
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
        expectedLessonDto.setCourseId(1L);
        expectedLessonDto.setLessonStepsId(List.of(1L));
        expectedLessonDto.setDescription("testDesc");

        when(lessonService
                .getLessonDtoById(1L))
                .thenReturn(expectedLessonDto);

        mvc.perform(RestDocumentationRequestBuilders
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
        expectedLessonDto.setCourseId(1L);
        expectedLessonDto.setLessonStepsId(List.of(1L));
        expectedLessonDto.setDescription("testDesc");

        expectedLessonDtoList.add(expectedLessonDto);


        when(lessonService
                .getAllLessonsDto())
                .thenReturn(expectedLessonDtoList);

        mvc.perform(RestDocumentationRequestBuilders
                        .get("/api/v1/lesson/all")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());

    }

    @Test
    void addNewLesson() throws Exception {
        Course course = new Course();
        course.setId(1L);
        LessonStep lessonStep = new LessonStep();
        lessonStep.setId(1L);
        List<LessonStep> lessonStepList = new ArrayList<>();
        lessonStepList.add(lessonStep);

        LessonDto expectedLessonDto = new LessonDto();
        expectedLessonDto.setId(1L);
        expectedLessonDto.setName("testName");
        expectedLessonDto.setComplete(false);
        expectedLessonDto.setCourseId(1L);
        expectedLessonDto.setLessonStepsId(List.of(1L));
        expectedLessonDto.setDescription("testDesc");

        Lesson lesson = new Lesson();
        lesson.setName("testName");
        lesson.setComplete(false);
        lesson.setCourse(course);
        lesson.setLessonSteps(lessonStepList);
        lesson.setDescription("testDesc");

        LessonDto inputLessonDto = new LessonDto();
        inputLessonDto.setName("testName");
        inputLessonDto.setComplete(false);
        inputLessonDto.setCourseId(1L);
        inputLessonDto.setLessonStepsId(List.of(1L));
        inputLessonDto.setDescription("testDesc");

        when(lessonService.
                toLesson(inputLessonDto))
                .thenReturn(lesson);

        when(lessonService
                .addNewLesson(lesson))
                .thenReturn(expectedLessonDto);

        mvc.perform(RestDocumentationRequestBuilders
                        .post("/api/v1/lesson")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(inputLessonDto)))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void updateLesson() throws Exception {
        Course course = new Course();
        course.setId(1L);
        LessonStep lessonStep = new LessonStep();
        lessonStep.setId(1L);
        List<LessonStep> lessonStepList = new ArrayList<>();
        lessonStepList.add(lessonStep);

        LessonDto expectedLessonDto = new LessonDto();
        expectedLessonDto.setId(1L);
        expectedLessonDto.setName("testName");
        expectedLessonDto.setComplete(false);
        expectedLessonDto.setCourseId(1L);
        expectedLessonDto.setLessonStepsId(List.of(1L));
        expectedLessonDto.setDescription("testDesc");

        Lesson lesson = new Lesson();
        lesson.setId(1L);
        lesson.setName("testName");
        lesson.setComplete(false);
        lesson.setCourse(course);
        lesson.setLessonSteps(lessonStepList);
        lesson.setDescription("testDesc");

        LessonDto inputLessonDto = new LessonDto();
        inputLessonDto.setId(1L);
        inputLessonDto.setName("testName");
        inputLessonDto.setComplete(false);
        inputLessonDto.setCourseId(1L);
        inputLessonDto.setLessonStepsId(List.of(1L));
        inputLessonDto.setDescription("testDesc");

        when(lessonService.
                toLesson(inputLessonDto))
                .thenReturn(lesson);

        when(lessonService
                .updateLesson(lesson))
                .thenReturn(expectedLessonDto);

        mvc.perform(RestDocumentationRequestBuilders
                        .put("/api/v1/lesson")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(inputLessonDto)))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void deleteLessonByID() throws Exception {
        mvc.perform(RestDocumentationRequestBuilders.delete("/api/v1/lesson/{id}", 1L))
                .andDo(print())
                .andExpect(status().isOk());
    }
}