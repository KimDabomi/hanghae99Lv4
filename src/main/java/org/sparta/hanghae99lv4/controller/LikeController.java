package org.sparta.hanghae99lv4.controller;

import org.sparta.hanghae99lv4.message.SuccessMessage;
import org.sparta.hanghae99lv4.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users/{userId}/lectures/{lectureId}")
public class LikeController {

    private final LikeService likeService;

    @Autowired
    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }

    @PostMapping("/like")
    public ResponseEntity<String> createLike(
            @PathVariable Long userId,
            @PathVariable Long lectureId
    ) {
        return likeService.createLike(userId, lectureId);
    }

    @DeleteMapping("/like")
    public ResponseEntity<String> deleteLike(
            @PathVariable Long userId,
            @PathVariable Long lectureId
    ) {
        likeService.deleteLike(userId, lectureId);
        return new ResponseEntity<>(SuccessMessage.UNLIKE_MESSAGE.getSuccessMessage(), HttpStatus.OK);
    }
}
