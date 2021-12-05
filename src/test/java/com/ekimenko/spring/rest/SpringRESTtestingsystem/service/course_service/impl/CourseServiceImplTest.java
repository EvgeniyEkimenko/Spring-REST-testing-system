package com.ekimenko.spring.rest.SpringRESTtestingsystem.service.course_service.impl;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.dto.CourseDto;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.Course;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.repository.CourseRepository;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.service.lesson_service.LessonService;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.service.user_service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class CourseServiceImplTest {

    @Mock
    private CourseRepository courseRepository;
    @Mock
    private LessonService lessonService;
    @Mock
    private UserService userService;
    @InjectMocks
    private CourseServiceImpl underTestCourse;

    private Course course;

    @Test
    @Disabled
    void toCourse() {
    }

    @BeforeEach
    void setUp() {
        course = new Course();
        course.setId(1L);
        course.setName("testCourse");
        course.setDescription("testDesc");
        course.setComplete(false);
        course.setLessons(null);
        course.setUsers(null);
    }

    @Test
    @Disabled
    void getLessonListByListId() {
    }

    @Test
    @Disabled
    void getUserListByListId() {
    }

    @Test
    void fromCourse() {
        //given
        CourseDto expectedCourseDto = new CourseDto();
        expectedCourseDto.setId(1L);
        expectedCourseDto.setComplete(false);
        expectedCourseDto.setDescription("testDesc");
        expectedCourseDto.setName("testCourse");
        expectedCourseDto.setUsersId(Collections.emptyList());
        expectedCourseDto.setLessonsId(Collections.emptyList());
        //when
        CourseDto actualCourseDto = underTestCourse.fromCourse(course);
        //then
        assertThat(actualCourseDto).isEqualTo(expectedCourseDto);
    }

    @Test
    void getAllCoursesDto() {
    }

    @Test
    void getCourseDtoById() {
    }

    @Test
    void getAllCourses() {
    }

    @Test
    void addNewCourse() {
    }

    @Test
    void updateCourse() {
    }

    @Test
    void getCourseById() {
    }

    @Test
    void deleteCourseById() {
    }
}