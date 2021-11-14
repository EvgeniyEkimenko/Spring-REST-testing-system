package com.ekimenko.spring.rest.SpringRESTtestingsystem.service.question_service;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.answer.AnswerResult;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.answer.AnswerVariant;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.question.Question;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.test.Test;

import java.util.List;

public interface QuestionService {

    List<Question> getAllQuestions();

    void addNewQuestion(Question question);

    void updateQuestion(Question question);

    Question getQuestionById(Long id);

    void deleteQuestionById(Long id);

    //TODO new functional
    void CalculateTheNumberOfPointsForTheAnswer(Question question);

}
