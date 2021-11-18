package com.ekimenko.spring.rest.SpringRESTtestingsystem.rest.answer_rest;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.dto.answer_dto.AnswerVariantDto;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.answer.AnswerVariant;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.service.answer_service.AnswerVariantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/answer_variant")
public class AnswerVariantRestControllerV1 {

    private final AnswerVariantService answerVariantService;

    @Autowired
    public AnswerVariantRestControllerV1(AnswerVariantService answerVariantService) {
        this.answerVariantService = answerVariantService;
    }


  /*  @GetMapping(value = "/{id}")
    public ResponseEntity<AnswerVariantDto> getAnswerVariantById(@PathVariable long id) {
        AnswerVariant answerVariant = answerVariantService.getAnswerVariantById(id);

        AnswerVariantDto answerVariantDto = AnswerVariantDto.fromAnswerVariant(answerVariant);

        return new ResponseEntity<>(answerVariantDto, HttpStatus.OK);
    }

    @GetMapping(value = "")
    public ResponseEntity<List<AnswerVariantDto>> getAllAnswerVariants() {
        List<AnswerVariant> answerVariantList = answerVariantService.getAllAnswerVariants();

        List<AnswerVariantDto> answerVariantsDto = new ArrayList<>();
        for (AnswerVariant answerVariant : answerVariantList) {
            answerVariantsDto.add(AnswerVariantDto.fromAnswerVariant(answerVariant));
        }

        return new ResponseEntity<>(answerVariantsDto, HttpStatus.OK);
    }

    @PostMapping(value = "")
    public void addNewAnswerVariant(@RequestBody AnswerVariantDto answerVariantDto) {

        //TODO solve the problem of implementing the save and update methods
    }

    @PutMapping(value = "")
    public void updateAnswerVariant(@RequestBody AnswerVariantDto answerVariantDto) {

        //TODO solve the problem of implementing the save and update methods

    }

    @DeleteMapping(value = "/{id}")
    public void deleteAnswerVariantByID(@PathVariable long id) {

        answerVariantService.deleteAnswerVariantById(id);

    }
*/

}
