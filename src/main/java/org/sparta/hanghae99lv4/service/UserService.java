package org.sparta.hanghae99lv4.service;

import lombok.RequiredArgsConstructor;
import org.sparta.hanghae99lv4.dto.UserRequestDto;
import org.sparta.hanghae99lv4.entity.Comment;
import org.sparta.hanghae99lv4.entity.Like;
import org.sparta.hanghae99lv4.entity.User;
import org.sparta.hanghae99lv4.entity.UserAuthEnum;
import org.sparta.hanghae99lv4.message.ErrorMessage;
import org.sparta.hanghae99lv4.message.SuccessMessage;
import org.sparta.hanghae99lv4.repository.CommentRepository;
import org.sparta.hanghae99lv4.repository.LikeRepository;
import org.sparta.hanghae99lv4.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
public class UserService {
    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private static final String PASSWORD_PATTERN = "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,15}$";
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final CommentRepository commentRepository;
    private final LikeRepository likeRepository;

    public void createUser(UserRequestDto requestDto) {
        String email = requestDto.getEmail();
        String password = requestDto.getPassword();
        String gender = requestDto.getGender();
        String phone = requestDto.getPhone();
        String address = requestDto.getAddress();
        UserAuthEnum auth = UserAuthEnum.valueOf(requestDto.getAuth());

        checkEmailAndPwPattern(email, password);

        String encodedPassword = passwordEncoder.encode(password);
        User user = new User(email, encodedPassword, gender, phone, address, auth);
        userRepository.save(user);
    }

    public ResponseEntity<String> deleteUser(Long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if(optionalUser.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.EXIST_USER_ERROR_MESSAGE.getErrorMessage());
        }

        User user = optionalUser.get();
        List<Comment> comments = commentRepository.findByUser(user);
        commentRepository.deleteAll(comments);

        List<Like> likes = likeRepository.findByUser(user);
        likeRepository.deleteAll(likes);
        userRepository.delete(user);
        return ResponseEntity.status(HttpStatus.OK).body(SuccessMessage.DELETE_SUCCESS_MESSAGE.getSuccessMessage());
    }

    private void checkEmailAndPwPattern(String email, String password) {
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(ErrorMessage.EMAIL_FORMAT_ERROR_MESSAGE.getErrorMessage());
        }

        Pattern passwordPattern = Pattern.compile(PASSWORD_PATTERN);
        Matcher passwordMatcher = passwordPattern.matcher(password);
        if (!passwordMatcher.matches()) {
            throw new IllegalArgumentException(ErrorMessage.PASSWORD_VALIDATION_ERROR_MESSAGE.getErrorMessage());
        }
    }
}
