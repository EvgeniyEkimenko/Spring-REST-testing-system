package com.ekimenko.spring.rest.SpringRESTtestingsystem.service.question_service;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.dto.question_dto.QuestionDto;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.question.Question;

import java.util.List;

public interface QuestionService {

    Question toQuestion(QuestionDto questionDto);

    QuestionDto fromQuestion(Question question);

    List<QuestionDto> getAllQuestionsDto();

    QuestionDto getQuestionDtoById(long id);

    List<Question> getAllQuestions();

    void addNewQuestion(Question question);

    void updateQuestion(Question question);

    Question getQuestionById(Long id);

    void deleteQuestionById(Long id);

}
