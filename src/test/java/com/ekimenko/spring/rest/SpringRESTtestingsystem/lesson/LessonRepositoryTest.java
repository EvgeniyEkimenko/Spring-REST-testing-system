package com.ekimenko.spring.rest.SpringRESTtestingsystem.lesson;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.Course;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.Lesson;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.repository.LessonRepository;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.rest.LessonRestControllerV1;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class LessonRepositoryTest {

    @Autowired
    private LessonRepository lessonRepository;

    @Test
    void itShouldCheckInstanceIsExist() {
/*        Lesson lesson = new Lesson();
        lesson.setId(1L);
        lesson.setName("testName");
        lesson.setDescription("testDesc");
        lesson.setComplete(false);
        lesson.setCourse(null);
        lesson.setLessonSteps(null);

        lessonRepository.save(lesson);

        Lesson lessonAssert = new Lesson();
        lessonAssert = lessonRepository.getById(1L);
        boolean isEmp = lessonAssert.getLessonSteps().isEmpty();

        assertThat(isEmp).isFalse();*/
    }

}
