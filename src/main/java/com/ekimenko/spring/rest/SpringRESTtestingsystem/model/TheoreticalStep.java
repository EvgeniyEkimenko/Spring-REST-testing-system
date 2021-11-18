package com.ekimenko.spring.rest.SpringRESTtestingsystem.model;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.service.service_util.EntityWithLongId;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "theoretical_step")
@NoArgsConstructor
@Data
public class TheoreticalStep implements EntityWithLongId {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "useful_text")
    private String usefulText;

    @ToString.Exclude
    @OneToOne(mappedBy = "theoreticalStep")
    private LessonStep lessonStep;


}