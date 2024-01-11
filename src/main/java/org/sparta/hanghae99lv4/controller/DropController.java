package org.sparta.hanghae99lv4.controller;

import org.sparta.hanghae99lv4.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DropController {

    private UserService userService;

    public DropController(UserService userService) {
        this.userService = userService;
    }

    @DeleteMapping("/users/drop/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable Long userId) {
        return userService.deleteUser(userId);
    }
}
