package com.ekimenko.spring.rest.SpringRESTtestingsystem.dto;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.Lesson;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.service.lesson_service.lesson_util.LessonServiceUtil;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.service.lesson_service.lesson_util.LessonStepServiceUtil;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class LessonDto {
    private Long id;
    private String name;
    private String description;
    private Boolean complete;
    private Long courseId;
    private List<Long> lessonStepsId;

    public Lesson toLesson(){
        Lesson lesson = new Lesson();
        lesson.setId(id);
        lesson.setName(name);
        lesson.setDescription(description);
        lesson.setComplete(complete);

        return lesson;
    }

    public static LessonDto fromLesson(Lesson lesson) {
        LessonDto lessonDto = new LessonDto();
        lessonDto.setId(lesson.getId());
        lessonDto.setName(lesson.getName());
        lessonDto.setDescription(lesson.getDescription());
        lessonDto.setComplete(lesson.getComplete());
        lessonDto.setCourseId(lesson.getCourse().getId());
        lessonDto.setLessonStepsId(LessonStepServiceUtil.getAllIdFromLessonStepList(lesson.getLessonSteps()));

        return lessonDto;
    }
}