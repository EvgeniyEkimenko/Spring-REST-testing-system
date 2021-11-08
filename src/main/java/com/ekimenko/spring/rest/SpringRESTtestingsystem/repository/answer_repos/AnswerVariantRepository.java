package com.ekimenko.spring.rest.SpringRESTtestingsystem.repository.answer_repos;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.answer.AnswerVariant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerVariantRepository extends JpaRepository<AnswerVariant, Long> {
}
