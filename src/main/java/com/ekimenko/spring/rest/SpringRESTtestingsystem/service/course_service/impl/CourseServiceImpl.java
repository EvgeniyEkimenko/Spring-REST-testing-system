package com.ekimenko.spring.rest.SpringRESTtestingsystem.service.course_service.impl;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.dto.CourseDto;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.dto.answer_dto.AnswerVariantDto;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.Course;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.answer.AnswerVariant;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.repository.CourseRepository;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.service.course_service.CourseService;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.service.service_util.ServiceUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public CourseDto fromCourse(Course course) {
        CourseDto courseDto = new CourseDto();
        courseDto.setId(course.getId());
        courseDto.setName(course.getName());
        courseDto.setDescription(course.getDescription());
        courseDto.setComplete(course.getComplete());
        //FIXME courseDto.setLessonsId(ServiceUtil.getIds(course.getLessons());
        //FIXME courseDto.setUsersId(course.getUsers());

        return courseDto;
    }

    @Override
    public List<CourseDto> getAllCoursesDto() {
        List<Course> results = getAllCourses();

        List<CourseDto> courseDtoList = new ArrayList<>();
        for (Course result : results) {
            courseDtoList.add(fromCourse(result));
        }
        return courseDtoList;
    }

    @Override
    public CourseDto getCourseDtoById(long id) {
        return fromCourse(getCourseById(id));
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
