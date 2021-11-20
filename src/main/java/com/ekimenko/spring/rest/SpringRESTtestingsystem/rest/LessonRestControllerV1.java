package com.ekimenko.spring.rest.SpringRESTtestingsystem.rest;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.dto.LessonDto;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.Lesson;
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

    @GetMapping(value = "")
    public ResponseEntity<List<LessonDto>> getAllLessons() {

        List<LessonDto> lessonDtoList = lessonService.getAllLessonsDto();

        return new ResponseEntity<>(lessonDtoList, HttpStatus.OK);
    }

    @PostMapping(value = "")
    public void addNewLesson(@RequestBody LessonDto lessonDto) {

/*        Lesson lesson = lessonDto.toLesson();
        lessonService.addNewLesson(lesson);*/

    }

    @PutMapping(value = "")
    public void updateLesson(@RequestBody LessonDto lessonDto) {

/*        Lesson lesson = lessonDto.toLesson();
        lessonService.updateLesson(lesson);*/

    }

    @DeleteMapping(value = "/{id}")
    public void deleteLessonByID(@PathVariable long id) {

        lessonService.deleteLessonById(id);

    }
}