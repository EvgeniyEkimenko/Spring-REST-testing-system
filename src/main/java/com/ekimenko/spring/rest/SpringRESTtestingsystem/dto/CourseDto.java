package com.ekimenko.spring.rest.SpringRESTtestingsystem.dto;


import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.Course;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CourseDto {
    private Long id;
    private String name;
    private String description;
    private Boolean complete;


    public Course toCourse(){
        Course course = new Course();
        course.setId(id);
        course.setName(name);
        course.setDescription(description);
        course.setComplete(complete);

        return course;
    }

    public static CourseDto fromCourse(Course lesson) {
        CourseDto courseDto = new CourseDto();
        courseDto.setId(lesson.getId());
        courseDto.setName(lesson.getName());
        courseDto.setDescription(lesson.getDescription());
        courseDto.setComplete(lesson.getComplete());

        return courseDto;
    }
}