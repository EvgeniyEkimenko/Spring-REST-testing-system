package com.ekimenko.spring.rest.SpringRESTtestingsystem.rest.answer_rest;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.dto.answer_dto.AnswerResultDto;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.service.answer_service.AnswerResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/answer-result")
public class AnswerResultRestControllerV1 {

    private final AnswerResultService resultService;

    @Autowired
    public AnswerResultRestControllerV1(AnswerResultService resultService) {
        this.resultService = resultService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<AnswerResultDto> getAnswerResultById(@PathVariable long id) {

        AnswerResultDto answerResultDto = resultService.getAnswerResultDtoById(id);

        return new ResponseEntity<>(answerResultDto, HttpStatus.OK);
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<AnswerResultDto>> getAllAnswerResult() {

        List<AnswerResultDto> answerResultDtoList = resultService.getAllAnswerResultDto();

        return new ResponseEntity<>(answerResultDtoList, HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<AnswerResultDto> addNewAnswerResult(@RequestBody AnswerResultDto answerResultDto) {

        AnswerResultDto answerResultDtoNew = resultService
                .addNewAnswerResult(resultService
                        .toAnswerResult(answerResultDto));

        return new ResponseEntity<>(answerResultDtoNew, HttpStatus.OK);
    }

    @PutMapping(value = "")
    public ResponseEntity<AnswerResultDto> updateAnswerResult(@RequestBody AnswerResultDto answerResultDto) {

        AnswerResultDto answerResultDtoNew = resultService
                .updateAnswerResult(resultService
                        .toAnswerResult(answerResultDto));

        return new ResponseEntity<>(answerResultDtoNew, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteAnswerResultByID(@PathVariable long id) {

        resultService.deleteById(id);
    }

    @PostMapping(value = "/check_answer")
    public AnswerResultDto setPointsForTheAnswer(@RequestBody AnswerResultDto answerResultDto) {

        AnswerResultDto answerResultDtoNew = resultService.setPoints(answerResultDto);
        return answerResultDtoNew;
    }

}
