package com.ekimenko.spring.rest.SpringRESTtestingsystem.service.lesson_service.impl;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.dto.LessonDto;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.Lesson;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.repository.LessonRepository;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.service.course_service.CourseService;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.service.lesson_service.LessonStepService;
import org.junit.jupiter.api.BeforeEach;
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
    void fromLesson() {
        //given
        LessonDto expectedLessonDto = new LessonDto();
        expectedLessonDto.setId(1L);
        expectedLessonDto.setName("testName");
        expectedLessonDto.setComplete(false);
        expectedLessonDto.setCourseId(null);
        expectedLessonDto.setLessonStepsId(Collections.emptyList());
        expectedLessonDto.setDescription("testDesc");
        //when
        LessonDto actualLessonDto = underTestLesson.fromLesson(lesson);
        //then
        assertThat(actualLessonDto).isEqualTo(expectedLessonDto);
    }

    @Test
    void getAllLessonsDto() {
        //given
        Lesson anotherLesson = new Lesson();
        anotherLesson.setId(2L);
        anotherLesson.setName("testName");
        anotherLesson.setDescription("testDesc");
        anotherLesson.setComplete(false);
        anotherLesson.setCourse(null);
        anotherLesson.setLessonSteps(null);
        List<Lesson> lessonList = new ArrayList<>();
        lessonList.add(lesson);
        lessonList.add(anotherLesson);

        LessonDto lessonDtoFirst = new LessonDto();
        lessonDtoFirst.setId(1L);
        lessonDtoFirst.setName("testName");
        lessonDtoFirst.setComplete(false);
        lessonDtoFirst.setCourseId(null);
        lessonDtoFirst.setLessonStepsId(Collections.emptyList());
        lessonDtoFirst.setDescription("testDesc");

        LessonDto lessonDtoSecond = new LessonDto();
        lessonDtoSecond.setId(2L);
        lessonDtoSecond.setName("testName");
        lessonDtoSecond.setComplete(false);
        lessonDtoSecond.setCourseId(null);
        lessonDtoSecond.setLessonStepsId(Collections.emptyList());
        lessonDtoSecond.setDescription("testDesc");

        List<LessonDto> expectedLessonDtoList = new ArrayList<>();
        expectedLessonDtoList.add(lessonDtoFirst);
        expectedLessonDtoList.add(lessonDtoSecond);
        //when
        Mockito.when(lessonRepository.findAll()).thenReturn(lessonList);
        List<LessonDto> actualLessonDtoList = underTestLesson.getAllLessonsDto();
        //then
        assertThat(actualLessonDtoList).isEqualTo(expectedLessonDtoList);
    }

    @Test
    void getLessonDtoById() {
        //given
        LessonDto expectedLessonDto = new LessonDto();
        expectedLessonDto.setId(1L);
        expectedLessonDto.setName("testName");
        expectedLessonDto.setComplete(false);
        expectedLessonDto.setCourseId(null);
        expectedLessonDto.setLessonStepsId(Collections.emptyList());
        expectedLessonDto.setDescription("testDesc");

        //when
        Mockito.when(lessonRepository.findById(1L)).thenReturn(java.util.Optional.ofNullable(lesson));
        LessonDto actualLessonDto = underTestLesson.getLessonDtoById(1L);
        //then
        assertThat(actualLessonDto).isEqualTo(expectedLessonDto);
    }

    @Test
    void updateLesson() {
        //given - lesson from setUp
        LessonDto expectedLessonDto = new LessonDto();
        expectedLessonDto.setId(1L);
        expectedLessonDto.setName("testName");
        expectedLessonDto.setComplete(false);
        expectedLessonDto.setCourseId(null);
        expectedLessonDto.setLessonStepsId(Collections.emptyList());
        expectedLessonDto.setDescription("testDesc");

        //when
        Mockito.when(lessonRepository.save(lesson)).thenReturn(lesson);
        LessonDto actualLessonDto = underTestLesson.updateLesson(lesson);
        //then
        assertThat(actualLessonDto).isEqualTo(expectedLessonDto);
    }

    @Test
    void getLessonById() {
        //given
        Lesson expectedLesson = lesson;
        //when
        Mockito.when(lessonRepository.findById(1L)).thenReturn(java.util.Optional.ofNullable(lesson));
        Lesson actualLesson = underTestLesson.getLessonById(1L);
        //then
        assertThat(actualLesson).isEqualTo(expectedLesson);

    }

    @Test
    void deleteLessonById() {
        underTestLesson.deleteLessonById(1L);
        verify(lessonRepository).deleteById(1L);
    }
}