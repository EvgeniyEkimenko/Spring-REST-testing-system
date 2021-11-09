package com.ekimenko.spring.rest.SpringRESTtestingsystem.service;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.Course;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.test.TestResult;

import java.util.List;

public interface CourseService {

    List<Course> getAllCourses();

    Course addNewCourse(Course course);

    Course updateCourse(Course course);

    Course getCourseById(Long id);

    void deleteCourseById(Long id);


}
