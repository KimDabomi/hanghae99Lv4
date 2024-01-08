package org.sparta.hanghae99lv4.controller;

import org.sparta.hanghae99lv4.dto.CommentRequestDto;
import org.sparta.hanghae99lv4.dto.CommentResponseDto;
import org.sparta.hanghae99lv4.service.CommentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api")
public class CommentController {
	private final CommentService commentService;

	@PostMapping("/users/lectures/comment")
	public CommentResponseDto createComments(@RequestBody CommentRequestDto commentRequestDto) {
		return commentService.createComments(commentRequestDto);
	}
}
