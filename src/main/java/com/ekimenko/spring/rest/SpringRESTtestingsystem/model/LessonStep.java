package com.ekimenko.spring.rest.SpringRESTtestingsystem.model;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.test.Test;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Table(name = "lesson_step")
@NoArgsConstructor
@Data
public class LessonStep {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "position_in_lesson")
    private Integer positionInLesson;

    @ManyToOne
    private Lesson lesson;

    @OneToOne
    private TheoreticalStep theoreticalStep;

    @OneToOne
    private Test test;


}