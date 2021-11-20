package com.ekimenko.spring.rest.SpringRESTtestingsystem.repository;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonRepository extends JpaRepository<Lesson, Long> {
}
