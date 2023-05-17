package com.example.team2.board.dto.response.auth;

import com.example.team2.board.entity.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignInResponseDto {
    private String email;
    private String nickname;
    private String password;
    private String telnumber;
    private String profileUrl;
    private String token;
    private int expiredTime;

    public SignInResponseDto(UserEntity userEntity, String token) {
        this.email = userEntity.getEmail();
        this.nickname = userEntity.getNickname();
        this.password = userEntity.getPassword();
        this.telnumber = userEntity.getTelnumber();
        this.profileUrl = userEntity.getProfileUrl();
        this.token = token;
        this.expiredTime = 3600000;
    }
}
