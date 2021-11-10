package com.ekimenko.spring.rest.SpringRESTtestingsystem.model.question;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.answer.AnswerResult;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.answer.AnswerVariant;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.test.Test;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "question")
@NoArgsConstructor
@Data
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "text")
    private String text;

    @Column(name = "score")
    private Double score;

    @Column(name = "position")
    private Integer position;

    @Column(name = "allowed_particle_answer")
    private Boolean allowedParticleAnswer;

    @ManyToOne()   //тестовое
    private Test test;

    @OneToMany(fetch = FetchType.LAZY)
    @Column(name = "question_id")
    private List<AnswerVariant> answerVariants;

    @OneToMany(fetch = FetchType.LAZY)
    @Column(name = "question_id")
    private List<AnswerResult> answerResults;

}
