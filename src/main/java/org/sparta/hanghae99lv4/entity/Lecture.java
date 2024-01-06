package org.sparta.hanghae99lv4.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.sparta.hanghae99lv4.dto.LectureRequestDto;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "lectures")
public class Lecture extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long lectureId;

    @ManyToOne
    @JoinColumn(name = "teacher_id",nullable = false)
    private Teacher teacher;

    @Column(name = "lecture_name", nullable = false)
    private String lectureName;

    @Column(name = "price", nullable = false)
    private Integer price;

    @Column(name = "lecture_intro", nullable = false)
    private String lectureIntro;

    @Column(name = "category", nullable = false)
    private String category;

    public Lecture(LectureRequestDto lectureRequestDto, Teacher teacher) {
        this.teacher = teacher;
        this.lectureName = lectureRequestDto.getLectureName();
        this.price = lectureRequestDto.getPrice();
        this.lectureIntro = lectureRequestDto.getLectureIntro();
        this.category = lectureRequestDto.getCategory();
    }
}
