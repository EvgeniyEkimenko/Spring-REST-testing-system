package com.ekimenko.spring.rest.SpringRESTtestingsystem.service.theoretical_step_service.impl;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.dto.TheoreticalStepDto;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.TheoreticalStep;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.repository.TheoreticalStepRepository;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.service.lesson_service.LessonStepService;
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
class TheoreticalStepServiceImplTest {

    @Mock
    private TheoreticalStepRepository theoreticalStepRepository;
    @Mock
    private LessonStepService lessonStepService;
    @InjectMocks
    private TheoreticalStepServiceImpl underTestTheoreticalStep;

    private TheoreticalStep theoreticalStep;

    @BeforeEach
    void setUp() {
        theoreticalStep = new TheoreticalStep();
        theoreticalStep.setId(1L);
        theoreticalStep.setDescription("testDesc");
        theoreticalStep.setUsefulText("testText");
        theoreticalStep.setName("testName");
        theoreticalStep.setLessonStep(null);
    }

    @Test
    @Disabled
    void toTheoreticalStep() {
    }

    @Test
    void fromTheoreticalStep() {
        //given
        TheoreticalStepDto expectedTheoreticalStepDto = new TheoreticalStepDto();
        expectedTheoreticalStepDto.setId(1L);
        expectedTheoreticalStepDto.setDescription("testDesc");
        expectedTheoreticalStepDto.setUsefulText("testText");
        expectedTheoreticalStepDto.setName("testName");
        expectedTheoreticalStepDto.setLessonStepId(null);
        //when
        TheoreticalStepDto actualLessonStepDto = underTestTheoreticalStep.fromTheoreticalStep(theoreticalStep);
        //then
        assertThat(actualLessonStepDto).isEqualTo(expectedTheoreticalStepDto);
    }

    @Test
    void getAllTheoreticalStepsDto() {
        //given
        TheoreticalStep anotherTheoreticalStep = new TheoreticalStep();
        anotherTheoreticalStep.setId(2L);
        anotherTheoreticalStep.setDescription("testDesc");
        anotherTheoreticalStep.setUsefulText("testText");
        anotherTheoreticalStep.setName("testName");
        anotherTheoreticalStep.setLessonStep(null);

        TheoreticalStepDto theoreticalStepDto = new TheoreticalStepDto();
        theoreticalStepDto.setId(1L);
        theoreticalStepDto.setDescription("testDesc");
        theoreticalStepDto.setUsefulText("testText");
        theoreticalStepDto.setName("testName");
        theoreticalStepDto.setLessonStepId(null);

        TheoreticalStepDto anotherTheoreticalStepDto = new TheoreticalStepDto();
        anotherTheoreticalStepDto.setId(2L);
        anotherTheoreticalStepDto.setDescription("testDesc");
        anotherTheoreticalStepDto.setUsefulText("testText");
        anotherTheoreticalStepDto.setName("testName");
        anotherTheoreticalStepDto.setLessonStepId(null);

        List<TheoreticalStep> theoreticalStepList = new ArrayList<>();
        List<TheoreticalStepDto> expectedTheoreticalStepList = new ArrayList<>();

        theoreticalStepList.add(theoreticalStep);
        theoreticalStepList.add(anotherTheoreticalStep);
        expectedTheoreticalStepList.add(theoreticalStepDto);
        expectedTheoreticalStepList.add(anotherTheoreticalStepDto);
        //when
        Mockito.when(theoreticalStepRepository.findAll()).thenReturn(theoreticalStepList);
        List<TheoreticalStepDto> actualTheoreticalStepDto = underTestTheoreticalStep.getAllTheoreticalStepsDto();

        //then
        assertThat(actualTheoreticalStepDto).isEqualTo(expectedTheoreticalStepList);
    }

    @Test
    void getTheoreticalStepDtoById() {
        //given
        TheoreticalStepDto expectedTheoreticalStepDto = new TheoreticalStepDto();
        expectedTheoreticalStepDto.setId(1L);
        expectedTheoreticalStepDto.setDescription("testDesc");
        expectedTheoreticalStepDto.setUsefulText("testText");
        expectedTheoreticalStepDto.setName("testName");
        expectedTheoreticalStepDto.setLessonStepId(null);
        //when
        Mockito.when(theoreticalStepRepository.findById(1L)).thenReturn(java.util.Optional.ofNullable(theoreticalStep));
        TheoreticalStepDto actualLessonStepDto = underTestTheoreticalStep.getTheoreticalStepDtoById(1L);

        //then
        assertThat(actualLessonStepDto).isEqualTo(expectedTheoreticalStepDto);
    }

    @Test
    void getAllTheoreticalSteps() {
        //given
        TheoreticalStep anotherTheoreticalStep = new TheoreticalStep();
        anotherTheoreticalStep.setId(2L);
        anotherTheoreticalStep.setDescription("testDesc");
        anotherTheoreticalStep.setUsefulText("testText");
        anotherTheoreticalStep.setName("testName");
        anotherTheoreticalStep.setLessonStep(null);

        List<TheoreticalStep> expectTheoreticalStepList = new ArrayList<>();

        expectTheoreticalStepList.add(theoreticalStep);
        expectTheoreticalStepList.add(anotherTheoreticalStep);
        //when
        Mockito.when(theoreticalStepRepository.findAll()).thenReturn(expectTheoreticalStepList);
        List<TheoreticalStep> actualTheoreticalStep = underTestTheoreticalStep.getAllTheoreticalSteps();

        //then
        assertThat(actualTheoreticalStep).isEqualTo(expectTheoreticalStepList);
    }

    @Test
    void addNewTheoreticalStep() {
        //given
        TheoreticalStepDto expectedTheoreticalStepDto = new TheoreticalStepDto();
        expectedTheoreticalStepDto.setId(1L);
        expectedTheoreticalStepDto.setDescription("testDesc");
        expectedTheoreticalStepDto.setUsefulText("testText");
        expectedTheoreticalStepDto.setName("testName");
        expectedTheoreticalStepDto.setLessonStepId(null);
        //when
        Mockito.when(theoreticalStepRepository.save(theoreticalStep)).thenReturn(theoreticalStep);
        TheoreticalStepDto actualTheoreticalStepDto = underTestTheoreticalStep.addNewTheoreticalStep(theoreticalStep);
        //then
        assertThat(actualTheoreticalStepDto).isEqualTo(expectedTheoreticalStepDto);
    }

    @Test
    void updateTheoreticalStep() {
        //given
        TheoreticalStepDto expectedTheoreticalStepDto = new TheoreticalStepDto();
        expectedTheoreticalStepDto.setId(1L);
        expectedTheoreticalStepDto.setDescription("testDesc");
        expectedTheoreticalStepDto.setUsefulText("testText");
        expectedTheoreticalStepDto.setName("testName");
        expectedTheoreticalStepDto.setLessonStepId(null);
        //when
        Mockito.when(theoreticalStepRepository.save(theoreticalStep)).thenReturn(theoreticalStep);
        TheoreticalStepDto actualTheoreticalStepDto = underTestTheoreticalStep.updateTheoreticalStep(theoreticalStep);
        //then
        assertThat(actualTheoreticalStepDto).isEqualTo(expectedTheoreticalStepDto);
    }

    @Test
    void getTheoreticalStepById() {
        //given
        TheoreticalStep expectedTheoreticalStep = theoreticalStep;
        //when
        Mockito.when(theoreticalStepRepository.findById(1L)).thenReturn(java.util.Optional.ofNullable(theoreticalStep));
        TheoreticalStep actualTheoreticalStep = underTestTheoreticalStep.getTheoreticalStepById(1L);

        //then
        assertThat(actualTheoreticalStep).isEqualTo(expectedTheoreticalStep);
    }

    @Test
    void deleteTheoreticalStepById() {
        underTestTheoreticalStep.deleteTheoreticalStepById(1L);
        verify(theoreticalStepRepository).deleteById(1L);
    }
}