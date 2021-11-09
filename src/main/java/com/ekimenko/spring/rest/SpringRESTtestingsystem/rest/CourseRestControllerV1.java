package com.ekimenko.spring.rest.SpringRESTtestingsystem.rest;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.dto.CourseDto;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.Course;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
        Course course = courseService.getCourseById(id);

        CourseDto courseDto = CourseDto.fromCourse(course);

        return new ResponseEntity<>(courseDto, HttpStatus.OK);
    }

    @GetMapping(value = "")
    public ResponseEntity<List<CourseDto>> getAllCourses() {
        List<Course> courseList = courseService.getAllCourses();

        List<CourseDto> courseDtoList = new ArrayList<>();
        for (Course course : courseList) {
            courseDtoList.add(CourseDto.fromCourse(course));
        }
        return new ResponseEntity<>(courseDtoList, HttpStatus.OK);
    }

    @PostMapping(value = "")
    public void addNewCourse(@RequestBody CourseDto courseDto) {

        //TODO solve the problem of implementing the save and update methods

    }

    @PutMapping(value = "")
    public void updateCourse(@RequestBody CourseDto courseDto) {

        //TODO solve the problem of implementing the save and update methods

    }

    @DeleteMapping(value = "/{id}")
    public void deleteCourseByID(@PathVariable long id) {

        courseService.deleteCourseById(id);

    }
}