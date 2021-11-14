package com.ekimenko.spring.rest.SpringRESTtestingsystem.service.answer_service.AnswerServiceUtil;



import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.answer.AnswerVariant;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnswerVariantServiceUtil {

    public static List<Long> getAllIdFromAnswerVariantList(List<AnswerVariant> answerVariantList) {
        List<Long> listId = new ArrayList<>();

        for (AnswerVariant t : answerVariantList) {
            listId.add(t.getId());
        }
        return listId;
    }



}
