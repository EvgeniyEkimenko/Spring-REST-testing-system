package com.ekimenko.spring.rest.SpringRESTtestingsystem.model.answer;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.question.Question;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.service.service_util.EntityWithLongId;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@NoArgsConstructor
@Table(name = "answer_variant")
@Data
public class AnswerVariant implements EntityWithLongId {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "text")
    private String text;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    @Column(name = "correct")
    private Boolean correct;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "answer_result_id")
    private AnswerResult answerResult;

}
