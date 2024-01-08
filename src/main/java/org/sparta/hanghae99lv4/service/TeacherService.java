package org.sparta.hanghae99lv4.service;

import lombok.RequiredArgsConstructor;
import org.sparta.hanghae99lv4.dto.TeacherRequestDto;
import org.sparta.hanghae99lv4.dto.TeacherResponseDto;
import org.sparta.hanghae99lv4.entity.Teacher;
import org.sparta.hanghae99lv4.repository.TeacherRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class TeacherService {
    private final TeacherRepository teacherRepository;

    public TeacherResponseDto createTeacher(TeacherRequestDto requestDto) {
        Teacher teacher = new Teacher(requestDto);
        Teacher saveTeacher = teacherRepository.save(teacher);
        return new TeacherResponseDto(saveTeacher);
    }
}
