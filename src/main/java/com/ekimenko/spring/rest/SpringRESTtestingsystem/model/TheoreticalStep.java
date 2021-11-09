package com.ekimenko.spring.rest.SpringRESTtestingsystem.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "theoretical_step")
@NoArgsConstructor
@Data
public class TheoreticalStep {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "useful_text")
    private String usefulText;

    @ManyToOne
    private Lesson lesson;
}