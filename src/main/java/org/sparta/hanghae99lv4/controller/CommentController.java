package org.sparta.hanghae99lv4.controller;

import org.sparta.hanghae99lv4.dto.CommentRequestDto;
import org.sparta.hanghae99lv4.dto.CommentResponseDto;
import org.sparta.hanghae99lv4.service.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api")
public class CommentController {
	private final CommentService commentService;

	@PostMapping("/users/lectures/comment")
	public ResponseEntity<CommentResponseDto> createComments(@RequestBody CommentRequestDto commentRequestDto) {
		return ResponseEntity.ok(commentService.createComments(commentRequestDto));
	}

	@PutMapping("/users/lectures/comments/{commentId}")
	public ResponseEntity<CommentResponseDto> updateComments(@PathVariable Long commentId,
		@RequestBody CommentRequestDto commentRequestDto) {
		return ResponseEntity.ok(commentService.updateComments(commentId, commentRequestDto));
	}

	@DeleteMapping("/users/lectures/comments/{commentId}")
	public ResponseEntity<String> deleteComments(@PathVariable Long commentId) {
		return ResponseEntity.ok(commentService.deleteComments(commentId));
	}
}
