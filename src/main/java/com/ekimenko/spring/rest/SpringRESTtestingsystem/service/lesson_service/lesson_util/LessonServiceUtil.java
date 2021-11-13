package com.ekimenko.spring.rest.SpringRESTtestingsystem.service.lesson_service.lesson_util;



import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.Lesson;

import java.util.ArrayList;
import java.util.List;

public class LessonServiceUtil {

    public static List<Long> getAllIdFromLessonList(List<Lesson> lessonList) {
        List<Long> listId = new ArrayList<>();

        for (Lesson t : lessonList) {
            listId.add(t.getId());
        }
        return listId;
    }

}
