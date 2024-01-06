package org.sparta.hanghae99lv4.repository;

import org.sparta.hanghae99lv4.entity.Lecture;
import org.sparta.hanghae99lv4.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LectureRepository extends JpaRepository<Lecture, Long> {
    List<Lecture> findAllByTeacherIdOrderByRegiDateDesc(Long teacherId);

    List<Lecture> findAllByCategoryOrderByRegiDateDesc(String category);

    List<Lecture> findByTeacher(Teacher teacher);
}
