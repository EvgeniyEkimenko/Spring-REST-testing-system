package com.ekimenko.spring.rest.SpringRESTtestingsystem.rest.answer_rest;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.dto.answer_dto.AnswerVariantDto;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.service.answer_service.AnswerVariantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/answer_variant")
public class AnswerVariantRestControllerV1 {

    private final AnswerVariantService answerVariantService;

    @Autowired
    public AnswerVariantRestControllerV1(AnswerVariantService answerVariantService) {
        this.answerVariantService = answerVariantService;
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<AnswerVariantDto> getAnswerVariantById(@PathVariable long id) {

        AnswerVariantDto answerVariantDto = answerVariantService.getAnswerVariantDtoById(id);

        return new ResponseEntity<>(answerVariantDto, HttpStatus.OK);
    }

    @GetMapping(value = "")
    public ResponseEntity<List<AnswerVariantDto>> getAllAnswerVariants() {

        List<AnswerVariantDto> answerVariantsDto = answerVariantService.getAllAnswerVariantsDto();

        return new ResponseEntity<>(answerVariantsDto, HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<AnswerVariantDto> addNewAnswerVariant(@RequestBody AnswerVariantDto answerVariantDto) {

        AnswerVariantDto AnswerVariantRes = answerVariantService
                .addNewAnswerVariant(answerVariantService
                        .toAnswerVariant(answerVariantDto));

        return new ResponseEntity<>(AnswerVariantRes, HttpStatus.OK);
    }

    @PutMapping(value = "")
    public ResponseEntity<AnswerVariantDto> updateAnswerVariant(@RequestBody AnswerVariantDto answerVariantDto) {

        AnswerVariantDto AnswerVariantRes = answerVariantService
                .updateAnswerVariant(answerVariantService
                        .toAnswerVariant(answerVariantDto));

        return new ResponseEntity<>(AnswerVariantRes, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteAnswerVariantByID(@PathVariable long id) {

        answerVariantService.deleteAnswerVariantById(id);

    }

}
