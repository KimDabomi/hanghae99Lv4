package org.sparta.hanghae99lv4.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

import org.sparta.hanghae99lv4.dto.CommentRequestDto;
import org.sparta.hanghae99lv4.dto.CommentResponseDto;
import org.sparta.hanghae99lv4.entity.Comment;
import org.sparta.hanghae99lv4.repository.CommentRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {
	private final CommentRepository commentRepository;

	// 조회
	public CommentResponseDto getComments(Long id) {
		return new CommentResponseDto(
			commentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("")));
	}

	// 등록
	public CommentResponseDto createComments(CommentRequestDto commentRequestDto) {
		return new CommentResponseDto(commentRepository.save(new Comment(commentRequestDto)));
	}

	// 수정

	// 삭제

}
