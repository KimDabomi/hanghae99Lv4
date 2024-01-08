package org.sparta.hanghae99lv4.dto;

import org.sparta.hanghae99lv4.entity.Comment;

import lombok.Getter;

@Getter
public class RecommentResponseDto {
	private Long id;
	private String user;
	private Long parentId;
	private String comment;

	public RecommentResponseDto(Comment comment){
		this.id = comment.getId();
		this.user = comment.getUser().getEmail();
		this.parentId = comment.getParentId();
		this.comment = comment.getComment();
	}
}
