package com.ekimenko.spring.rest.SpringRESTtestingsystem.rest;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.dto.LessonDto;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.service.lesson_service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/api/v1/lesson")
public class LessonRestControllerV1 {

    private final LessonService lessonService;

    @Autowired
    public LessonRestControllerV1(LessonService lessonService) {
        this.lessonService = lessonService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<LessonDto> getLessonById(@PathVariable long id) {

        LessonDto lessonDto = lessonService.getLessonDtoById(id);

        return new ResponseEntity<>(lessonDto, HttpStatus.OK);
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<LessonDto>> getAllLessons() {

        List<LessonDto> lessonDtoList = lessonService.getAllLessonsDto();

        return new ResponseEntity<>(lessonDtoList, HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<LessonDto> addNewLesson(@RequestBody LessonDto lessonDto) {

        LessonDto lessonDtoRes = lessonService
                .addNewLesson(lessonService
                        .toLesson(lessonDto));

        return new ResponseEntity<>(lessonDtoRes, HttpStatus.OK);
    }

    @PutMapping(value = "")
    public ResponseEntity<LessonDto> updateLesson(@RequestBody LessonDto lessonDto) {

        LessonDto lessonDtoRes = lessonService
                .updateLesson(lessonService
                        .toLesson(lessonDto));

        return new ResponseEntity<>(lessonDtoRes, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteLessonByID(@PathVariable long id) {

        lessonService.deleteLessonById(id);

    }
}