package com.example.team2.board.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.team2.board.dto.request.auth.SignUpDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="User")
@Table(name="User")
public class UserEntity {

    @Id
    private String email;
    private String password;
    private String nickname;
    private String telnumber;
    private String profileUrl;

    public UserEntity(SignUpDto dto) {
        this.email = dto.getEmail();
        this.password = dto.getPassword();
        this.nickname = dto.getNickname();
        this.telnumber = dto.getTelnumber();
    }
}
