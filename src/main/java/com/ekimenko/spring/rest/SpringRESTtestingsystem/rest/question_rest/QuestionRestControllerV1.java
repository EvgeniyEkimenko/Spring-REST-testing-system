package com.ekimenko.spring.rest.SpringRESTtestingsystem.rest.question_rest;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.dto.question_dto.QuestionDto;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.service.question_service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

        QuestionDto questionDto = questionService.getQuestionDtoById(id);

        return new ResponseEntity<>(questionDto, HttpStatus.OK);
    }

    @GetMapping(value = "")
    public ResponseEntity<List<QuestionDto>> getAllQuestions() {

        List<QuestionDto> questionsDto = questionService.getAllQuestionsDto();

        return new ResponseEntity<>(questionsDto, HttpStatus.OK);
    }

    @PostMapping(value = "")
    public void addNewQuestion(@RequestBody QuestionDto questionDto) {

/*        Question question = questionDto.toQuestion();
        questionService.addNewQuestion(question);*/
    }

    @PutMapping(value = "")
    public void updateQuestion(@RequestBody QuestionDto questionDto) {

/*        Question question = questionDto.toQuestion();
        questionService.updateQuestion(question);*/
    }

    @DeleteMapping(value = "/{id}")
    public void deleteQuestionByID(@PathVariable long id) {

        questionService.deleteQuestionById(id);
    }


}