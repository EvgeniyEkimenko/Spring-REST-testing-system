package com.ekimenko.spring.rest.SpringRESTtestingsystem.model.question;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.answer.AnswerResult;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.answer.AnswerVariant;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.test.Test;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.service.service_util.EntityWithLongId;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "question")
@NoArgsConstructor
@Data
public class Question implements EntityWithLongId {

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
    private boolean allowedParticleAnswer;

    @ToString.Exclude
    @ManyToOne()
    @JoinColumn(name = "test_id")
    private Test test;

    @ToString.Exclude
    @OneToMany(fetch = FetchType.LAZY , mappedBy = "question")
    @Column(name = "question_id")
    private List<AnswerVariant> answerVariants;

    @ToString.Exclude
    @OneToMany(fetch = FetchType.LAZY , mappedBy = "question")
    @Column(name = "question_id")
    private List<AnswerResult> answerResults;

}
