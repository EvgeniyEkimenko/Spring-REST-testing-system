package com.ekimenko.spring.rest.SpringRESTtestingsystem.model;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.test.Test;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.service.service_util.EntityWithLongId;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;


@Entity
@Table(name = "lesson_step")
@NoArgsConstructor
@Data
public class LessonStep implements EntityWithLongId {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "position_in_lesson")
    private Integer positionInLesson;

    @Column(name = "complete")
    private boolean complete;

    @ToString.Exclude
    @ManyToOne()
    @JoinColumn(name = "lesson_id")
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