package com.ekimenko.spring.rest.SpringRESTtestingsystem.model.answer;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.question.Question;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.test.TestResult;
import com.ekimenko.spring.rest.SpringRESTtestingsystem.model.user.User;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Table(name = "answer_result")
@Data
public class AnswerResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "test_result_id")
    private TestResult testResult;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    @Column(name = "score")
    private Double score;

    @ToString.Exclude
    @OneToMany(fetch = FetchType.LAZY , mappedBy = "answerResult")
    @Column(name = "answer_result_id")
    private List<AnswerVariant> answerVariants;

}
