package com.ekimenko.spring.rest.SpringRESTtestingsystem.dto.user_dto;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.user.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDto {
    private Long id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    public User toUser() {
        User user = new User();
        user.setId(id);
        user.setUsername(username);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        //FIXME if will be bugs
        if (password != null && !password.equals("")) user.setPassword(password);

        return user;
    }

}
