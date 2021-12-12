package com.ekimenko.spring.rest.SpringRESTtestingsystem.rest;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.dto.LessonDto;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.service.lesson_service.LessonService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Collections;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/*@WebMvcTest
@WebAppConfiguration
@ExtendWith(SpringExtension.class)
@EnableAutoConfiguration*/

//1. ControllerAdvice погуглить
//2.
//3.


@WebMvcTest
@SpringBootTest
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
    void getAllLessons() {
/*
        List<Lesson> lessonList = new ArrayList<>();
        lessonList.add(lesson);
        List<LessonDto> expectedLessonDtoList = new ArrayList<>();

        LessonDto expectedLessonDto = new LessonDto();
        expectedLessonDto.setId(1L);
        expectedLessonDto.setName("testName");
        expectedLessonDto.setComplete(false);
        expectedLessonDto.setCourseId(null);
        expectedLessonDto.setLessonStepsId(Collections.emptyList());
        expectedLessonDto.setDescription("testDesc");
        expectedLessonDtoList.add(expectedLessonDto);


*/

    }

    @Test
    void addNewLesson() {
    }

    @Test
    void updateLesson() {
    }

    @Test
    void deleteLessonByID() {
    }
}