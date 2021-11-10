package com.ekimenko.spring.rest.SpringRESTtestingsystem.repository;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.LessonStep;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonStepRepository extends JpaRepository<LessonStep , Long> {
}
