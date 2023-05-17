package com.example.team2.board.service;

import com.example.team2.board.dto.request.auth.SignInDto;
import com.example.team2.board.dto.request.auth.SignUpDto;
import com.example.team2.board.dto.response.ResponseDto;
import com.example.team2.board.dto.response.auth.SignInResponseDto;
import com.example.team2.board.dto.response.auth.SignUpResponseDto;

public interface AuthService {
    
    public ResponseDto<SignUpResponseDto> signUp(SignUpDto dto);
    public ResponseDto<SignInResponseDto> signIn(SignInDto dto);
    
}
