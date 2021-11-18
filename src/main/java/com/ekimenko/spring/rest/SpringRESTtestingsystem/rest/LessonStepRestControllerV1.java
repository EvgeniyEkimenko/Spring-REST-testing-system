package com.ekimenko.spring.rest.SpringRESTtestingsystem.rest;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.dto.LessonStepDto;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.LessonStep;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.service.lesson_service.LessonStepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/lesson_step")
public class LessonStepRestControllerV1 {

    private final LessonStepService lessonStepService;

    @Autowired
    public LessonStepRestControllerV1(LessonStepService lessonStepService) {
        this.lessonStepService = lessonStepService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<LessonStepDto> getLessonStepById(@PathVariable long id) {

        LessonStepDto lessonStepDto = lessonStepService.getLessonStepDtoById(id);

        return new ResponseEntity<>(lessonStepDto, HttpStatus.OK);
    }

    @GetMapping(value = "")
    public ResponseEntity<List<LessonStepDto>> getAllLessonSteps() {

        List<LessonStepDto> lessonStepDtoList = lessonStepService.getAllLessonStepsDto();

        return new ResponseEntity<>(lessonStepDtoList, HttpStatus.OK);
    }

    @PostMapping(value = "")
    public void addNewLessonStep(@RequestBody LessonStepDto lessonStepDto) {

        LessonStep lessonStep = lessonStepDto.toLessonStep();
        lessonStepService.addNewLessonStep(lessonStep);
    }

    @PutMapping(value = "")
    public void updateLessonStep(@RequestBody LessonStepDto lessonStepDto) {

        LessonStep lessonStep = lessonStepDto.toLessonStep();
        lessonStepService.updateLessonStep(lessonStep);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteLessonStepByID(@PathVariable long id) {
        lessonStepService.deleteLessonStepById(id);
    }
}
