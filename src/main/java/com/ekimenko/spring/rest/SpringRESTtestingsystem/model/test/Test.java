package com.ekimenko.spring.rest.SpringRESTtestingsystem.model.test;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.LessonStep;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.question.Question;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.service.service_util.EntityWithLongId;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Table(name = "test")
@Data
public class Test implements EntityWithLongId {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "requered_score")
    private Long requeredScore;

    @Column(name = "number_attempts")
    private Long numberAttempts;

    @ToString.Exclude
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "test_id")
    private List<Question> questions;

    @ToString.Exclude
    @OneToOne(mappedBy = "test")
    private LessonStep lessonStep;

    @ToString.Exclude
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "test_id")
    private List<TestResult> testResults;

}
