package com.ekimenko.spring.rest.SpringRESTtestingsystem.dto;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.TheoreticalStep;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TheoreticalStepDto {
    private Long id;
    private String name;
    private String description;
    private String usefulText;
    private Long lessonStepId;

    public TheoreticalStep toTheoreticalStep(){
        TheoreticalStep theoreticalStep = new TheoreticalStep();
        theoreticalStep.setId(id);
        //TODO add code
        return theoreticalStep;
    }

}