package com.ekimenko.spring.rest.SpringRESTtestingsystem.service.question_service.impl;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.dto.question_dto.QuestionDto;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.question.Question;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.repository.question_repos.QuestionRepository;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.service.answer_service.AnswerResultService;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.service.question_service.QuestionService;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.service.service_util.ServiceUtil;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.service.test_service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@Slf4j
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;
    private final TestService testService;
    private final AnswerResultService answerResultService;

    public QuestionServiceImpl(QuestionRepository questionRepository
            ,@Lazy TestService testService
            ,@Lazy AnswerResultService answerResultService) {
        this.questionRepository = questionRepository;
        this.testService = testService;
        this.answerResultService = answerResultService;
    }


    @Override
    public Question toQuestion(QuestionDto questionDto) {
        Question question = new Question();
        question.setId(questionDto.getId());
        question.setScore(questionDto.getScore());
        question.setPosition(questionDto.getPosition());
        question.setAllowedParticleAnswer(questionDto.getAllowedParticleAnswer());
        question.setText(questionDto.getText());
        question.setTest(testService.getTestById(questionDto.getId()));
        question.setAnswerVariants(answerResultService.getAnswerVariantListForResult(questionDto.getAnswerVariantsId()));
        //question.setAnswerResults();
        return question;
    }

    @Override
    public QuestionDto fromQuestion(Question question) {
        QuestionDto questionDto = new QuestionDto();
        questionDto.setId(question.getId());
        questionDto.setScore(question.getScore());
        questionDto.setText(question.getText());
        questionDto.setPosition(question.getPosition());
        questionDto.setAllowedParticleAnswer(question.isAllowedParticleAnswer());
        questionDto.setTestId(question.getTest().getId());
        questionDto.setAnswerResultsId(ServiceUtil.getIds(question.getAnswerResults()));
        questionDto.setAnswerVariantsId(ServiceUtil.getIds(question.getAnswerVariants()));

        return questionDto;
    }

    @Override
    public List<QuestionDto> getAllQuestionsDto() {
        List<Question> results = getAllQuestions();

        List<QuestionDto> questionDtoList = new ArrayList<>();
        for (Question result : results) {
            questionDtoList.add(fromQuestion(result));
        }
        return questionDtoList;
    }

    @Override
    public QuestionDto getQuestionDtoById(long id) {
        return fromQuestion(getQuestionById(id));
    }

    @Override
    public List<Question> getAllQuestions() {
        List<Question> questions = questionRepository.findAll();

        log.info("IN getAllQuestions - {} Questions found", questions.size());
        return questions;
    }

    @Override
    public void addNewQuestion(Question question) {
        //TODO add log info
        questionRepository.save(question);
    }

    @Override
    public void updateQuestion(Question question) {
        //TODO add log info
        questionRepository.save(question);
    }


    @Override
    public Question getQuestionById(Long id) {
        Question question = questionRepository.findById(id).orElse(null);
        if (question == null) {
            log.warn("IN getQuestionById - no questions found by id: {}", id);
            return null;
        }
        log.info("IN getQuestionById  - question: {} found by id: {}", question, id);
        return question;
    }

    @Override
    public void deleteQuestionById(Long id) {
        questionRepository.deleteById(id);
        log.info("IN deleteQuestionById - Question with id: {} successfully deleted", id);
    }

}
