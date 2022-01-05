package com.ekimenko.spring.rest.SpringRESTtestingsystem.rest;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.dto.CourseDto;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.Course;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.service.course_service.CourseService;
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
class CourseRestControllerV1Test {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private CourseService courseService;

    @Test
    void getCourseById() throws Exception {
        CourseDto expectedCourseDto = new CourseDto();
        expectedCourseDto.setId(1L);
        expectedCourseDto.setName("name");
        expectedCourseDto.setComplete(false);
        expectedCourseDto.setUsersId(Collections.emptyList());
        expectedCourseDto.setLessonsId(Collections.emptyList());
        expectedCourseDto.setUsersId(Collections.emptyList());

        when(courseService
                .getCourseDtoById(1L))
                .thenReturn(expectedCourseDto);

        mvc.perform(MockMvcRequestBuilders
                        .get("/api/v1/course/{id}", 1L)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void getAllCourses() throws Exception {
        List<CourseDto> expectedCourseDtoList = new ArrayList<>();

        CourseDto expectedCourseDto = new CourseDto();
        expectedCourseDto.setId(1L);
        expectedCourseDto.setName("name");
        expectedCourseDto.setComplete(false);
        expectedCourseDto.setUsersId(Collections.emptyList());
        expectedCourseDto.setLessonsId(Collections.emptyList());
        expectedCourseDto.setUsersId(Collections.emptyList());

        when(courseService
                .getAllCoursesDto())
                .thenReturn(expectedCourseDtoList);

        mvc.perform(MockMvcRequestBuilders
                        .get("/api/v1/course/all")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void addNewCourse() throws Exception {
        CourseDto expectedCourseDto = new CourseDto();
        expectedCourseDto.setId(1L);
        expectedCourseDto.setName("name");
        expectedCourseDto.setComplete(false);
        expectedCourseDto.setUsersId(Collections.emptyList());
        expectedCourseDto.setLessonsId(Collections.emptyList());
        expectedCourseDto.setUsersId(Collections.emptyList());

        Course course = new Course();
        course.setName("name");
        course.setComplete(false);
        course.setUsers(Collections.emptyList());
        course.setLessons(Collections.emptyList());
        course.setUsers(Collections.emptyList());

        CourseDto inputCourseDto = new CourseDto();
        expectedCourseDto.setName("name");
        expectedCourseDto.setComplete(false);
        expectedCourseDto.setUsersId(Collections.emptyList());
        expectedCourseDto.setLessonsId(Collections.emptyList());
        expectedCourseDto.setUsersId(Collections.emptyList());

        when(courseService
                .addNewCourse(course))
                .thenReturn(expectedCourseDto);

        mvc.perform(MockMvcRequestBuilders
                        .post("/api/v1/course")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(inputCourseDto)))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void updateCourse() throws Exception {
        CourseDto expectedCourseDto = new CourseDto();
        expectedCourseDto.setId(1L);
        expectedCourseDto.setName("name");
        expectedCourseDto.setComplete(false);
        expectedCourseDto.setUsersId(Collections.emptyList());
        expectedCourseDto.setLessonsId(Collections.emptyList());
        expectedCourseDto.setUsersId(Collections.emptyList());

        Course course = new Course();
        course.setName("name");
        course.setComplete(false);
        course.setUsers(Collections.emptyList());
        course.setLessons(Collections.emptyList());
        course.setUsers(Collections.emptyList());

        CourseDto inputCourseDto = new CourseDto();
        expectedCourseDto.setName("name");
        expectedCourseDto.setComplete(false);
        expectedCourseDto.setUsersId(Collections.emptyList());
        expectedCourseDto.setLessonsId(Collections.emptyList());
        expectedCourseDto.setUsersId(Collections.emptyList());

        when(courseService
                .updateCourse(course))
                .thenReturn(expectedCourseDto);

        mvc.perform(MockMvcRequestBuilders
                        .post("/api/v1/course")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(inputCourseDto)))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void deleteCourseByID() throws Exception {
        mvc.perform(MockMvcRequestBuilders.delete("/api/v1/course/{id}", 1L))
                .andDo(print())
                .andExpect(status().isOk());
    }
}