package com.ekimenko.spring.rest.SpringRESTtestingsystem.lesson;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.Lesson;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.repository.LessonRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class LessonRepositoryTest {

    @Autowired
    private LessonRepository lessonRepository;


    @Test
    @DisplayName("Comparing an object from a database with its with an instance of a class. Expected true")
    void itShouldCheckLessonEqualTestLessonFromDataBase() {
        Lesson lesson = new Lesson();
        lesson.setName("testName");
        lesson.setDescription("testDesc");
        lesson.setComplete(false);
        lesson.setCourse(null);
        lesson.setLessonSteps(null);

        lessonRepository.save(lesson);

        Lesson lessonAssert = new Lesson();
        lessonAssert = lessonRepository.getById(1L);

        assertThat(lessonAssert).isEqualTo(lesson);
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
        lessonRepository.save(lessonFirst);
        lessonRepository.save(lessonSecond);
        List<Lesson> basicLessonsList = new ArrayList<>();
        basicLessonsList.add(lessonFirst);
        basicLessonsList.add(lessonSecond);
        List<Lesson> lessonListFromDb = lessonRepository.findAll();

        //then
        assertThat(lessonListFromDb).isEqualTo(basicLessonsList);

    }

}
