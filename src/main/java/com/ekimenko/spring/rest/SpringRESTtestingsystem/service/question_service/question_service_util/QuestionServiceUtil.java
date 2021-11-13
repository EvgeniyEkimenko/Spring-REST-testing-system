package com.ekimenko.spring.rest.SpringRESTtestingsystem.service.question_service.question_service_util;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.question.Question;

import java.util.ArrayList;
import java.util.List;

public class QuestionServiceUtil {

    public static List<Long> getAllIdFromQuestionList(List<Question> questionList) {
        List<Long> listId = new ArrayList<>();

        for (Question t : questionList) {
            listId.add(t.getId());
        }
        return listId;
    }

}
