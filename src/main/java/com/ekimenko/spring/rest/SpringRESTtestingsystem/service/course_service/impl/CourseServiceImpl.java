package com.ekimenko.spring.rest.SpringRESTtestingsystem.service.course_service.impl;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.Course;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.repository.CourseRepository;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.service.course_service.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Course> getAllCourses() {
        List<Course> courses = courseRepository.findAll();
        log.info("IN getAllCourses - {} courses found", courses.size());
        return courses;
    }

    @Override
    public Course addNewCourse(Course course) {
        //TODO add log info
        return courseRepository.save(course);
    }

    @Override
    public Course updateCourse(Course course) {
        //TODO add log info
        return courseRepository.save(course);
    }

    @Override
    public Course getCourseById(Long id) {
        Course course = courseRepository.findById(id).orElse(null);
        if (course == null) {
            log.warn("IN getCourseById - no courses found by id: {}", id);
            return null;
        }
        log.info("IN getCourseById  - course: {} found by id: {}", course, id);
        return course;
    }

    @Override
    public void deleteCourseById(Long id) {
        courseRepository.deleteById(id);
        log.info("IN deleteCourseById - Course with id: {} successfully deleted", id);
    }
}
