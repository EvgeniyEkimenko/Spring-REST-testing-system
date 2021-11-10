package com.ekimenko.spring.rest.SpringRESTtestingsystem.dto;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.TheoreticalStep;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.user.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TheoreticalStepDto {
    private Long id;
    private String name;
    private String description;
    private String usefulText;


    public TheoreticalStep toTheoreticalStep(){
        TheoreticalStep theoreticalStep = new TheoreticalStep();
        theoreticalStep.setId(id);
        theoreticalStep.setName(name);
        theoreticalStep.setDescription(description);
        theoreticalStep.setUsefulText(usefulText);

        return theoreticalStep;
    }

    public static TheoreticalStepDto fromTheoreticalStep(TheoreticalStep theoreticalStep) {
        TheoreticalStepDto theoreticalStepDto = new TheoreticalStepDto();
        theoreticalStepDto.setId(theoreticalStepDto.getId());
        theoreticalStepDto.setName(theoreticalStepDto.getName());
        theoreticalStepDto.setDescription(theoreticalStepDto.getDescription());
        theoreticalStepDto.setUsefulText(theoreticalStepDto.getUsefulText());

        return theoreticalStepDto;
    }
}