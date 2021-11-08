package com.ekimenko.spring.rest.SpringRESTtestingsystem.repository.question_repos;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.question.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}
