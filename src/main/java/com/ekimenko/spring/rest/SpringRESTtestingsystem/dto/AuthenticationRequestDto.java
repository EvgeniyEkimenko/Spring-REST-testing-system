package com.ekimenko.spring.rest.SpringRESTtestingsystem.dto;

import lombok.Data;

@Data
public class AuthenticationRequestDto {
    private String username;
    private String password;
}
