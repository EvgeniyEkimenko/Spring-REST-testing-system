package com.ekimenko.spring.rest.SpringRESTtestingsystem.service.course_service.impl;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.dto.CourseDto;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.Course;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.Lesson;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.user.User;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.repository.CourseRepository;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.service.course_service.CourseService;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.service.lesson_service.LessonService;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.service.service_util.ServiceUtil;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.service.user_service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final LessonService lessonService;
    private final UserService userService;

    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository
            , @Lazy LessonService lessonService
            , @Lazy UserService userService) {
        this.courseRepository = courseRepository;
        this.lessonService = lessonService;
        this.userService = userService;
    }

    @Override
    public Course toCourse(CourseDto courseDto) {
        Course course = new Course();
        course.setId(courseDto.getId());
        course.setComplete(courseDto.getComplete());
        course.setDescription(courseDto.getDescription());
        course.setName(courseDto.getName());
        course.setLessons(getLessonListByListId(courseDto.getLessonsId()));
        course.setUsers(getUserListByListId(courseDto.getUsersId()));

        return course;
    }

    public List<Lesson> getLessonListByListId(List<Long> lessonsId) {
        List<Lesson> lessonList = new ArrayList<>();
        for (int i = 0; i < lessonsId.size(); i++) {
            lessonList.add(lessonService.getLessonById(lessonsId.get(i)));
        }
        return lessonList;
    }

    public List<User> getUserListByListId(List<Long> usersId) {
        List<User> userList = new ArrayList<>();
        for (int i = 0; i < usersId.size(); i++) {
            userList.add(userService.findById(usersId.get(i)));
        }
        return userList;
    }

    @Override
    public CourseDto fromCourse(Course course) {
        CourseDto courseDto = new CourseDto();
        courseDto.setId(course.getId());
        courseDto.setName(course.getName());
        courseDto.setDescription(course.getDescription());
        courseDto.setComplete(course.getComplete());
        courseDto.setLessonsId(ServiceUtil.getIds(course.getLessons()));
        courseDto.setUsersId(ServiceUtil.getIds(course.getUsers()));

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
    public CourseDto addNewCourse(Course course) {
        Course courseResult = courseRepository.save(course);
        log.info("IN addNewCourse - Course : {} successfully added", courseResult);
        return fromCourse(courseResult);
    }

    @Override
    public CourseDto updateCourse(Course course) {
        Course courseResult = courseRepository.save(course);
        log.info("IN addNewCourse - Course : {} successfully updated", courseResult);
        return fromCourse(courseResult);
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
