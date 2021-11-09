package com.ekimenko.spring.rest.SpringRESTtestingsystem.service;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.Course;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService{

    private final CourseRepository courseRepository;

    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Course> getAllCourses() {
        List<Course> courses = courseRepository.findAll();
        return courses;
    }

    @Override
    public Course addNewCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course updateCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course getCourseById(Long id) {
        Course course = courseRepository.findById(id).orElse(null);
        if (course == null) {
            //TODO add log info
            return null;
        }
        //TODO add log info
        return course;
    }

    @Override
    public void deleteCourseById(Long id) {
        courseRepository.deleteById(id);
    }
}
