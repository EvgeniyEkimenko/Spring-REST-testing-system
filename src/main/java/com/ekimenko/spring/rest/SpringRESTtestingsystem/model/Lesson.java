package com.ekimenko.spring.rest.SpringRESTtestingsystem.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "lesson")
@NoArgsConstructor
@Data
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "complete")
    private Boolean complete;

    @OneToMany(fetch = FetchType.LAZY)
    @Column(name = "lesson_step_id")
    private List<LessonStep> lessonSteps;

    @ManyToOne
    private Course course;

}
