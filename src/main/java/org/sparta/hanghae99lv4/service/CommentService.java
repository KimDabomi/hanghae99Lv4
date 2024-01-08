package org.sparta.hanghae99lv4.service;

import org.sparta.hanghae99lv4.dto.CommentRequestDto;
import org.sparta.hanghae99lv4.dto.CommentResponseDto;
import org.sparta.hanghae99lv4.entity.Comment;
import org.sparta.hanghae99lv4.jwt.JwtUtil;
import org.sparta.hanghae99lv4.message.ErrorMessage;
import org.sparta.hanghae99lv4.message.SuccessMessage;
import org.sparta.hanghae99lv4.repository.CommentRepository;
import org.sparta.hanghae99lv4.repository.LectureRepository;
import org.sparta.hanghae99lv4.repository.UserRepository;
import org.springframework.stereotype.Service;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommentService {
	private final CommentRepository commentRepository;
	private final UserRepository userRepository;
	private final LectureRepository lectureRepository;

	private final JwtUtil jwtUtil;

	public CommentResponseDto createComments(CommentRequestDto commentRequestDto) {
		Comment comment = commentRepository.save(new Comment(commentRequestDto));

		comment.setUser(userRepository.findById(comment.getUser().getId())
			.orElseThrow(() -> new EntityNotFoundException(ErrorMessage.EXIST_USER_ERROR_MESSAGE.getErrorMessage())));

		comment.setLecture(lectureRepository.findById(comment.getLecture().getId())
			.orElseThrow(
				() -> new EntityNotFoundException(ErrorMessage.EXIST_LECTURE_ERROR_MESSAGE.getErrorMessage())));

		return new CommentResponseDto(comment);
	}

	@Transactional
	public CommentResponseDto updateComments(Long commentId, CommentRequestDto commentRequestDto) {
		Comment comment = commentRepository.findById(commentId)
			.orElseThrow(() -> new EntityNotFoundException(ErrorMessage.EXIST_COMMENT_ERROR_MESSAGE.getErrorMessage()));

		if (!jwtUtil.getUserEmail().equals(comment.getUser().getEmail())) {
			throw new IllegalArgumentException(ErrorMessage.COMMENT_UPDATE_ERROR_MESSAGE.getErrorMessage());
		}

		comment.setComment(commentRequestDto.getComment());
		return new CommentResponseDto(comment);
	}

	@Transactional
	public String deleteComments(Long commentId) {
		Comment comment = commentRepository.findById(commentId)
			.orElseThrow(() -> new EntityNotFoundException(ErrorMessage.EXIST_COMMENT_ERROR_MESSAGE.getErrorMessage()));

		if (!jwtUtil.getUserEmail().equals(comment.getUser().getEmail())) {
			throw new IllegalArgumentException(ErrorMessage.COMMENT_DELETE_ERROR_MESSAGE.getErrorMessage());
		}

		commentRepository.deleteById(commentId);
		return SuccessMessage.DELETE_SUCCESS_MESSAGE.getSuccessMessage();
	}
}
