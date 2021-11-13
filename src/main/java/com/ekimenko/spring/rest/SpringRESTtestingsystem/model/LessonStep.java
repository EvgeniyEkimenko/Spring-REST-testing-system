package com.ekimenko.spring.rest.SpringRESTtestingsystem.model;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.test.Test;
import lombok.*;
import org.springframework.lang.Nullable;

import javax.management.ConstructorParameters;
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

    @ToString.Exclude
    @ManyToOne
    private Lesson lesson;

    @ToString.Exclude
    @OneToOne
    @JoinColumn(name = "theoretical_step_id")
    private TheoreticalStep theoreticalStep;

    @ToString.Exclude
    @OneToOne
    @JoinColumn(name = "test_id")
    private Test test;

}