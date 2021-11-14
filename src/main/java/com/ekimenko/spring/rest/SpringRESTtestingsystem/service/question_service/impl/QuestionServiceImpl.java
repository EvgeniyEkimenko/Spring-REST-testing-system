package com.ekimenko.spring.rest.SpringRESTtestingsystem.service.question_service.impl;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.answer.AnswerVariant;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.question.Question;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.repository.question_repos.QuestionRepository;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.service.question_service.QuestionService;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.service.question_service.question_service_util.QuestionServiceUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Slf4j
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;

    public QuestionServiceImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
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

    //TODO new functional (Получаем лист с инициализированным id и листом answer_variant у которых только id)
    @Override
    public void CalculateTheNumberOfPointsForTheAnswer(Question question) {
        List<AnswerVariant> answerVariantList = question.getAnswerVariants();
        int countOfCorrectAnswer = QuestionServiceUtil.getCountOfCorrectAnswer(question.getId());

        for (AnswerVariant answerVariant : answerVariantList) {
            if (QuestionServiceUtil.getCorrect(answerVariant.getId())) {
                double score = 0;
                score+= (1/(double)countOfCorrectAnswer);
                QuestionServiceUtil.createNewAnswerResult(question.getId(), score);
            }
            else {
                QuestionServiceUtil.createNewAnswerResult(question.getId(), (double)0);
            }
        }
    }

}
