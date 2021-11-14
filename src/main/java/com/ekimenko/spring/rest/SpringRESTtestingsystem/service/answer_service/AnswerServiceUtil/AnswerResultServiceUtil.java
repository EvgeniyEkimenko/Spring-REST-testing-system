package com.ekimenko.spring.rest.SpringRESTtestingsystem.service.answer_service.AnswerServiceUtil;


import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.answer.AnswerResult;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.service.answer_service.AnswerVariantService;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.service.question_service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class AnswerResultServiceUtil {

    private static AnswerVariantService answerVariantService;

    public static List<Long> getAllIdFromAnswerResultList(List<AnswerResult> answerResultList) {
        List<Long> listId = new ArrayList<>();

        for (AnswerResult t : answerResultList) {
            listId.add(t.getId());
        }
        return listId;
    }

}
