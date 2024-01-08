package org.sparta.hanghae99lv4.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.sparta.hanghae99lv4.dto.CommentRequestDto;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn
    private User user;

    @ManyToOne
    @JoinColumn(name = "lecture_id")
    private Lecture lecture;

    @Column
    private Long parent_id;

    @Column
    private String comment;

    public Comment(CommentRequestDto commentRequestDto) {
        this.user = commentRequestDto.getUser();
        this.lecture = commentRequestDto.getLecture();
        this.parent_id = commentRequestDto.getParent_id();
        this.comment = commentRequestDto.getComment();
    }
}
