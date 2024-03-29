package org.sparta.hanghae99lv4.entity;

import jakarta.persistence.*;
import lombok.Setter;

@Entity
@Setter
@Table(name = "likes")
public class Like {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn
    private User user;

    @ManyToOne
    @JoinColumn(name = "lecture_id")
    private Lecture lecture;
}
