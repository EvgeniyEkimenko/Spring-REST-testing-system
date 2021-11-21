package com.ekimenko.spring.rest.SpringRESTtestingsystem.service.lesson_service.impl;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.dto.LessonDto;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.Lesson;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.LessonStep;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.repository.LessonRepository;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.service.lesson_service.LessonService;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.service.lesson_service.LessonStepService;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.service.service_util.ServiceUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class LessonServiceImpl implements LessonService {

    private final LessonRepository lessonRepository;
    private final LessonStepService lessonStepService;


    @Autowired
    public LessonServiceImpl(LessonRepository lessonRepository
            , @Lazy LessonStepService lessonStepService) {
        this.lessonRepository = lessonRepository;
        this.lessonStepService = lessonStepService;
    }

    @Override
    public Lesson toLesson(LessonDto lessonDto) {
        Lesson lesson = new Lesson();
        lesson.setId(lessonDto.getId());
        lesson.setComplete(lessonDto.getComplete());
        lesson.setDescription(lessonDto.getDescription());
        lesson.setName(lessonDto.getName());
        lesson.setLessonSteps(getLessonStepListByListId(lessonDto.getLessonStepsId()));
        //lesson.setCourse(courseService.getCourseById(lessonDto.getCourseId()));
        return lesson;
    }


    public List<LessonStep> getLessonStepListByListId(List<Long> lessonStepIdList) {
        List<LessonStep> lessonStepList = new ArrayList<>();
        for (int i = 0; i < lessonStepIdList.size(); i++) {
            lessonStepList.add(lessonStepService.getLessonStepById(lessonStepIdList.get(i)));
        }
        return lessonStepList;
    }


    @Override
    public LessonDto fromLesson(Lesson lesson) {
        LessonDto lessonDto = new LessonDto();
        lessonDto.setId(lesson.getId());
        lessonDto.setName(lesson.getName());
        lessonDto.setDescription(lesson.getDescription());
        lessonDto.setComplete(lesson.getComplete());
        lessonDto.setCourseId(lesson.getCourse().getId());
        lessonDto.setLessonStepsId(ServiceUtil.getIds(lesson.getLessonSteps()));

        return lessonDto;
    }

    @Override
    public List<LessonDto> getAllLessonsDto() {
        List<Lesson> results = getAllLessons();

        List<LessonDto> lessonDtoList = new ArrayList<>();
        for (Lesson result : results) {
            lessonDtoList.add(fromLesson(result));
        }
        return lessonDtoList;
    }

    @Override
    public LessonDto getLessonDtoById(long id) {
        return fromLesson(getLessonById(id));
    }

    @Override
    public List<Lesson> getAllLessons() {
        List<Lesson> lessons = lessonRepository.findAll();
        log.info("IN getAllLessons - {} lessons found", lessons.size());
        return lessons;
    }

    @Override
    public LessonDto addNewLesson(Lesson lesson) {
        Lesson lessonResult = lessonRepository.save(lesson);
        //TODO add log info
        return fromLesson(lessonResult);
    }

    @Override
    public LessonDto updateLesson(Lesson lesson) {
        Lesson lessonResult = lessonRepository.save(lesson);
        //TODO add log info
        return fromLesson(lessonResult);
    }

    @Override
    public Lesson getLessonById(Long id) {
        Lesson lesson = lessonRepository.findById(id).orElse(null);
        if (lesson == null) {
            log.warn("IN getLessonById - no lessons found by id: {}", id);
            return null;
        }
        log.info("IN getLessonById  - lesson: {} found by id: {}", lesson, id);
        return lesson;
    }

    @Override
    public void deleteLessonById(Long id) {
        lessonRepository.deleteById(id);
        log.info("IN deleteLessonById - Lesson with id: {} successfully deleted", id);
    }
}
