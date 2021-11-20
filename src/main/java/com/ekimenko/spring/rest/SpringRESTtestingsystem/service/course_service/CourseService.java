package com.ekimenko.spring.rest.SpringRESTtestingsystem.service.course_service;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.dto.CourseDto;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.Course;

import java.util.List;

public interface CourseService {

    Course toCourse(CourseDto courseDto);

    CourseDto fromCourse(Course course);

    List<CourseDto> getAllCoursesDto();

    CourseDto getCourseDtoById(long id);

    List<Course> getAllCourses();

    Course addNewCourse(Course course);

    Course updateCourse(Course course);

    Course getCourseById(Long id);

    void deleteCourseById(Long id);


}
