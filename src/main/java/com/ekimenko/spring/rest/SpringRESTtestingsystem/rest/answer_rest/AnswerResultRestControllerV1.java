package com.ekimenko.spring.rest.SpringRESTtestingsystem.rest.answer_rest;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.dto.answer_dto.AnswerResultDto;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.answer.AnswerResult;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.service.answer_service.AnswerResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/answer_result")
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

    @GetMapping(value = "")
    public ResponseEntity<List<AnswerResultDto>> getAllAnswerResult() {

        List<AnswerResultDto> answerResultDtoList = resultService.getAllAnswerResultDto();

        return new ResponseEntity<>(answerResultDtoList, HttpStatus.OK);
    }

/*    @PostMapping(value = "")
    public void addNewAnswerResult(@RequestBody AnswerResultDto answerResultDto) {

        AnswerResult answerResult = answerResultDto.toAnswerResult();

        resultService.addNewAnswerResult(answerResult);

    }*/

    @PostMapping(value = "")
    public void updateAnswerResult(@RequestBody AnswerResultDto answerResultDto) {

        AnswerResult answerResult = answerResultDto.toAnswerResult();

        resultService.updateAnswerResult(answerResult);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteAnswerResultByID(@PathVariable long id) {

        resultService.deleteById(id);
    }

    @PostMapping(value = "/{id}")
    public AnswerResultDto setPointsForTheAnswer(@RequestBody AnswerResultDto answerResultDto) {

        return resultService.setPoints(answerResultDto);
    }

}
