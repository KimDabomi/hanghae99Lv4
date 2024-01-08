package org.sparta.hanghae99lv4.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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
    @JoinColumn(name = "user_id", nullable = false)
    @Setter
    private User user;

    @ManyToOne
    @JoinColumn(name = "lecture_id", nullable = false)
    @Setter
    private Lecture lecture;

    @Column(name = "parent_id")
    private Long parentId;

    @Column
    @Setter
    private String comment;

	public Comment(CommentRequestDto commentRequestDto) {
        this.user = commentRequestDto.getUser();
        this.lecture = commentRequestDto.getLecture();
        this.parentId = commentRequestDto.getParentId();
        this.comment = commentRequestDto.getComment();
	}
}
