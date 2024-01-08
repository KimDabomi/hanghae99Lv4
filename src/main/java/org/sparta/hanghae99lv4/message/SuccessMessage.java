package org.sparta.hanghae99lv4.message;

public enum SuccessMessage {
    JOIN_SUCCESS_MESSAGE("회원가입이 완료되었습니다."),
    LOGIN_SUCCESS_MESSAGE("로그인이 완료되었습니다."),
    DELETE_SUCCESS_MESSAGE("삭제가 완료되었습니다."),
    LIKE_MESSAGE("좋아요가 생성되었습니다."),
    UNLIKE_MESSAGE("좋아요가 취소되었습니다.");

    private final String successMessage;

    SuccessMessage(String successMessage) {
        this.successMessage = successMessage;
    }

    public String getSuccessMessage() {
        return "[SUCCESS] " + successMessage;
    }
}