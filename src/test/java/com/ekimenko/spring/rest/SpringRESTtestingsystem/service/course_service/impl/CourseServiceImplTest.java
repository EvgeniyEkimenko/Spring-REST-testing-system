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
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

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
        //given
        List<Course> courseList = new ArrayList<>();
        Course anotherCourse = new Course();
        anotherCourse.setId(2L);
        anotherCourse.setName("testCourse");
        anotherCourse.setDescription("testDesc");
        anotherCourse.setComplete(false);
        anotherCourse.setLessons(null);
        anotherCourse.setUsers(null);

        List<CourseDto> expectedCourseDtoList = new ArrayList<>();

        CourseDto courseDto = new CourseDto();
        courseDto.setId(1L);
        courseDto.setComplete(false);
        courseDto.setDescription("testDesc");
        courseDto.setName("testCourse");
        courseDto.setUsersId(Collections.emptyList());
        courseDto.setLessonsId(Collections.emptyList());

        CourseDto anotherCourseDto = new CourseDto();
        anotherCourseDto.setId(2L);
        anotherCourseDto.setComplete(false);
        anotherCourseDto.setDescription("testDesc");
        anotherCourseDto.setName("testCourse");
        anotherCourseDto.setUsersId(Collections.emptyList());
        anotherCourseDto.setLessonsId(Collections.emptyList());

        expectedCourseDtoList.add(courseDto);
        expectedCourseDtoList.add(anotherCourseDto);

        courseList.add(course);
        courseList.add(anotherCourse);
        //when
        Mockito.when(courseRepository.findAll()).thenReturn(courseList);
        List<CourseDto> actualCourseDtoList = underTestCourse.getAllCoursesDto();

        //then
        assertThat(actualCourseDtoList).isEqualTo(expectedCourseDtoList);
    }

    @Test
    void getCourseDtoById() {
        //given
        CourseDto expectedCourse = new CourseDto();
        expectedCourse.setId(1L);
        expectedCourse.setComplete(false);
        expectedCourse.setDescription("testDesc");
        expectedCourse.setName("testCourse");
        expectedCourse.setUsersId(Collections.emptyList());
        expectedCourse.setLessonsId(Collections.emptyList());
        //when
        Mockito.when(courseRepository.findById(1L)).thenReturn(java.util.Optional.ofNullable(course));
        CourseDto actualCourseDto = underTestCourse.getCourseDtoById(1L);
        //then
        assertThat(actualCourseDto).isEqualTo(expectedCourse);
    }

    @Test
    void getAllCourses() {
        //given
        List<Course> expectedCourseList = new ArrayList<>();

        Course anotherCourse = new Course();
        anotherCourse.setId(2L);
        anotherCourse.setName("testCourse");
        anotherCourse.setDescription("testDesc");
        anotherCourse.setComplete(false);
        anotherCourse.setLessons(null);
        anotherCourse.setUsers(null);

        expectedCourseList.add(course);
        expectedCourseList.add(anotherCourse);

        //when
        Mockito.when(courseRepository.findAll()).thenReturn(expectedCourseList);
        List<Course> actualCourseList = underTestCourse.getAllCourses();
        //then
        assertThat(actualCourseList).isEqualTo(expectedCourseList);
    }

    @Test
    void addNewCourse() {
        //given
        CourseDto expectedCourse = new CourseDto();
        expectedCourse.setId(1L);
        expectedCourse.setName("testCourse");
        expectedCourse.setDescription("testDesc");
        expectedCourse.setComplete(false);
        expectedCourse.setLessonsId(Collections.emptyList());
        expectedCourse.setUsersId(Collections.emptyList());
        //when
        Mockito.when(courseRepository.save(course)).thenReturn(course);
        CourseDto actualCourseDto = underTestCourse.addNewCourse(course);
        //then
        assertThat(actualCourseDto).isEqualTo(expectedCourse);
    }

    @Test
    void updateCourse() {
        //given
        CourseDto expectedCourse = new CourseDto();
        expectedCourse.setId(1L);
        expectedCourse.setName("testCourse");
        expectedCourse.setDescription("testDesc");
        expectedCourse.setComplete(false);
        expectedCourse.setLessonsId(Collections.emptyList());
        expectedCourse.setUsersId(Collections.emptyList());
        //when
        Mockito.when(courseRepository.save(course)).thenReturn(course);
        CourseDto actualCourseDto = underTestCourse.updateCourse(course);
        //then
        assertThat(actualCourseDto).isEqualTo(expectedCourse);
    }

    @Test
    void getCourseById() {
        //given
        Course expectedCourse = course;
        //when
        Mockito.when(courseRepository.findById(1L)).thenReturn(java.util.Optional.ofNullable(course));
        Course actualCourse = underTestCourse.getCourseById(1L);
        //then
        assertThat(actualCourse).isEqualTo(expectedCourse);
    }

    @Test
    void deleteCourseById() {
        underTestCourse.deleteCourseById(1L);
        verify(courseRepository).deleteById(1L);
    }
}