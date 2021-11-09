package com.ekimenko.spring.rest.SpringRESTtestingsystem.rest;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.dto.LessonDto;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.Lesson;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
        Lesson lesson = lessonService.getLessonById(id);

        LessonDto lessonDto = LessonDto.fromLesson(lesson);

        return new ResponseEntity<>(lessonDto, HttpStatus.OK);
    }

    @GetMapping(value = "")
    public ResponseEntity<List<LessonDto>> getAllLessons() {
        List<Lesson> lessonList = lessonService.getAllLessons();

        List<LessonDto> lessonDtos = new ArrayList<>();
        for (Lesson lesson : lessonList) {
            lessonDtos.add(LessonDto.fromLesson(lesson));
        }
        return new ResponseEntity<>(lessonDtos, HttpStatus.OK);
    }

    @PostMapping(value = "")
    public void addNewLesson(@RequestBody LessonDto lessonDto) {

        //TODO solve the problem of implementing the save and update methods

    }

    @PutMapping(value = "")
    public void updateLesson(@RequestBody LessonDto lessonDto) {

        //TODO solve the problem of implementing the save and update methods

    }

    @DeleteMapping(value = "/{id}")
    public void deleteLessonByID(@PathVariable long id) {

        lessonService.deleteLessonById(id);

    }
}