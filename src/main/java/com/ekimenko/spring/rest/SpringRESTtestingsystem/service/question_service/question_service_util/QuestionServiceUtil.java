package com.ekimenko.spring.rest.SpringRESTtestingsystem.service.question_service.question_service_util;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.LessonStep;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.answer.AnswerResult;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.answer.AnswerVariant;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.question.Question;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.test.Test;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.service.answer_service.AnswerResultService;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.service.answer_service.AnswerVariantService;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.service.lesson_service.LessonStepService;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.service.question_service.QuestionService;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.service.test_service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionServiceUtil {

    private static AnswerVariantService answerVariantService;
    private static QuestionService questionService;
    private static AnswerResultService answerResultService;
    private static TestService testService;
    private static LessonStepService lessonStepService;

    @Autowired
    public QuestionServiceUtil(AnswerVariantService answerVariantService
            , QuestionService questionService
            , AnswerResultService answerResultService
            , TestService testService
            , LessonStepService lessonStepService) {
        QuestionServiceUtil.answerVariantService = answerVariantService;
        QuestionServiceUtil.questionService = questionService;
        QuestionServiceUtil.answerResultService = answerResultService;
        QuestionServiceUtil.testService = testService;
        QuestionServiceUtil.lessonStepService = lessonStepService;
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

    public static void createNewAnswerResult(Long id, Double score) {
        AnswerResult answerResult = new AnswerResult();
        answerResult.setQuestion(questionService.getQuestionById(id));
        answerResult.setScore(score);
        answerResultService.addNewAnswerResult(answerResult);
    }

    public static void setCompleteTrueInQuestion(Long id) {
        Question question = questionService.getQuestionById(id);
        question.setComplete(true);
        questionService.updateQuestion(question);
    }

    public static void checkCompletedTest(Long id) {
        Question question = questionService.getQuestionById(id);
        Test test = testService.getTestById(question.getTest().getId());
        List<Question> questionList = test.getQuestions();

        for (Question tempQuestion : questionList) {
            if (!tempQuestion.isComplete()) return;
        }

        LessonStep lessonStep = lessonStepService.getLessonStepById(test.getLessonStep().getId());
        lessonStep.setComplete(true);
        lessonStepService.updateLessonStep(lessonStep);
    }

}
