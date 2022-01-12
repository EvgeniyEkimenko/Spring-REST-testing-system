package com.ekimenko.spring.rest.SpringRESTtestingsystem.rest;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.dto.CourseDto;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.Course;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.Lesson;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.user.User;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.service.course_service.CourseService;
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
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith({RestDocumentationExtension.class, SpringExtension.class})
@AutoConfigureRestDocs(outputDir = "target/generated-snippets/course")
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
        expectedCourseDto.setUsersId(List.of(1L));
        expectedCourseDto.setLessonsId(List.of(1L));
        expectedCourseDto.setDescription("description");

        when(courseService
                .getCourseDtoById(1L))
                .thenReturn(expectedCourseDto);

        mvc.perform(RestDocumentationRequestBuilders
                        .get("/api/v1/course/{id}", 1L)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andDo(document("course/{method-name}", preprocessRequest(prettyPrint())
                        , preprocessResponse(prettyPrint()), pathParameters(parameterWithName("id")
                                .description("Course Unique Identifier"))));
    }

    @Test
    void getCourseByIdResponseFieldDocumentation() throws Exception {
        CourseDto expectedCourseDto = new CourseDto();
        expectedCourseDto.setId(1L);
        expectedCourseDto.setName("name");
        expectedCourseDto.setComplete(false);
        expectedCourseDto.setUsersId(List.of(1L));
        expectedCourseDto.setLessonsId(List.of(1L));
        expectedCourseDto.setDescription("description");

        when(courseService
                .getCourseDtoById(1L))
                .thenReturn(expectedCourseDto);

        mvc.perform(RestDocumentationRequestBuilders
                        .get("/api/v1/course/{id}", 1L)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andDo(document("course/{method-name}", preprocessRequest(prettyPrint())
                        , preprocessResponse(prettyPrint()), pathParameters(parameterWithName("id")
                                .description("Course Unique Identifier")), responseFields(fieldWithPath("id")
                                        .description("Course Unique Identifier"),
                                fieldWithPath("name").description("Course name"),
                                fieldWithPath("complete").description("logical value of execution"),
                                fieldWithPath("description").description("Course Description"),
                                fieldWithPath("lessonsId").description("Lesson Unique Identifier"),
                                fieldWithPath("usersId").description("User Unique Identifier"))));
    }

    @Test
    void getAllCourses() throws Exception {
        List<CourseDto> expectedCourseDtoList = new ArrayList<>();

        CourseDto expectedCourseDto = new CourseDto();
        expectedCourseDto.setId(1L);
        expectedCourseDto.setName("name");
        expectedCourseDto.setComplete(false);
        expectedCourseDto.setUsersId(List.of(1L));
        expectedCourseDto.setLessonsId(List.of(1L));
        expectedCourseDto.setDescription("description");

        expectedCourseDtoList.add(expectedCourseDto);

        when(courseService
                .getAllCoursesDto())
                .thenReturn(expectedCourseDtoList);

        mvc.perform(RestDocumentationRequestBuilders
                        .get("/api/v1/course/all")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andDo(document("course/{method-name}", preprocessRequest(prettyPrint())
                        , preprocessResponse(prettyPrint())));
    }

    @Test
    void addNewCourse() throws Exception {
        List<User> userList = new ArrayList<>();
        List<Lesson> lessonList = new ArrayList<>();

        User user = new User();
        Lesson lesson = new Lesson();

        user.setId(1L);
        lesson.setId(1L);

        userList.add(user);
        lessonList.add(lesson);

        CourseDto expectedCourseDto = new CourseDto();
        expectedCourseDto.setId(1L);
        expectedCourseDto.setName("name");
        expectedCourseDto.setComplete(false);
        expectedCourseDto.setUsersId(List.of(1L));
        expectedCourseDto.setLessonsId(List.of(1L));
        expectedCourseDto.setDescription("description");

        Course course = new Course();
        course.setName("name");
        course.setComplete(false);
        course.setUsers(userList);
        course.setLessons(lessonList);
        course.setDescription("description");

        CourseDto inputCourseDto = new CourseDto();
        inputCourseDto.setName("name");
        inputCourseDto.setComplete(false);
        inputCourseDto.setUsersId(List.of(1L));
        inputCourseDto.setLessonsId(List.of(1L));
        inputCourseDto.setDescription("description");

        when(courseService.
                toCourse(inputCourseDto))
                .thenReturn(course);

        when(courseService
                .addNewCourse(course))
                .thenReturn(expectedCourseDto);

        mvc.perform(RestDocumentationRequestBuilders
                        .post("/api/v1/course")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(inputCourseDto)))
                .andDo(print())
                .andExpect(status().isOk())
                .andDo(document("course/{method-name}", preprocessRequest(prettyPrint())
                        , preprocessResponse(prettyPrint())));
    }

    @Test
    void updateCourse() throws Exception {
        List<User> userList = new ArrayList<>();
        List<Lesson> lessonList = new ArrayList<>();

        User user = new User();
        Lesson lesson = new Lesson();

        user.setId(1L);
        lesson.setId(1L);

        userList.add(user);
        lessonList.add(lesson);


        CourseDto expectedCourseDto = new CourseDto();
        expectedCourseDto.setId(1L);
        expectedCourseDto.setName("name");
        expectedCourseDto.setComplete(false);
        expectedCourseDto.setUsersId(List.of(1L));
        expectedCourseDto.setLessonsId(List.of(1L));
        expectedCourseDto.setDescription("description");

        Course course = new Course();
        course.setId(1L);
        course.setName("name");
        course.setComplete(false);
        course.setUsers(userList);
        course.setLessons(lessonList);
        course.setDescription("description");

        CourseDto inputCourseDto = new CourseDto();
        inputCourseDto.setId(1L);
        inputCourseDto.setName("name");
        inputCourseDto.setComplete(false);
        inputCourseDto.setUsersId(List.of(1L));
        inputCourseDto.setLessonsId(List.of(1L));
        inputCourseDto.setDescription("description");

        when(courseService.
                toCourse(inputCourseDto))
                .thenReturn(course);

        when(courseService
                .updateCourse(course))
                .thenReturn(expectedCourseDto);

        mvc.perform(RestDocumentationRequestBuilders
                        .put("/api/v1/course")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(inputCourseDto)))
                .andDo(print())
                .andExpect(status().isOk())
                .andDo(document("course/{method-name}", preprocessRequest(prettyPrint())
                        , preprocessResponse(prettyPrint())));
    }

    @Test
    void deleteCourseByID() throws Exception {
        mvc.perform(RestDocumentationRequestBuilders.delete("/api/v1/course/{id}", 1L))
                .andDo(print())
                .andExpect(status().isOk())
                .andDo(document("course/{method-name}", preprocessRequest(prettyPrint())
                        , preprocessResponse(prettyPrint()), pathParameters(parameterWithName("id")
                                .description("Course Unique Identifier"))));
    }
}