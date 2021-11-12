package com.ekimenko.spring.rest.SpringRESTtestingsystem.dto;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.dto.test_dto.TestDto;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.LessonStep;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.TheoreticalStep;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class LessonStepDto {
    private Long id;
    private Integer positionInLesson;


    private TheoreticalStep theoreticalStep;
    private TestDto test;
    private Long lessonId;


    public LessonStep toLessonStep() {
        LessonStep lessonStep = new LessonStep();
        lessonStep.setId(id);
        lessonStep.setPositionInLesson(positionInLesson);

        return lessonStep;
    }

    public static LessonStepDto fromLessonStep(LessonStep lessonStep) {
        LessonStepDto lessonStepDto = new LessonStepDto();
        lessonStepDto.setId(lessonStep.getId());
        lessonStepDto.setPositionInLesson(lessonStep.getPositionInLesson());

        lessonStepDto.theoreticalStep = lessonStep.getTheoreticalStep();
        lessonStepDto.test = TestDto.fromTest(lessonStep.getTest());
        lessonStepDto.lessonId = lessonStep.getLesson().getId();

        return lessonStepDto;
    }
}