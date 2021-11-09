package com.ekimenko.spring.rest.SpringRESTtestingsystem.repository;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.TheoreticalStep;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheoreticalStepRepository extends JpaRepository<TheoreticalStep, Long> {
}
