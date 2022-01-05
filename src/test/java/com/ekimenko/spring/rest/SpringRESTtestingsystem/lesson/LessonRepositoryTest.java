package com.ekimenko.spring.rest.SpringRESTtestingsystem.lesson;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.Lesson;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.repository.LessonRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

//@SpringBootTest
@DataJpaTest
public class LessonRepositoryTest {

    @Autowired
    private LessonRepository underTest;

    @Test
    @DisplayName("Comparing an object from a database with its with an instance of a class. Expected true")
    void itShouldCheckLessonEqualTestLessonFromDataBase() {
        Lesson lessonTest = new Lesson();
        lessonTest.setName("testName");
        lessonTest.setDescription("testDesc");
        lessonTest.setComplete(false);
        lessonTest.setCourse(null);
        lessonTest.setLessonSteps(null);

        underTest.saveAndFlush(lessonTest);

        Lesson lessonAssert = new Lesson();
        lessonAssert = underTest.getById(1L);

        assertThat(lessonAssert).isEqualTo(lessonTest);
    }

    @Test
    void inShouldCheckLessonExistAfterAdd() {
        //given
        Lesson lessonFirst = new Lesson();
        lessonFirst.setName("testName1");
        lessonFirst.setDescription("testDesc1");
        lessonFirst.setComplete(false);
        lessonFirst.setCourse(null);
        lessonFirst.setLessonSteps(null);
        Lesson lessonSecond = new Lesson();
        lessonSecond.setName("testName2");
        lessonSecond.setDescription("testDesc2");
        lessonSecond.setComplete(false);
        lessonSecond.setCourse(null);
        lessonSecond.setLessonSteps(null);

        //when
        underTest.save(lessonFirst);
        underTest.save(lessonSecond);
        List<Lesson> basicLessonsList = new ArrayList<>();
        basicLessonsList.add(lessonFirst);
        basicLessonsList.add(lessonSecond);
        List<Lesson> lessonListFromDb = underTest.findAll();

        //then
        assertThat(lessonListFromDb).isEqualTo(basicLessonsList);
    }

    @Test
    void updateTest() {
        Lesson lesson = new Lesson();
        lesson.setName("testName");
        lesson.setDescription("testDesc");
        lesson.setComplete(false);
        lesson.setCourse(null);
        lesson.setLessonSteps(null);

        Lesson сhangedLesson = new Lesson();
        сhangedLesson.setId(1L);
        сhangedLesson.setName("changeName");
        сhangedLesson.setDescription("testDesc");
        сhangedLesson.setComplete(false);
        сhangedLesson.setCourse(null);
        сhangedLesson.setLessonSteps(null);

        Lesson expectedChangedLesson = new Lesson();
        expectedChangedLesson.setId(1L);
        expectedChangedLesson.setName("changeName");
        expectedChangedLesson.setDescription("testDesc");
        expectedChangedLesson.setComplete(false);
        expectedChangedLesson.setCourse(null);
        expectedChangedLesson.setLessonSteps(null);

        underTest.save(lesson);
        Lesson actualLesson = underTest.save(сhangedLesson);

        assertThat(actualLesson).isEqualTo(expectedChangedLesson);

    }


}
