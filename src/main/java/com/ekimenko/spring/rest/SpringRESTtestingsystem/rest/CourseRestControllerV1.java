package com.ekimenko.spring.rest.SpringRESTtestingsystem.rest;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.dto.CourseDto;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.dto.test_dto.TestResultDto;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.service.course_service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/api/v1/course")
public class CourseRestControllerV1 {

    private final CourseService courseService;

    @Autowired
    public CourseRestControllerV1(CourseService courseService) {
        this.courseService = courseService;
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<CourseDto> getCourseById(@PathVariable long id) {

        CourseDto courseDto = courseService.getCourseDtoById(id);

        return new ResponseEntity<>(courseDto, HttpStatus.OK);
    }

    @GetMapping(value = "")
    public ResponseEntity<List<CourseDto>> getAllCourses() {

        List<CourseDto> courseDtoList = courseService.getAllCoursesDto();

        return new ResponseEntity<>(courseDtoList, HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<CourseDto> addNewCourse(@RequestBody CourseDto courseDto) {

        CourseDto courseDtoRes = courseService
                .addNewCourse(courseService
                        .toCourse(courseDto));

        return new ResponseEntity<>(courseDtoRes, HttpStatus.OK);
    }

    @PutMapping(value = "")
    public ResponseEntity<CourseDto> updateCourse(@RequestBody CourseDto courseDto) {

        CourseDto courseDtoRes = courseService
                .updateCourse(courseService
                        .toCourse(courseDto));

        return new ResponseEntity<>(courseDtoRes, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteCourseByID(@PathVariable long id) {

        courseService.deleteCourseById(id);
    }
}