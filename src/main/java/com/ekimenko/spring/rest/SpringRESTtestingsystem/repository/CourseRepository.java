package com.ekimenko.spring.rest.SpringRESTtestingsystem.repository;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course , Long> {
}
