package com.ekimenko.spring.rest.SpringRESTtestingsystem.service;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.Course;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.Lesson;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.repository.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LessonServiceImpl implements LessonService {

    private final LessonRepository lessonRepository;

    @Autowired
    public LessonServiceImpl(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }

    @Override
    public List<Lesson> getAllLessons() {
        List<Lesson> lessons = lessonRepository.findAll();
        return lessons;
    }

    @Override
    public Lesson addNewLesson(Lesson lesson) {
        return lessonRepository.save(lesson);
    }

    @Override
    public Lesson updateLesson(Lesson lesson) {
        return lessonRepository.save(lesson);
    }

    @Override
    public Lesson getLessonById(Long id) {
        Lesson lesson = lessonRepository.findById(id).orElse(null);
        if (lesson == null) {
            //TODO add log info
            return null;
        }
        //TODO add log info
        return lesson;
    }

    @Override
    public void deleteLessonById(Long id) {
        lessonRepository.deleteById(id);
    }
}
