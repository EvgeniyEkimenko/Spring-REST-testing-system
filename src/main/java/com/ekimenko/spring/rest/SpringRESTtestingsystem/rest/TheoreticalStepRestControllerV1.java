package com.ekimenko.spring.rest.SpringRESTtestingsystem.rest;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.dto.TheoreticalStepDto;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.service.theoretical_step_service.TheoreticalStepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/theoretical-step")
public class TheoreticalStepRestControllerV1 {

    private final TheoreticalStepService theoreticalStepService;

    @Autowired
    public TheoreticalStepRestControllerV1(TheoreticalStepService theoreticalStepService) {
        this.theoreticalStepService = theoreticalStepService;
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<TheoreticalStepDto> getTheoreticalStepById(@PathVariable long id) {

        TheoreticalStepDto theoreticalStepDto = theoreticalStepService.getTheoreticalStepDtoById(id);

        return new ResponseEntity<>(theoreticalStepDto, HttpStatus.OK);
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<TheoreticalStepDto>> getAllTheoreticalSteps() {

        List<TheoreticalStepDto> theoreticalStepDtoList = theoreticalStepService.getAllTheoreticalStepsDto();

        return new ResponseEntity<>(theoreticalStepDtoList, HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<TheoreticalStepDto> addNewTheoreticalStep(@RequestBody TheoreticalStepDto theoreticalStepDto) {

        TheoreticalStepDto theoreticalStepDtoRes = theoreticalStepService
                .addNewTheoreticalStep(theoreticalStepService
                        .toTheoreticalStep(theoreticalStepDto));

        return new ResponseEntity<>(theoreticalStepDtoRes, HttpStatus.OK);
    }

    @PutMapping(value = "")
    public ResponseEntity<TheoreticalStepDto> updateTheoreticalStep(@RequestBody TheoreticalStepDto theoreticalStepDto) {

        TheoreticalStepDto theoreticalStepDtoRes = theoreticalStepService
                .updateTheoreticalStep(theoreticalStepService
                        .toTheoreticalStep(theoreticalStepDto));

        return new ResponseEntity<>(theoreticalStepDtoRes, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteTheoreticalStepByID(@PathVariable long id) {

        theoreticalStepService.deleteTheoreticalStepById(id);

    }
}