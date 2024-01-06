package org.sparta.hanghae99lv4.controller;

import lombok.RequiredArgsConstructor;
import org.sparta.hanghae99lv4.dto.LectureRequestDto;
import org.sparta.hanghae99lv4.dto.LectureResponseDto;
import org.sparta.hanghae99lv4.service.LectureService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api")
public class LectureController {

    private final LectureService lectureService;

    @PostMapping("/admin/lectures")
    public ResponseEntity<LectureResponseDto> createLecture(@RequestBody LectureRequestDto lectureRequestDto){
        LectureResponseDto lectureResponseDto = lectureService.createLecture(lectureRequestDto);
        return ResponseEntity.ok(lectureResponseDto);
    }

    @GetMapping("/users/lectures/{lectureId}")
    public ResponseEntity<LectureResponseDto> getLecture(@PathVariable Long lectureId){
        LectureResponseDto lectureResponseDto = lectureService.getLecture(lectureId);
        return ResponseEntity.ok(lectureResponseDto);
    }

    @GetMapping("/users/lectures")
    public ResponseEntity<List<LectureResponseDto>> getLectureListForCategory(@RequestParam String category){
        List<LectureResponseDto> lectureResponseDtoList = lectureService.getLectureListForCategory(category);
        return ResponseEntity.ok(lectureResponseDtoList);
    }

}
