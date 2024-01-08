package org.sparta.hanghae99lv4.service;

import lombok.RequiredArgsConstructor;
import org.sparta.hanghae99lv4.dto.LectureRequestDto;
import org.sparta.hanghae99lv4.dto.LectureResponseDto;
import org.sparta.hanghae99lv4.entity.Lecture;
import org.sparta.hanghae99lv4.entity.Like;
import org.sparta.hanghae99lv4.entity.Teacher;
import org.sparta.hanghae99lv4.message.ErrorMessage;
import org.sparta.hanghae99lv4.repository.LectureRepository;
import org.sparta.hanghae99lv4.repository.LikeRepository;
import org.sparta.hanghae99lv4.repository.TeacherRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LectureService {
    private final LectureRepository lectureRepository;
    private final TeacherRepository teacherRepository;
    private final LikeRepository likeRepository;

    public LectureResponseDto createLecture(LectureRequestDto lectureRequestDto) {
        Long teacherId = lectureRequestDto.getTeacherId();
        Teacher teacher = teacherRepository.findById(teacherId).orElseThrow(() ->
                new IllegalArgumentException(ErrorMessage.EXIST_TEACHER_ERROR_MESSAGE.getErrorMessage())
        );

        Lecture lecture = new Lecture(lectureRequestDto, teacher);
        Lecture saveLecture = lectureRepository.save(lecture);

        return new LectureResponseDto(saveLecture, 0);
    }

    public LectureResponseDto getLecture(Long lectureId) {
        Lecture lecture = findLecture(lectureId);
        int likeCount = likeRepository.countByLecture(lecture);
        return new LectureResponseDto(lecture, likeCount);
    }

    public List<LectureResponseDto> getLectureListForCategorySorted(String category, Sort sort) {
        List<Lecture> lectures = lectureRepository.findAllByCategoryOrderByRegiDateDesc(category, sort);
        return lectures.stream()
                .map(lecture -> new LectureResponseDto(lecture, likeRepository.countByLecture(lecture)))
                .collect(Collectors.toList());
    }

    private Lecture findLecture(Long lectureId){
        return lectureRepository.findById(lectureId).orElseThrow(() ->
                new IllegalArgumentException(ErrorMessage.EXIST_LECTURE_ERROR_MESSAGE.getErrorMessage()));
    }
}
