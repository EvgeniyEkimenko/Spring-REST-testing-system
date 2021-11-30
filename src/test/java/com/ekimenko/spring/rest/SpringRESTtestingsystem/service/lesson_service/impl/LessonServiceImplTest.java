package com.ekimenko.spring.rest.SpringRESTtestingsystem.service.lesson_service.impl;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.Lesson;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.repository.LessonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class LessonServiceImplTest {


    private LessonServiceImpl underTestLesson;
    @Mock private LessonRepository lessonRepository;
    private LessonStepServiceImpl underTestLessonStep;

    @BeforeEach
    void setUp() {
        underTestLesson = new LessonServiceImpl(lessonRepository , underTestLessonStep);
    }

    @Test
    void canGetAllLessons() {
        //when
        underTestLesson.getAllLessons();
        //then
        verify(lessonRepository).findAll();

    }

    @Test
    void canAddNewLesson() {
        //given
        Lesson lesson = new Lesson();
        lesson.setName("testName");
        lesson.setDescription("testDesc");
        lesson.setComplete(false);
        lesson.setCourse(null);
        lesson.setLessonSteps(null);
        //when
        underTestLesson.addNewLesson(lesson);
        //then
        ArgumentCaptor<Lesson> lessonArgumentCaptor = ArgumentCaptor
                .forClass(Lesson.class);

        verify(lessonRepository).save(lessonArgumentCaptor.capture());
        Lesson captorLesson = lessonArgumentCaptor.getValue();
        assertThat(captorLesson).isEqualTo(lesson);
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