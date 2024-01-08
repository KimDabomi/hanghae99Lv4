package org.sparta.hanghae99lv4.dto;

import lombok.Getter;
import org.sparta.hanghae99lv4.entity.Comment;
import org.sparta.hanghae99lv4.entity.Lecture;
import org.sparta.hanghae99lv4.entity.User;

@Getter
public class CommentResponseDto {
    private Long id;
    private User user;
    private Lecture lecture;
    private Long parent_id;
    private String comment;

    public CommentResponseDto(Comment comment){
        this.id = comment.getId();
        this.user = comment.getUser();
        this.lecture = comment.getLecture();
        this.parent_id = comment.getParent_id();
        this.comment = comment.getComment();
    }
}