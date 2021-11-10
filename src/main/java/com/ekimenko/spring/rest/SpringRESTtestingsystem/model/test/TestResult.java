package com.ekimenko.spring.rest.SpringRESTtestingsystem.model.test;


import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.answer.AnswerResult;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.user.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Table(name = "test_result")
@Data
public class TestResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "test_id")
    private Test testId;

    @Column(name = "score")
    private Double score;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "test_result_id")
    private List<AnswerResult> answerResults;

    @ManyToOne
    private User user;

}
