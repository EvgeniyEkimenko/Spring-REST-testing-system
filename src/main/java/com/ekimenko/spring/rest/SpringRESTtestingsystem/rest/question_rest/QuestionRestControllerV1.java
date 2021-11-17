package com.ekimenko.spring.rest.SpringRESTtestingsystem.rest.question_rest;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.dto.answer_dto.AnswerResultDto;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.dto.question_dto.QuestionDto;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.answer.AnswerResult;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.answer.AnswerVariant;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.question.Question;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.service.question_service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/question")
public class QuestionRestControllerV1 {

    private final QuestionService questionService;

    @Autowired
    public QuestionRestControllerV1(QuestionService questionService) {
        this.questionService = questionService;
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<QuestionDto> getQuestionById(@PathVariable long id) {
        Question question = questionService.getQuestionById(id);

        QuestionDto questionDto = QuestionDto.fromQuestion(question);
        System.out.println(question.getTest().getId());

        return new ResponseEntity<>(questionDto, HttpStatus.OK);
    }

    @GetMapping(value = "")
    public ResponseEntity<List<QuestionDto>> getAllQuestions() {
        List<Question> questionList = questionService.getAllQuestions();

        List<QuestionDto> questionsDto = new ArrayList<>();
        for (Question question : questionList) {
            questionsDto.add(QuestionDto.fromQuestion(question));
        }

        return new ResponseEntity<>(questionsDto, HttpStatus.OK);
    }

    @PostMapping(value = "")
    public void addNewQuestion(@RequestBody QuestionDto answerVariantDto) {

        //TODO solve the problem of implementing the save and update methods
    }

    @PutMapping(value = "")
    public void updateQuestion(@RequestBody QuestionDto answerVariantDto) {

        //TODO solve the problem of implementing the save and update methods

    }

    @DeleteMapping(value = "/{id}")
    public void deleteQuestionByID(@PathVariable long id) {

        questionService.deleteQuestionById(id);

    }


}