package org.sparta.hanghae99lv4.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.sparta.hanghae99lv4.entity.Lecture;
import org.sparta.hanghae99lv4.entity.Like;
import org.sparta.hanghae99lv4.entity.User;
import org.sparta.hanghae99lv4.message.ErrorMessage;
import org.sparta.hanghae99lv4.message.SuccessMessage;
import org.sparta.hanghae99lv4.repository.LectureRepository;
import org.sparta.hanghae99lv4.repository.LikeRepository;
import org.sparta.hanghae99lv4.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LikeService {

    private final LikeRepository likeRepository;
    private final UserRepository userRepository;
    private final LectureRepository lectureRepository;

    @Transactional
    public ResponseEntity<String> createLike(Long userId, Long lectureId) {
        User user = findUser(userId);
        Lecture lecture = findLecture(lectureId);

        Like like = new Like();
        like.setUser(user);
        like.setLecture(lecture);
        likeRepository.save(like);

        return new ResponseEntity<>(SuccessMessage.LIKE_MESSAGE.getSuccessMessage(), HttpStatus.CREATED);
    }

    @Transactional
    public void deleteLike(Long userId, Long lectureId) {
        User user = findUser(userId);
        Lecture lecture = findLecture(lectureId);

        if (likeRepository.existsByUserAndLecture(user, lecture)) {
            likeRepository.deleteByUserAndLecture(user, lecture);
        }
    }

    private Lecture findLecture(Long lectureId) {
        return lectureRepository.findById(lectureId)
                .orElseThrow(() -> new EntityNotFoundException(ErrorMessage.EXIST_LECTURE_ERROR_MESSAGE.getErrorMessage()));
    }

    private User findUser(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException(ErrorMessage.EXIST_USER_ERROR_MESSAGE.getErrorMessage()));
    }
}
