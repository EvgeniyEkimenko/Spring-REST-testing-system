package com.ekimenko.spring.rest.SpringRESTtestingsystem.service.answer_service.impl;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.dto.answer_dto.AnswerVariantDto;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.answer.AnswerVariant;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.repository.answer_repos.AnswerVariantRepository;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.service.answer_service.AnswerResultService;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.service.answer_service.AnswerVariantService;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.service.question_service.QuestionService;
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
class AnswerVariantImplTest {

    @Mock
    private AnswerVariantRepository answerVariantRepository;
    @Mock
    private QuestionService questionService;
    @Mock
    private AnswerVariantService answerVariantService;
    @Mock
    private AnswerResultService answerResultService;
    @InjectMocks
    AnswerVariantImpl underTestAnswerVariant;

    private AnswerVariant answerVariant;

    @BeforeEach
    void setUp() {
        answerVariant = new AnswerVariant();
        answerVariant.setId(1L);
        answerVariant.setCorrect(false);
        answerVariant.setText("testText");
        answerVariant.setQuestion(null);
        answerVariant.setAnswerResult(null);
    }

    @Test
    @Disabled
    void toAnswerVariant() {
    }

    @Test
    void fromAnswerVariant() {
        //given
        AnswerVariantDto expectedAnswerVariantDto = new AnswerVariantDto();
        expectedAnswerVariantDto.setId(1L);
        expectedAnswerVariantDto.setCorrect(false);
        expectedAnswerVariantDto.setText("testText");
        expectedAnswerVariantDto.setAnswerResultId(null);
        expectedAnswerVariantDto.setQuestionId(null);
        //when
        AnswerVariantDto actualAnswerVariantDto = underTestAnswerVariant.fromAnswerVariant(answerVariant);
        //then
        assertThat(actualAnswerVariantDto).isEqualTo(expectedAnswerVariantDto);
    }

    @Test
    void getAllAnswerVariantsDto() {
        //given
        AnswerVariant anotherAnswerVariant = new AnswerVariant();
        anotherAnswerVariant.setId(2L);
        anotherAnswerVariant.setCorrect(false);
        anotherAnswerVariant.setText("testText");
        anotherAnswerVariant.setQuestion(null);
        anotherAnswerVariant.setAnswerResult(null);

        AnswerVariantDto answerVariantDto = new AnswerVariantDto();
        answerVariantDto.setId(1L);
        answerVariantDto.setCorrect(false);
        answerVariantDto.setText("testText");
        answerVariantDto.setAnswerResultId(null);
        answerVariantDto.setQuestionId(null);

        AnswerVariantDto anotherAnswerVariantDto = new AnswerVariantDto();
        anotherAnswerVariantDto.setId(2L);
        anotherAnswerVariantDto.setCorrect(false);
        anotherAnswerVariantDto.setText("testText");
        anotherAnswerVariantDto.setAnswerResultId(null);
        anotherAnswerVariantDto.setQuestionId(null);

        List<AnswerVariant> answerVariantList = new ArrayList<>();
        List<AnswerVariantDto> expectedAnswerVariantDtoList = new ArrayList<>();
        answerVariantList.add(answerVariant);
        answerVariantList.add(anotherAnswerVariant);
        expectedAnswerVariantDtoList.add(answerVariantDto);
        expectedAnswerVariantDtoList.add(anotherAnswerVariantDto);
        //when
        Mockito.when(answerVariantRepository.findAll()).thenReturn(answerVariantList);
        List<AnswerVariantDto> actualAnswerVariantDtoList = underTestAnswerVariant.getAllAnswerVariantsDto();
        //then
        assertThat(actualAnswerVariantDtoList).isEqualTo(expectedAnswerVariantDtoList);
    }

    @Test
    void getAnswerVariantDtoById() {
        //given
        AnswerVariantDto expectedAnswerVariantDto = new AnswerVariantDto();
        expectedAnswerVariantDto.setId(1L);
        expectedAnswerVariantDto.setCorrect(false);
        expectedAnswerVariantDto.setText("testText");
        expectedAnswerVariantDto.setAnswerResultId(null);
        expectedAnswerVariantDto.setQuestionId(null);
        //when
        Mockito.when(answerVariantRepository.findById(1L)).thenReturn(java.util.Optional.ofNullable(answerVariant));
        AnswerVariantDto actualAnswerVariantDto = underTestAnswerVariant.getAnswerVariantDtoById(1L);
        //then
        assertThat(actualAnswerVariantDto).isEqualTo(expectedAnswerVariantDto);

    }

    @Test
    void getAllAnswerVariants() {
        //given
        AnswerVariant anotherAnswerVariant = new AnswerVariant();
        anotherAnswerVariant.setId(2L);
        anotherAnswerVariant.setCorrect(false);
        anotherAnswerVariant.setText("testText");
        anotherAnswerVariant.setQuestion(null);
        anotherAnswerVariant.setAnswerResult(null);

        List<AnswerVariant> expectedAnswerVariantList = new ArrayList<>();
        expectedAnswerVariantList.add(answerVariant);
        expectedAnswerVariantList.add(anotherAnswerVariant);
        //when
        Mockito.when(answerVariantRepository.findAll()).thenReturn(expectedAnswerVariantList);
        List<AnswerVariant> actualAnswerVariantList = underTestAnswerVariant.getAllAnswerVariants();
        //then
        assertThat(actualAnswerVariantList).isEqualTo(expectedAnswerVariantList);
    }

    @Test
    void getAnswerVariantById() {
        //given
        AnswerVariant expectedAnswerVariant = answerVariant;

        //when
        Mockito.when(answerVariantRepository.findById(1L)).thenReturn(java.util.Optional.ofNullable(answerVariant));
        AnswerVariant actualAnswerVariant = underTestAnswerVariant.getAnswerVariantById(1L);
        //then
        assertThat(actualAnswerVariant).isEqualTo(expectedAnswerVariant);

    }

    @Test
    void addNewAnswerVariant() {
        //given
        AnswerVariantDto expectedAnswerVariantDto = new AnswerVariantDto();
        expectedAnswerVariantDto.setId(1L);
        expectedAnswerVariantDto.setCorrect(false);
        expectedAnswerVariantDto.setText("testText");
        expectedAnswerVariantDto.setAnswerResultId(null);
        expectedAnswerVariantDto.setQuestionId(null);
        //when
        Mockito.when(answerVariantRepository.save(answerVariant)).thenReturn(answerVariant);
        AnswerVariantDto actualAnswerVariantDto = underTestAnswerVariant.addNewAnswerVariant(answerVariant);
        //then
        assertThat(actualAnswerVariantDto).isEqualTo(expectedAnswerVariantDto);
    }

    @Test
    void updateAnswerVariant() {
        //given
        AnswerVariantDto expectedAnswerVariantDto = new AnswerVariantDto();
        expectedAnswerVariantDto.setId(1L);
        expectedAnswerVariantDto.setCorrect(false);
        expectedAnswerVariantDto.setText("testText");
        expectedAnswerVariantDto.setAnswerResultId(null);
        expectedAnswerVariantDto.setQuestionId(null);
        //when
        Mockito.when(answerVariantRepository.save(answerVariant)).thenReturn(answerVariant);
        AnswerVariantDto actualAnswerVariantDto = underTestAnswerVariant.updateAnswerVariant(answerVariant);
        //then
        assertThat(actualAnswerVariantDto).isEqualTo(expectedAnswerVariantDto);
    }

    @Test
    void deleteAnswerVariantById() {
        underTestAnswerVariant.deleteAnswerVariantById(1L);
        verify(answerVariantRepository).deleteById(1L);
    }
}