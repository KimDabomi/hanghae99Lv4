package org.sparta.hanghae99lv4.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.sparta.hanghae99lv4.entity.Lecture;
import org.sparta.hanghae99lv4.entity.User;


@Getter
public class CommentRequestDto {
    private Long id;
    private User user;
    private Lecture lecture;
    private Long parent_id;
    private String comment;
}
