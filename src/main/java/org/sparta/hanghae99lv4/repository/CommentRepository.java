package org.sparta.hanghae99lv4.repository;

import org.sparta.hanghae99lv4.entity.Comment;
import org.sparta.hanghae99lv4.entity.Lecture;
import org.sparta.hanghae99lv4.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByLectureId(Long lectureId);
    List<Comment> findByLectureIn(List<Lecture> lecture);
    List<Comment> findByUser(User user);
    List<Comment> findByParentId(Long parentId);
}
