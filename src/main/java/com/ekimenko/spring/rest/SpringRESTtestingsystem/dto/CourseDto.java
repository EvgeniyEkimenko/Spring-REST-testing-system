package com.ekimenko.spring.rest.SpringRESTtestingsystem.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CourseDto {
    private Long id;
    private String name;
    private String description;
    private Boolean complete;
    private List<Long> lessonsId;
    private List<Long> usersId;


}