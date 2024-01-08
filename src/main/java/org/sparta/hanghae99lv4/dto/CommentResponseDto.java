package org.sparta.hanghae99lv4.dto;

import org.sparta.hanghae99lv4.entity.Comment;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CommentResponseDto {
    private Long id;
    private String user;
    private Long parentId;
    private String comment;
    private CommentResponseDto recomment;

    public CommentResponseDto(Comment comment){
        this.id = comment.getId();
        this.user = comment.getUser().getEmail();
        this.parentId = comment.getParentId();
        this.comment = comment.getComment();
    }
}
