package com.ekimenko.spring.rest.SpringRESTtestingsystem.service.question_service.impl;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.dto.question_dto.QuestionDto;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.question.Question;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.repository.question_repos.QuestionRepository;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.service.answer_service.AnswerResultService;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.service.test_service.TestService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
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
class QuestionServiceImplTest {

    @Mock
    private QuestionRepository questionRepository;
    @Mock
    private TestService testService;
    @Mock
    private AnswerResultService answerResultService;
    @InjectMocks
    private QuestionServiceImpl underTestQuestion;

    private Question question;

    @BeforeEach
    void setUp() {
        question = new Question();
        question.setId(1L);
        question.setText("testText");
        question.setPosition(1);
        question.setAllowedParticleAnswer(false);
        question.setScore(1D);
        question.setAnswerResults(null);
        question.setTest(null);
        question.setAnswerVariants(null);
    }

    @Test
    @Disabled
    void toQuestion() {
    }

    @Test
    void fromQuestion() {
        //given
        QuestionDto expectedQuestionDto = new QuestionDto();
        expectedQuestionDto.setId(1L);
        expectedQuestionDto.setText("testText");
        expectedQuestionDto.setPosition(1);
        expectedQuestionDto.setAllowedParticleAnswer(false);
        expectedQuestionDto.setScore(1D);
        expectedQuestionDto.setAnswerResultsId(Collections.emptyList());
        expectedQuestionDto.setTestId(null);
        expectedQuestionDto.setAnswerVariantsId(Collections.emptyList());
        //when
        QuestionDto actualTestDto = underTestQuestion.fromQuestion(question);
        //then
        assertThat(actualTestDto).isEqualTo(expectedQuestionDto);
    }

    @Test
    void getAllQuestionsDto() {
        //given
        Question anotherQuestion = new Question();
        anotherQuestion.setId(1L);
        anotherQuestion.setText("testText");
        anotherQuestion.setPosition(1);
        anotherQuestion.setAllowedParticleAnswer(false);
        anotherQuestion.setScore(1D);
        anotherQuestion.setAnswerResults(null);
        anotherQuestion.setTest(null);
        anotherQuestion.setAnswerVariants(null);

        QuestionDto questionDto = new QuestionDto();
        questionDto.setId(1L);
        questionDto.setText("testText");
        questionDto.setPosition(1);
        questionDto.setAllowedParticleAnswer(false);
        questionDto.setScore(1D);
        questionDto.setAnswerResultsId(Collections.emptyList());
        questionDto.setTestId(null);
        questionDto.setAnswerVariantsId(Collections.emptyList());

        QuestionDto anotherQuestionDto = new QuestionDto();
        anotherQuestionDto.setId(1L);
        anotherQuestionDto.setText("testText");
        anotherQuestionDto.setPosition(1);
        anotherQuestionDto.setAllowedParticleAnswer(false);
        anotherQuestionDto.setScore(1D);
        anotherQuestionDto.setAnswerResultsId(Collections.emptyList());
        anotherQuestionDto.setTestId(null);
        anotherQuestionDto.setAnswerVariantsId(Collections.emptyList());

        List<Question> questionList = new ArrayList<>();
        questionList.add(question);
        questionList.add(anotherQuestion);
        List<QuestionDto> expectedQuestionDtoList = new ArrayList<>();
        expectedQuestionDtoList.add(questionDto);
        expectedQuestionDtoList.add(anotherQuestionDto);

        //when
        Mockito.when(questionRepository.findAll()).thenReturn(questionList);
        List<QuestionDto> actualQuestionDtoList = underTestQuestion.getAllQuestionsDto();
        //then
        assertThat(actualQuestionDtoList).isEqualTo(expectedQuestionDtoList);


    }

    @Test
    void getQuestionDtoById() {
        //given
        QuestionDto expectedQuestionDto = new QuestionDto();
        expectedQuestionDto.setId(1L);
        expectedQuestionDto.setText("testText");
        expectedQuestionDto.setPosition(1);
        expectedQuestionDto.setAllowedParticleAnswer(false);
        expectedQuestionDto.setScore(1D);
        expectedQuestionDto.setAnswerResultsId(Collections.emptyList());
        expectedQuestionDto.setTestId(null);
        expectedQuestionDto.setAnswerVariantsId(Collections.emptyList());
        //when
        Mockito.when(questionRepository.findById(1L)).thenReturn(java.util.Optional.ofNullable(question));
        QuestionDto actualQuestionDto = underTestQuestion.getQuestionDtoById(1L);
        //then
        assertThat(actualQuestionDto).isEqualTo(expectedQuestionDto);
    }

    @Test
    void getAllQuestions() {
        //given
        Question anotherQuestion = new Question();
        anotherQuestion.setId(1L);
        anotherQuestion.setText("testText");
        anotherQuestion.setPosition(1);
        anotherQuestion.setAllowedParticleAnswer(false);
        anotherQuestion.setScore(1D);
        anotherQuestion.setAnswerResults(null);
        anotherQuestion.setTest(null);
        anotherQuestion.setAnswerVariants(null);

        List<Question> expectedQuestionList = new ArrayList<>();
        expectedQuestionList.add(question);
        expectedQuestionList.add(anotherQuestion);


        //when
        Mockito.when(questionRepository.findAll()).thenReturn(expectedQuestionList);
        List<Question> actualQuestionList = underTestQuestion.getAllQuestions();
        //then
        assertThat(actualQuestionList).isEqualTo(expectedQuestionList);
    }

    @Test
    void addNewQuestion() {
        //given
        QuestionDto expectedQuestionDto = new QuestionDto();
        expectedQuestionDto.setId(1L);
        expectedQuestionDto.setText("testText");
        expectedQuestionDto.setPosition(1);
        expectedQuestionDto.setAllowedParticleAnswer(false);
        expectedQuestionDto.setScore(1D);
        expectedQuestionDto.setAnswerResultsId(Collections.emptyList());
        expectedQuestionDto.setTestId(null);
        expectedQuestionDto.setAnswerVariantsId(Collections.emptyList());
        //when
        Mockito.when(questionRepository.save(question)).thenReturn(question);
        QuestionDto actualQuestionDto = underTestQuestion.addNewQuestion(question);
        //then
        assertThat(actualQuestionDto).isEqualTo(expectedQuestionDto);
    }

    @Test
    void updateQuestion() {
        //given
        QuestionDto expectedQuestionDto = new QuestionDto();
        expectedQuestionDto.setId(1L);
        expectedQuestionDto.setText("testText");
        expectedQuestionDto.setPosition(1);
        expectedQuestionDto.setAllowedParticleAnswer(false);
        expectedQuestionDto.setScore(1D);
        expectedQuestionDto.setAnswerResultsId(Collections.emptyList());
        expectedQuestionDto.setTestId(null);
        expectedQuestionDto.setAnswerVariantsId(Collections.emptyList());
        //when
        Mockito.when(questionRepository.save(question)).thenReturn(question);
        QuestionDto actualQuestionDto = underTestQuestion.updateQuestion(question);
        //then
        assertThat(actualQuestionDto).isEqualTo(expectedQuestionDto);
    }

    @Test
    void getQuestionById() {
        //given
        Question expectedQuestion = question;
        //when
        Mockito.when(questionRepository.findById(1L)).thenReturn(java.util.Optional.ofNullable(question));
        Question actualQuestion = underTestQuestion.getQuestionById(1L);
        //then
        assertThat(actualQuestion).isEqualTo(expectedQuestion);
    }

    @Test
    void deleteQuestionById() {
        underTestQuestion.deleteQuestionById(1L);
        verify(questionRepository).deleteById(1L);
    }
}