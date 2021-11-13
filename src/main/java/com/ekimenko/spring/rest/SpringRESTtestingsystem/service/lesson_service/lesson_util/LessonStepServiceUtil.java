package com.ekimenko.spring.rest.SpringRESTtestingsystem.service.lesson_service.lesson_util;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.LessonStep;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LessonStepServiceUtil {

    public static List<Long> getAllIdFromLessonStepList(List<LessonStep> lessonStepList) {
        List<Long> listId = new ArrayList<>();

        for (LessonStep t : lessonStepList) {
            listId.add(t.getId());
        }
        return listId;
    }

}
