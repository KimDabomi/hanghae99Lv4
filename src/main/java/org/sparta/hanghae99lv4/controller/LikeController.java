package org.sparta.hanghae99lv4.controller;

import org.sparta.hanghae99lv4.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users/{userId}/lectures/{lectureId}")
public class LikeController {
    private final LikeService likeService;

    @Autowired
    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }

    @PostMapping("/like")
    public ResponseEntity<String> createLikeAndUnlike(
            @PathVariable Long userId,
            @PathVariable Long lectureId
    ) {
        return likeService.createLikeAndUnlike(userId, lectureId);
    }
}
