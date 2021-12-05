package com.ekimenko.spring.rest.SpringRESTtestingsystem.service.lesson_service.impl;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.dto.LessonDto;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.Lesson;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.repository.LessonRepository;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.service.course_service.CourseService;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.service.lesson_service.LessonStepService;
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

@ExtendWith(MockitoExtension.class)
class LessonServiceImplTest {

    @Mock
    private LessonRepository lessonRepository;
    @Mock
    private CourseService courseService;
    @Mock
    private LessonStepService LessonStep;
    @InjectMocks
    private LessonServiceImpl underTestLesson;

    private Lesson lesson;

    @BeforeEach
    void setUp() {
        lesson = new Lesson();
        lesson.setId(1L);
        lesson.setName("testName");
        lesson.setDescription("testDesc");
        lesson.setComplete(false);
        lesson.setCourse(null);
        lesson.setLessonSteps(null);

    }

    @Test
    void canGetAllLessons() {
        //given
        Lesson anotherLesson = new Lesson();
        anotherLesson.setId(2L);
        anotherLesson.setName("testName");
        anotherLesson.setDescription("testDesc");
        anotherLesson.setComplete(false);
        anotherLesson.setCourse(null);
        anotherLesson.setLessonSteps(null);
        List<Lesson> expectedLessonList = new ArrayList<>();
        expectedLessonList.add(lesson);
        expectedLessonList.add(anotherLesson);
        //when
        Mockito.when(lessonRepository.findAll()).thenReturn(expectedLessonList);
        List<Lesson> actualLessonsList = underTestLesson.getAllLessons();

        //then
        assertThat(actualLessonsList).isEqualTo(expectedLessonList);

    }

    @Test
    void canAddNewLesson() {
        //given
        LessonDto expectedLessonDto = new LessonDto();
        expectedLessonDto.setId(1L);
        expectedLessonDto.setName("testName");
        expectedLessonDto.setComplete(false);
        expectedLessonDto.setCourseId(null);
        expectedLessonDto.setLessonStepsId(Collections.emptyList());
        expectedLessonDto.setDescription("testDesc");
        //when
        Mockito.when(lessonRepository.save(lesson)).thenReturn(lesson); //Погуглить про "any"
        LessonDto actualLessonDto = underTestLesson.addNewLesson(lesson);
        //then
        assertThat(actualLessonDto).isEqualTo(expectedLessonDto);
    }

    @Test
    @Disabled
    void toLesson() {

    }

    @Test
    @Disabled
    void fromLesson() {

    }

    @Test
    @Disabled
    void getAllLessonsDto() {
    }

    @Test
    @Disabled
    void getLessonDtoById() {
    }

    @Test
    @Disabled
    void updateLesson() {
    }

    @Test
    @Disabled
    void getLessonById() {
    }

    @Test
    @Disabled
    void deleteLessonById() {
    }
}