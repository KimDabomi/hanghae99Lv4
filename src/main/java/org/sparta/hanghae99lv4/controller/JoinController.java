package org.sparta.hanghae99lv4.controller;

import org.sparta.hanghae99lv4.dto.UserRequestDto;
import org.sparta.hanghae99lv4.message.SuccessMessage;
import org.sparta.hanghae99lv4.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class JoinController {

    private UserService userService;

    public JoinController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/join")
    public ResponseEntity<String> createUser(@RequestBody UserRequestDto requestDto) {
        return handleRequest(() -> {
            userService.createUser(requestDto);
            return new ResponseEntity<>(SuccessMessage.JOIN_SUCCESS_MESSAGE.getSuccessMessage(), HttpStatus.CREATED);
        });
    }

    private ResponseEntity<String> handleRequest(RequestHandler handler) {
        try {
            return handler.handle();
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @FunctionalInterface
    private interface RequestHandler {
        ResponseEntity<String> handle();
    }
}
