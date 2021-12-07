package com.ekimenko.spring.rest.SpringRESTtestingsystem.service.answer_service.impl;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.dto.answer_dto.AnswerResultDto;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.answer.AnswerResult;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.answer.AnswerVariant;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.question.Question;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.test.TestResult;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.repository.answer_repos.AnswerResultRepository;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.service.answer_service.AnswerVariantService;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.service.question_service.QuestionService;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.service.test_service.TestResultService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class AnswerResultServiceImplTest {

    @Mock
    private AnswerResultRepository resultRepository;
    @Mock
    private QuestionService questionService;
    @Mock
    private AnswerVariantService answerVariantService;
    @Mock
    private TestResultService testResultService;
    @InjectMocks
    private AnswerResultServiceImpl underTestAnswerResult;

    private AnswerResult answerResult;

    @BeforeEach
    void setUp() {
        answerResult = new AnswerResult();
        answerResult.setId(1L);
        answerResult.setScore(1D);
        answerResult.setTestResult(null);
        answerResult.setQuestion(null);
        answerResult.setAnswerVariants(null);
    }

    @Test
    @DisplayName("The method should set points for the completed test depending on the results")
    void setPoints() {
        //given
        List<Long> answerVariantIdList = new ArrayList<>();
        answerVariantIdList.add(1L);
        answerVariantIdList.add(2L);

        AnswerResultDto answerResultDto = new AnswerResultDto();
        answerResultDto.setId(1L);
        answerResultDto.setScore(0D);
        answerResultDto.setQuestionId(1L);
        answerResultDto.setAnswerVariantsId(answerVariantIdList);
        answerResultDto.setTestResultId(1L);

        TestResult testResult = new TestResult();
        testResult.setId(1L);
        testResult.setComplete(false);
        testResult.setTest(null);
        testResult.setAnswerResults(Collections.emptyList());
        testResult.setUser(null);
        testResult.setScore(10D);
        testResult.setTestScore(false);

        List<AnswerVariant> answerVariantList = new ArrayList<>();

        AnswerVariant firstAnswerVariantWithTrue = new AnswerVariant();
        firstAnswerVariantWithTrue = new AnswerVariant();
        firstAnswerVariantWithTrue.setId(1L);
        firstAnswerVariantWithTrue.setCorrect(true);
        firstAnswerVariantWithTrue.setText("testText");
        firstAnswerVariantWithTrue.setQuestion(null);
        firstAnswerVariantWithTrue.setAnswerResult(null);

        AnswerVariant secondAnswerVariantWithTrue = new AnswerVariant();
        secondAnswerVariantWithTrue = new AnswerVariant();
        secondAnswerVariantWithTrue.setId(2L);
        secondAnswerVariantWithTrue.setCorrect(true);
        secondAnswerVariantWithTrue.setText("testText");
        secondAnswerVariantWithTrue.setQuestion(null);
        secondAnswerVariantWithTrue.setAnswerResult(null);

        AnswerVariant thirdAnswerVariantWithTrue = new AnswerVariant();
        thirdAnswerVariantWithTrue = new AnswerVariant();
        thirdAnswerVariantWithTrue.setId(3L);
        thirdAnswerVariantWithTrue.setCorrect(false);
        thirdAnswerVariantWithTrue.setText("testText");
        thirdAnswerVariantWithTrue.setQuestion(null);
        thirdAnswerVariantWithTrue.setAnswerResult(null);

        AnswerVariant fourthAnswerVariantWithTrue = new AnswerVariant();
        fourthAnswerVariantWithTrue = new AnswerVariant();
        fourthAnswerVariantWithTrue.setId(4L);
        fourthAnswerVariantWithTrue.setCorrect(false);
        fourthAnswerVariantWithTrue.setText("testText");
        fourthAnswerVariantWithTrue.setQuestion(null);
        fourthAnswerVariantWithTrue.setAnswerResult(null);

        answerVariantList.add(firstAnswerVariantWithTrue);
        answerVariantList.add(secondAnswerVariantWithTrue);
        answerVariantList.add(thirdAnswerVariantWithTrue);
        answerVariantList.add(fourthAnswerVariantWithTrue);

        Question question = new Question();
        question.setId(1L);
        question.setText("testText");
        question.setPosition(1);
        question.setAllowedParticleAnswer(true);
        question.setScore(10D);
        question.setAnswerResults(null);
        question.setTest(null);
        question.setAnswerVariants(answerVariantList);

        AnswerResultDto expectedAnswerResultDto = new AnswerResultDto();
        expectedAnswerResultDto.setId(1L);
        expectedAnswerResultDto.setScore(10D);
        expectedAnswerResultDto.setQuestionId(1L);
        expectedAnswerResultDto.setAnswerVariantsId(answerVariantIdList);
        expectedAnswerResultDto.setTestResultId(1L);

        List<AnswerVariant> answerVariantListForSave = new ArrayList<>();
        answerVariantListForSave.add(firstAnswerVariantWithTrue);
        answerVariantListForSave.add(secondAnswerVariantWithTrue);

        AnswerResult answerResult = new AnswerResult();
        answerResult.setId(1L);
        answerResult.setTestResult(testResult);
        answerResult.setScore(10D);
        answerResult.setAnswerVariants(answerVariantListForSave);
        answerResult.setQuestion(question);

        //when
        Mockito.when(questionService.getQuestionById(1L)).thenReturn(question);
        Mockito.when(answerVariantService.getAnswerVariantById(1L)).thenReturn(firstAnswerVariantWithTrue);
        Mockito.when(answerVariantService.getAnswerVariantById(2L)).thenReturn(secondAnswerVariantWithTrue);
        Mockito.when(testResultService.getTestResultById(1L)).thenReturn(testResult);
        Mockito.when(testResultService.getTestResultById(1L)).thenReturn(testResult);
        Mockito.when(resultRepository.save(answerResult)).thenReturn(answerResult);

        AnswerResultDto actualAnswerResultDto = underTestAnswerResult.setPoints(answerResultDto);
        //then
        assertThat(actualAnswerResultDto).isEqualTo(expectedAnswerResultDto);
    }

    @Test
    @DisplayName("The method should return the number of points for a partial answer")
    @Disabled
    void calculatePointsWithAllowedParticleAnswer() {
        //given

        //when
        //then
    }

    @Test
    @DisplayName("The method should return the number of points without a partial answer")
    @Disabled
    void calculatePointsWithoutAllowedParticleAnswer() {
        //given
        //when
        //then
    }

    @Test
    @Disabled
    void toAnswerResult() {
    }

    @Test
    @Disabled
    void getAnswerVariantListForResult() {

    }

    @Test
    void fromAnswerResult() {
        //given
        AnswerResultDto expectedAnswerResultDto = new AnswerResultDto();
        expectedAnswerResultDto.setId(1L);
        expectedAnswerResultDto.setScore(1D);
        expectedAnswerResultDto.setTestResultId(null);
        expectedAnswerResultDto.setQuestionId(null);
        expectedAnswerResultDto.setAnswerVariantsId(Collections.emptyList());
        //when
        AnswerResultDto actualAnswerResultDto = underTestAnswerResult.fromAnswerResult(answerResult);
        //then
        assertThat(actualAnswerResultDto).isEqualTo(expectedAnswerResultDto);
    }

    @Test
    void getAllAnswerResultDto() {
        //given
        AnswerResult anotherAnswerResult = new AnswerResult();
        anotherAnswerResult.setId(1L);
        anotherAnswerResult.setScore(1D);
        anotherAnswerResult.setTestResult(null);
        anotherAnswerResult.setQuestion(null);
        anotherAnswerResult.setAnswerVariants(null);

        AnswerResultDto answerResultDto = new AnswerResultDto();
        answerResultDto.setId(1L);
        answerResultDto.setScore(1D);
        answerResultDto.setTestResultId(null);
        answerResultDto.setQuestionId(null);
        answerResultDto.setAnswerVariantsId(Collections.emptyList());

        AnswerResultDto anotherAnswerResultDto = new AnswerResultDto();
        anotherAnswerResultDto.setId(1L);
        anotherAnswerResultDto.setScore(1D);
        anotherAnswerResultDto.setTestResultId(null);
        anotherAnswerResultDto.setQuestionId(null);
        anotherAnswerResultDto.setAnswerVariantsId(Collections.emptyList());

        List<AnswerResult> answerResultList = new ArrayList<>();
        List<AnswerResultDto> expectedAnswerResultDtoList = new ArrayList<>();
        answerResultList.add(answerResult);
        answerResultList.add(anotherAnswerResult);
        expectedAnswerResultDtoList.add(answerResultDto);
        expectedAnswerResultDtoList.add(anotherAnswerResultDto);
        //when
        Mockito.when(resultRepository.findAll()).thenReturn(answerResultList);
        List<AnswerResultDto> actualAnswerResultDtoList = underTestAnswerResult.getAllAnswerResultDto();
        //then
        assertThat(actualAnswerResultDtoList).isEqualTo(expectedAnswerResultDtoList);
    }

    @Test
    void getAnswerResultDtoById() {
        //given
        AnswerResultDto expectedAnswerResultDto = new AnswerResultDto();
        expectedAnswerResultDto.setId(1L);
        expectedAnswerResultDto.setScore(1D);
        expectedAnswerResultDto.setTestResultId(null);
        expectedAnswerResultDto.setQuestionId(null);
        expectedAnswerResultDto.setAnswerVariantsId(Collections.emptyList());
        //when
        Mockito.when(resultRepository.findById(1L)).thenReturn(java.util.Optional.ofNullable(answerResult));
        AnswerResultDto actualAnswerResultDto = underTestAnswerResult.getAnswerResultDtoById(1L);
        //then
        assertThat(actualAnswerResultDto).isEqualTo(expectedAnswerResultDto);
    }

    @Test
    void getAllAnswerResult() {
        //given
        AnswerResult anotherAnswerResult = new AnswerResult();
        anotherAnswerResult.setId(1L);
        anotherAnswerResult.setScore(1D);
        anotherAnswerResult.setTestResult(null);
        anotherAnswerResult.setQuestion(null);
        anotherAnswerResult.setAnswerVariants(null);

        List<AnswerResult> expectedAnswerResultList = new ArrayList<>();
        expectedAnswerResultList.add(answerResult);
        expectedAnswerResultList.add(anotherAnswerResult);

        //when
        Mockito.when(resultRepository.findAll()).thenReturn(expectedAnswerResultList);
        List<AnswerResult> actualAnswerResultList = underTestAnswerResult.getAllAnswerResult();
        //then
        assertThat(actualAnswerResultList).isEqualTo(expectedAnswerResultList);
    }

    @Test
    void getAnswerResultById() {
        //given
        AnswerResult expectedAnswerResult = answerResult;
        //when
        Mockito.when(resultRepository.findById(1L)).thenReturn(java.util.Optional.ofNullable(answerResult));
        AnswerResult actualAnswerResult = underTestAnswerResult.getAnswerResultById(1L);
        //then
        assertThat(actualAnswerResult).isEqualTo(expectedAnswerResult);
    }

    @Test
    void addNewAnswerResult() {
        //given
        AnswerResultDto expectedAnswerResultDto = new AnswerResultDto();
        expectedAnswerResultDto.setId(1L);
        expectedAnswerResultDto.setScore(1D);
        expectedAnswerResultDto.setTestResultId(null);
        expectedAnswerResultDto.setQuestionId(null);
        expectedAnswerResultDto.setAnswerVariantsId(Collections.emptyList());
        //when
        Mockito.when(resultRepository.save(answerResult)).thenReturn(answerResult);
        AnswerResultDto actualAnswerResultDto = underTestAnswerResult.addNewAnswerResult(answerResult);
        //then
        assertThat(actualAnswerResultDto).isEqualTo(expectedAnswerResultDto);
    }

    @Test
    void updateAnswerResult() {
        //given
        AnswerResultDto expectedAnswerResultDto = new AnswerResultDto();
        expectedAnswerResultDto.setId(1L);
        expectedAnswerResultDto.setScore(1D);
        expectedAnswerResultDto.setTestResultId(null);
        expectedAnswerResultDto.setQuestionId(null);
        expectedAnswerResultDto.setAnswerVariantsId(Collections.emptyList());
        //when
        Mockito.when(resultRepository.save(answerResult)).thenReturn(answerResult);
        AnswerResultDto actualAnswerResultDto = underTestAnswerResult.updateAnswerResult(answerResult);
        //then
        assertThat(actualAnswerResultDto).isEqualTo(expectedAnswerResultDto);
    }

    @Test
    void deleteById() {
        underTestAnswerResult.deleteById(1L);
        verify(resultRepository).deleteById(1L);
    }
}