package org.sparta.hanghae99lv4.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.sparta.hanghae99lv4.entity.Comment;
import org.sparta.hanghae99lv4.entity.Lecture;
import org.sparta.hanghae99lv4.entity.User;

@Getter
@RequiredArgsConstructor
public class CommentResponseDto {
    private Long id;
    private User user;
    private Lecture lecture;
    private Long parentId;
    private String comment;

    public CommentResponseDto(Comment comment){
        this.id = comment.getId();
        this.user = comment.getUser();
        this.lecture = comment.getLecture();
        this.parentId = comment.getParentId();
        this.comment = comment.getComment();
    }
}
