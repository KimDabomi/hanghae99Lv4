package org.sparta.hanghae99lv4.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.sparta.hanghae99lv4.entity.Teacher;

@Getter
@NoArgsConstructor
public class LectureRequestDto {
    private Teacher teacher;
    private String lectureName;
    private Integer price;
    private String lectureIntro;
    private String category;

    public Long getTeacherId(){
        return teacher.getId();
    }
}

