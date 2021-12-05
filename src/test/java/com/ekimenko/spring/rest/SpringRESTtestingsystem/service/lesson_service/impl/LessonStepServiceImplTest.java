package com.ekimenko.spring.rest.SpringRESTtestingsystem.service.lesson_service.impl;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.dto.LessonStepDto;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.LessonStep;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.repository.LessonStepRepository;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.service.lesson_service.LessonService;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.service.test_service.TestService;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.service.theoretical_step_service.TheoreticalStepService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class LessonStepServiceImplTest {

    @Mock
    private LessonService lessonService;
    @Mock
    private TestService testService;
    @Mock
    private TheoreticalStepService theoreticalStepService;
    @Mock
    private LessonStepRepository lessonStepRepository;
    @InjectMocks
    private LessonStepServiceImpl underTestLessonStep;

    private LessonStep lessonStep;

    @BeforeEach
    void setUp() {
        lessonStep = new LessonStep();
        lessonStep.setId(1L);
        lessonStep.setComplete(false);
        lessonStep.setPositionInLesson(1);
        lessonStep.setLesson(null);
        lessonStep.setTest(null);
        lessonStep.setTheoreticalStep(null);
    }

    @Test
    @Disabled
    void toLessonStep() {
    }

    @Test
    void fromLessonStep() {
        //given
        LessonStepDto expectedLessonStepDto = new LessonStepDto();
        expectedLessonStepDto.setId(1L);
        expectedLessonStepDto.setComplete(false);
        expectedLessonStepDto.setPositionInLesson(1);
        expectedLessonStepDto.setLessonId(null);
        expectedLessonStepDto.setTheoreticalStepId(null);
        expectedLessonStepDto.setTestId(null);
        //when
        LessonStepDto actualLessonStepDto = underTestLessonStep.fromLessonStep(lessonStep);
        //then
        assertThat(actualLessonStepDto).isEqualTo(expectedLessonStepDto);
    }

    @Test
    void getAllLessonStepsDto() {
        //given
        LessonStep anotherLessonStep = new LessonStep();
        anotherLessonStep.setId(2L);
        anotherLessonStep.setComplete(false);
        anotherLessonStep.setPositionInLesson(2);
        anotherLessonStep.setLesson(null);
        anotherLessonStep.setTest(null);
        anotherLessonStep.setTheoreticalStep(null);

        LessonStepDto lessonStepDto = new LessonStepDto();
        lessonStepDto.setId(1L);
        lessonStepDto.setComplete(false);
        lessonStepDto.setPositionInLesson(1);
        lessonStepDto.setLessonId(null);
        lessonStepDto.setTheoreticalStepId(null);
        lessonStepDto.setTestId(null);

        LessonStepDto anotherLessonStepDto = new LessonStepDto();
        anotherLessonStepDto.setId(2L);
        anotherLessonStepDto.setComplete(false);
        anotherLessonStepDto.setPositionInLesson(2);
        anotherLessonStepDto.setLessonId(null);
        anotherLessonStepDto.setTheoreticalStepId(null);
        anotherLessonStepDto.setTestId(null);

        List<LessonStep> lessonStepList = new ArrayList<>();
        List<LessonStepDto> expectedLessonStepDtoList = new ArrayList<>();

        lessonStepList.add(lessonStep);
        lessonStepList.add(anotherLessonStep);
        expectedLessonStepDtoList.add(lessonStepDto);
        expectedLessonStepDtoList.add(anotherLessonStepDto);

        //when
        Mockito.when(lessonStepRepository.findAll()).thenReturn(lessonStepList);
        List<LessonStepDto> actualLessonStepDto = underTestLessonStep.getAllLessonStepsDto();
        //then
        assertThat(actualLessonStepDto).isEqualTo(expectedLessonStepDtoList);

    }

    @Test
    void getLessonStepDtoById() {
        //given
        LessonStepDto expectedLessonStepDto = new LessonStepDto();
        expectedLessonStepDto.setId(1L);
        expectedLessonStepDto.setComplete(false);
        expectedLessonStepDto.setPositionInLesson(1);
        expectedLessonStepDto.setLessonId(null);
        expectedLessonStepDto.setTheoreticalStepId(null);
        expectedLessonStepDto.setTestId(null);
        //when
        Mockito.when(lessonStepRepository.findById(1L)).thenReturn(java.util.Optional.ofNullable(lessonStep));
        LessonStepDto actualLessonStepDto = underTestLessonStep.getLessonStepDtoById(1L);
        //then
        assertThat(actualLessonStepDto).isEqualTo(expectedLessonStepDto);
    }

    @Test
    void getAllLessonSteps() {
        //given
        LessonStep anotherLessonStep = new LessonStep();
        anotherLessonStep.setId(2L);
        anotherLessonStep.setComplete(false);
        anotherLessonStep.setPositionInLesson(2);
        anotherLessonStep.setLesson(null);
        anotherLessonStep.setTest(null);
        anotherLessonStep.setTheoreticalStep(null);

        List<LessonStep> expectedStepList = new ArrayList<>();

        expectedStepList.add(lessonStep);
        expectedStepList.add(anotherLessonStep);
        //when
        Mockito.when(lessonStepRepository.findAll()).thenReturn(expectedStepList);
        List<LessonStep> actualLessonStepList = underTestLessonStep.getAllLessonSteps();
        //then
        assertThat(actualLessonStepList).isEqualTo(expectedStepList);
    }

    @Test
    void addNewLessonStep() {
        //given
        LessonStepDto expectedLessonStepDto = new LessonStepDto();
        expectedLessonStepDto.setId(1L);
        expectedLessonStepDto.setComplete(false);
        expectedLessonStepDto.setPositionInLesson(1);
        expectedLessonStepDto.setLessonId(null);
        expectedLessonStepDto.setTheoreticalStepId(null);
        expectedLessonStepDto.setTestId(null);
        //when
        Mockito.when(lessonStepRepository.save(lessonStep)).thenReturn(lessonStep);
        LessonStepDto actualLessonStepDto = underTestLessonStep.addNewLessonStep(lessonStep);
        //then
        assertThat(actualLessonStepDto).isEqualTo(expectedLessonStepDto);
    }

    @Test
    void updateLessonStep() {
        //given
        LessonStepDto expectedLessonStepDto = new LessonStepDto();
        expectedLessonStepDto.setId(1L);
        expectedLessonStepDto.setComplete(false);
        expectedLessonStepDto.setPositionInLesson(1);
        expectedLessonStepDto.setLessonId(null);
        expectedLessonStepDto.setTheoreticalStepId(null);
        expectedLessonStepDto.setTestId(null);
        //when
        Mockito.when(lessonStepRepository.save(lessonStep)).thenReturn(lessonStep);
        LessonStepDto actualLessonStepDto = underTestLessonStep.updateLessonStep(lessonStep);
        //then
        assertThat(actualLessonStepDto).isEqualTo(expectedLessonStepDto);
    }

    @Test
    void getLessonStepById() {
        //given
        LessonStep expectedLessonStep = lessonStep;
        //when
        Mockito.when(lessonStepRepository.findById(1L)).thenReturn(java.util.Optional.ofNullable(lessonStep));
        LessonStep actualLessonStep = underTestLessonStep.getLessonStepById(1L);
        //then
        assertThat(actualLessonStep).isEqualTo(expectedLessonStep);
    }

    @Test
    void deleteLessonStepById() {
        underTestLessonStep.deleteLessonStepById(1L);
        verify(lessonStepRepository).deleteById(1L);
    }
}