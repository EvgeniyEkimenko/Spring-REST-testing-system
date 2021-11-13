package com.ekimenko.spring.rest.SpringRESTtestingsystem.dto;


import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.Course;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.service.lesson_service.LessonStepService;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.service.lesson_service.lesson_util.LessonServiceUtil;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CourseDto {
    private Long id;
    private String name;
    private String description;
    private Boolean complete;
    private List<Long> lessonsId;


    public Course toCourse(){
        Course course = new Course();
        course.setId(id);
        course.setName(name);
        course.setDescription(description);
        course.setComplete(complete);

        return course;
    }

    public static CourseDto fromCourse(Course course) {
        CourseDto courseDto = new CourseDto();
        courseDto.setId(course.getId());
        courseDto.setName(course.getName());
        courseDto.setDescription(course.getDescription());
        courseDto.setComplete(course.getComplete());
        courseDto.setLessonsId(LessonServiceUtil.getAllIdFromLessonList(course.getLessons()));

        return courseDto;
    }
}