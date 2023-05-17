package com.example.team2.board.common.constant;

public interface ResponseMessage {
    public static final String SUCCESS = "Success";
    public static final String DATABASE_ERROR = "Database error";

    public static final String EXIST_EMAIL = "이미 존재하는 이메일입니다.";
    public static final String EXIST_TELNUMBER = "이미 존재하는 전화번호입니다.";

    public static final String NOT_EXIST_USER = "존재하지 않는 유저입니다.";

    public static final String FAIL_SIGN_IN = "로그인에 실패했습니다.";
}
