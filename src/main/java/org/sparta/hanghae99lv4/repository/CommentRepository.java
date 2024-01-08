package org.sparta.hanghae99lv4.repository;

import org.sparta.hanghae99lv4.dto.CommentResponseDto;
import org.sparta.hanghae99lv4.entity.Comment;
import org.sparta.hanghae99lv4.entity.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findByLectureId(Long lectureId);

    List<Comment> findByLecture(Lecture lecture);
}
