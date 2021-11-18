package com.ekimenko.spring.rest.SpringRESTtestingsystem.dto;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.Lesson;
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
        //TODO add code
        return lesson;
    }

}