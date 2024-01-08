package org.sparta.hanghae99lv4.dto;

import org.sparta.hanghae99lv4.entity.Lecture;
import org.sparta.hanghae99lv4.entity.User;

import lombok.Getter;

@Getter
public class CommentRequestDto {
	private Long id;
	private User user;
	private Lecture lecture;
	private Long parentId;
	private String comment;
}
