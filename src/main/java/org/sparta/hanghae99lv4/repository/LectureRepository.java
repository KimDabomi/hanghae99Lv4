package org.sparta.hanghae99lv4.repository;

import org.sparta.hanghae99lv4.entity.Lecture;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LectureRepository extends JpaRepository<Lecture, Long> {
    List<Lecture> findAllByCategoryOrderByRegiDateDesc(String category, Sort sort);
}
