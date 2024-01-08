package org.sparta.hanghae99lv4.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.sparta.hanghae99lv4.dto.TeacherRequestDto;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "teachers")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "teacher_name", nullable = false)
    private String teacherName;

    @Column(nullable = false)
    private int career;

    @Column(nullable = false)
    private String company;

    @Column(nullable = false)
    @JsonIgnore
    private String phone;

    @Column(name = "teacher_intro", nullable = false)
    private String teacherIntro;

    public Teacher(TeacherRequestDto requestDto) {
        this.teacherName = requestDto.getTeacherName();
        this.career = requestDto.getCareer();
        this.company = requestDto.getCompany();
        this.phone = requestDto.getPhone();
        this.teacherIntro = requestDto.getTeacherIntro();
    }
}
