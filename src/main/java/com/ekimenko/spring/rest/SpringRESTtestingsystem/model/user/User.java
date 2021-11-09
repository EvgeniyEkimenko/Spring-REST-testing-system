package com.ekimenko.spring.rest.SpringRESTtestingsystem.model.user;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.Course;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Table(name = "users")
@Data
public class User extends BaseEntity {

    @Column(name = "username")
    private String username;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")})
    private List<Role> roles;

    @ManyToMany(mappedBy = "users", fetch = FetchType.LAZY)
    private List<Course> course;
}