package com.ekimenko.spring.rest.SpringRESTtestingsystem.rest;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.dto.CourseDto;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.Course;
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
    public void addNewCourse(@RequestBody CourseDto courseDto) {

/*        Course course = courseDto.toCourse();
        courseService.addNewCourse(course);*/
    }

    @PutMapping(value = "")
    public void updateCourse(@RequestBody CourseDto courseDto) {

/*        Course course = courseDto.toCourse();
        courseService.updateCourse(course);*/
    }

    @DeleteMapping(value = "/{id}")
    public void deleteCourseByID(@PathVariable long id) {

        courseService.deleteCourseById(id);
    }
}