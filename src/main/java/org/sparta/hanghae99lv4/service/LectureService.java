package org.sparta.hanghae99lv4.service;

import lombok.RequiredArgsConstructor;
import org.sparta.hanghae99lv4.dto.LectureRequestDto;
import org.sparta.hanghae99lv4.dto.LectureResponseDto;
import org.sparta.hanghae99lv4.entity.Lecture;
import org.sparta.hanghae99lv4.entity.Teacher;
import org.sparta.hanghae99lv4.message.ErrorMessage;
import org.sparta.hanghae99lv4.repository.LectureRepository;
import org.sparta.hanghae99lv4.repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LectureService {
    private final LectureRepository lectureRepository;
    private final TeacherRepository teacherRepository;

    public LectureResponseDto createLecture(LectureRequestDto lectureRequestDto) {
        Long teacherId = lectureRequestDto.getTeacherId();
        Teacher teacher = teacherRepository.findById(teacherId).orElseThrow(() ->
                new IllegalArgumentException(ErrorMessage.EXIST_TEACHER_ERROR_MESSAGE.getErrorMessage())
        );

        Lecture lecture = new Lecture(lectureRequestDto, teacher);
        Lecture saveLecture = lectureRepository.save(lecture);

        return new LectureResponseDto(saveLecture);
    }

    public LectureResponseDto getLecture(Long lectureId) {
        return new LectureResponseDto(findLecture(lectureId));
    }

    public List<LectureResponseDto> getLectureListForCategory(String category) {
        return lectureRepository.findAllByCategoryOrderByRegiDateDesc(category)
                .stream().map(LectureResponseDto::new).toList();
    }

    private Lecture findLecture(Long lectureId){
        return lectureRepository.findById(lectureId).orElseThrow(() ->
                new IllegalArgumentException(ErrorMessage.EXIST_LECTURE_ERROR_MESSAGE.getErrorMessage()));
    }
}
