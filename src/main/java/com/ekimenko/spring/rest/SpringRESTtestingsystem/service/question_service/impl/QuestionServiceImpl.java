package com.ekimenko.spring.rest.SpringRESTtestingsystem.service.question_service.impl;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.question.Question;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.repository.question_repos.QuestionRepository;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.service.question_service.QuestionService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;

    public QuestionServiceImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public List<Question> getAllQuestions() {
        List<Question> questions = questionRepository.findAll();

        //TODO add log info
        return questions;
    }

    @Override
    public void addNewQuestion(Question question) {
        questionRepository.save(question);
    }

    @Override
    public void updateQuestion(Question question) {
        questionRepository.save(question);
    }


    @Override
    public Question getQuestionById(Long id) {
        Question question = questionRepository.getById(id);
        //TODO add log info
        return question;
    }

    @Override
    public void deleteQuestionById(Long id) {
        questionRepository.deleteById(id);
        //TODO add log info
    }
}
