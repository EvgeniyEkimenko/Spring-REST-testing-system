package com.ekimenko.spring.rest.SpringRESTtestingsystem.service.question_service.question_service_util;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.answer.AnswerResult;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.answer.AnswerVariant;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.question.Question;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.service.answer_service.AnswerResultService;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.service.answer_service.AnswerServiceUtil.AnswerResultServiceUtil;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.service.answer_service.AnswerVariantService;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.service.answer_service.impl.AnswerResultServiceImpl;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.service.question_service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionServiceUtil {

    private static AnswerVariantService answerVariantService;
    private static QuestionService questionService;
    private static AnswerResultService answerResultService;

    @Autowired
    public QuestionServiceUtil(AnswerVariantService answerVariantService
            , QuestionService questionService
            , AnswerResultService answerResultService) {
        this.answerVariantService = answerVariantService;
        this.questionService = questionService;
        this.answerResultService = answerResultService;
    }


    public static List<Long> getAllIdFromQuestionList(List<Question> questionList) {
        List<Long> listId = new ArrayList<>();

        for (Question t : questionList) {
            listId.add(t.getId());
        }
        return listId;
    }

    public static Boolean getCorrect(Long id) {
        AnswerVariant answerVariant = answerVariantService.getAnswerVariantById(id);
        Boolean correct = answerVariant.getCorrect();
        return correct;
    }

    public static int getCountOfCorrectAnswer(Long id) {
        Question question = questionService.getQuestionById(id);
        List<AnswerVariant> answerVariantList = question.getAnswerVariants();
        int count = 0;

        for (AnswerVariant answerVariant : answerVariantList) {
            if (answerVariant.getCorrect()) count++;
        }
        return count;
    }

    public static void createNewAnswerResult(Long id , Double score) {
        AnswerResult answerResult = new AnswerResult();
        answerResult.setQuestion(questionService.getQuestionById(id));
        answerResult.setScore(score);
        answerResultService.addNewAnswerResult(answerResult);
    }

}
