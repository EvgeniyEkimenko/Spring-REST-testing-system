package com.ekimenko.spring.rest.SpringRESTtestingsystem.service.answer_service.AnswerServiceUtil;


import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.answer.AnswerResult;

import java.util.ArrayList;
import java.util.List;

public class AnswerResultServiceUtil {

    public static List<Long> getAllIdFromAnswerResultList(List<AnswerResult> answerResultList) {
        List<Long> listId = new ArrayList<>();

        for (AnswerResult t : answerResultList) {
            listId.add(t.getId());
        }
        return listId;
    }

}
