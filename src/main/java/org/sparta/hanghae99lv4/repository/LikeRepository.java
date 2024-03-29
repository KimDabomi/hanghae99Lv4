package org.sparta.hanghae99lv4.repository;

import org.sparta.hanghae99lv4.entity.Lecture;
import org.sparta.hanghae99lv4.entity.Like;
import org.sparta.hanghae99lv4.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LikeRepository extends JpaRepository<Like, Long> {
    boolean existsByUserAndLecture(User user, Lecture lecture);
    int countByLecture(Lecture lecture);
    void deleteByUserAndLecture(User user, Lecture lecture);
    List<Like> findByUser(User user);
}
