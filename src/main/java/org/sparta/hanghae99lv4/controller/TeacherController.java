package org.sparta.hanghae99lv4.controller;

import org.sparta.hanghae99lv4.dto.TeacherRequestDto;
import org.sparta.hanghae99lv4.dto.TeacherResponseDto;
import org.sparta.hanghae99lv4.service.TeacherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
public class TeacherController {
    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @PostMapping("/teachers")
    public TeacherResponseDto createTeacher(@RequestBody TeacherRequestDto requestDto) {
        return teacherService.createTeacher(requestDto);
    }
}