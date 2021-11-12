package com.ekimenko.spring.rest.SpringRESTtestingsystem.dto;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.LessonStep;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class LessonStepDto {
    private Long id;
    private Integer positionInLesson;
    private Long theoreticalStepId;
    private Long testId;
    private Long lessonId;


    public LessonStep toLessonStep(){
        LessonStep lessonStep = new LessonStep();
        lessonStep.setId(id);
        lessonStep.setPositionInLesson(positionInLesson);

        return lessonStep;
    }

    public static LessonStepDto fromLessonStep(LessonStep lessonStep) {
        LessonStepDto lessonStepDto = new LessonStepDto();
        lessonStepDto.setId(lessonStep.getId());
        lessonStepDto.setPositionInLesson(lessonStep.getPositionInLesson());

        return lessonStepDto;
    }
}