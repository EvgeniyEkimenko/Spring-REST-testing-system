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



    //FIXME The endpoint location may be incorrect
    @PostMapping(value = "/calc")
    public ResponseEntity<List<AnswerResultDto>> answerTheQuestion() {
        Question question = new Question();
        question.setId(1L);
        AnswerVariant answerVariant1 = new AnswerVariant();
        AnswerVariant answerVariant2 = new AnswerVariant();
        AnswerVariant answerVariant3 = new AnswerVariant();
        AnswerVariant answerVariant4 = new AnswerVariant();
        answerVariant1.setId(1L);
        answerVariant2.setId(2L);
        answerVariant3.setId(3L);
        answerVariant4.setId(4L);
        answerVariant1.setCorrect(true);
        answerVariant2.setCorrect(false);
        answerVariant3.setCorrect(true);
        answerVariant4.setCorrect(false);
        List<AnswerVariant> answerVariantList = new ArrayList<>();
        answerVariantList.add(answerVariant3);
        answerVariantList.add(answerVariant4);
        question.setAnswerVariants(answerVariantList);
        question.setScore(15D);
        List<AnswerResult> answerResultList = questionService.CalculateTheNumberOfPointsForTheAnswer(question);

        List<AnswerResultDto> answerResultsDto = new ArrayList<>();

        for (AnswerResult answerResult : answerResultList) {
            answerResultsDto.add(AnswerResultDto.fromAnswerResult(answerResult));
        }

        return new ResponseEntity<>(answerResultsDto, HttpStatus.OK);



    }

}