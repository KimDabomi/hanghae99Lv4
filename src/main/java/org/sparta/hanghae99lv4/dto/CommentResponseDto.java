package org.sparta.hanghae99lv4.dto;

import java.util.List;

import org.sparta.hanghae99lv4.entity.Comment;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@RequiredArgsConstructor
public class CommentResponseDto {

    private Long id;
    private String user;
    private String comment;
    @Setter
    private List<ReCommentResponseDto> reComments;

    public CommentResponseDto(Comment comment){
        this.id = comment.getId();
        this.user = comment.getUser().getEmail();
        this.comment = comment.getComment();
    }

    public CommentResponseDto(Comment comment, List<ReCommentResponseDto> reComments){
        this.id = comment.getId();
        this.user = comment.getUser().getEmail();
        this.comment = comment.getComment();
        this.reComments = reComments;
    }
}
