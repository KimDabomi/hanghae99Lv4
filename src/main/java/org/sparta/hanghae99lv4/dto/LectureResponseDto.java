package org.sparta.hanghae99lv4.dto;

import lombok.Getter;
import org.sparta.hanghae99lv4.entity.Lecture;
import org.sparta.hanghae99lv4.entity.Like;
import org.sparta.hanghae99lv4.entity.Teacher;

import java.util.Date;

@Getter
public class LectureResponseDto {
    private Long lectureId;
    private Teacher teacher;
    private String lectureName;
    private Integer price;
    private String lectureIntro;
    private String category;
    private Date regiDate;
    private int likeCount;

    public LectureResponseDto(Lecture saveLecture, int likeCount) {
        this.lectureId = saveLecture.getLectureId();
        this.teacher = saveLecture.getTeacher();
        this.lectureName = saveLecture.getLectureName();
        this.price = saveLecture.getPrice();
        this.lectureIntro = saveLecture.getLectureIntro();
        this.category = saveLecture.getCategory();
        this.regiDate = saveLecture.getRegiDate();
        this.likeCount = likeCount;
    }
}