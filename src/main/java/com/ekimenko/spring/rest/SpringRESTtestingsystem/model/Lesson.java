package com.ekimenko.spring.rest.SpringRESTtestingsystem.model;

import com.ekimenko.spring.rest.SpringRESTtestingsystem.service.service_util.EntityWithLongId;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "lesson")
@NoArgsConstructor
@Data
public class Lesson implements EntityWithLongId {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "complete")
    private Boolean complete;

    @ToString.Exclude
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "lesson")
    @Column(name = "lesson_id")
    private List<LessonStep> lessonSteps;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

}
