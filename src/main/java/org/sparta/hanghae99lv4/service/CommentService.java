package org.sparta.hanghae99lv4.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

import org.sparta.hanghae99lv4.dto.CommentRequestDto;
import org.sparta.hanghae99lv4.dto.CommentResponseDto;
import org.sparta.hanghae99lv4.entity.Comment;
import org.sparta.hanghae99lv4.entity.Lecture;
import org.sparta.hanghae99lv4.entity.User;
import org.sparta.hanghae99lv4.message.ErrorMessage;
import org.sparta.hanghae99lv4.repository.CommentRepository;
import org.sparta.hanghae99lv4.repository.LectureRepository;
import org.sparta.hanghae99lv4.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {
	private final CommentRepository commentRepository;
	private final UserRepository userRepository;
	private final LectureRepository lectureRepository;

	// 등록
	// NULL 없애야하니까 값 넣어주기
	public CommentResponseDto createComments(CommentRequestDto commentRequestDto) {
		Comment comment = commentRepository.save(new Comment(commentRequestDto));

		comment.setUser(userRepository.findById(comment.getUser().getId())
			.orElseThrow(() -> new EntityNotFoundException(ErrorMessage.EXIST_USER_ERROR_MESSAGE.getErrorMessage())));

		comment.setLecture(lectureRepository.findById(comment.getLecture().getLectureId())
			.orElseThrow(() -> new EntityNotFoundException(ErrorMessage.EXIST_LECTURE_ERROR_MESSAGE.getErrorMessage())));

		return new CommentResponseDto(comment);
	}

	// 수정

	// 삭제

}
