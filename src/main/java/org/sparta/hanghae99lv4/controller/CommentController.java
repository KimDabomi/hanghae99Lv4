package org.sparta.hanghae99lv4.controller;

import lombok.RequiredArgsConstructor;
import org.sparta.hanghae99lv4.dto.CommentRequestDto;
import org.sparta.hanghae99lv4.dto.CommentResponseDto;
import org.sparta.hanghae99lv4.service.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/users/lectures")
public class CommentController {
	private final CommentService commentService;

	@PostMapping("/comments")
	public ResponseEntity<CommentResponseDto> createComments(@RequestBody CommentRequestDto commentRequestDto) {
		return ResponseEntity.ok(commentService.createComments(commentRequestDto));
	}

	@PutMapping("/comments/{commentId}")
	public ResponseEntity<CommentResponseDto> updateComments(@PathVariable Long commentId, @RequestBody CommentRequestDto commentRequestDto) {
		return ResponseEntity.ok(commentService.updateComments(commentId, commentRequestDto));
	}

	@DeleteMapping("/comments/{commentId}")
	public ResponseEntity<String> deleteComments(@PathVariable Long commentId){
		return ResponseEntity.ok(commentService.deleteComments(commentId));
	}
}
