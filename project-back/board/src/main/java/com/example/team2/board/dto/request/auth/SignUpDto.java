package com.example.team2.board.dto.request.auth;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SignUpDto {
    
    @NotBlank
    @Email
    @Length(max=45)
    private String email;
    
    @NotBlank
    @Length(min=8, max=30)
    private String password;

    @NotBlank
    @Length(min=11, max=13)
    private String telnumber;

    @NotBlank
    @Length(min=3, max=20)
    private String nickname;

}
