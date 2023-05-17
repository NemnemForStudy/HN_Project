package com.example.team2.board.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.team2.board.common.constant.ResponseMessage;
import com.example.team2.board.dto.request.auth.SignInDto;
import com.example.team2.board.dto.request.auth.SignUpDto;
import com.example.team2.board.dto.response.ResponseDto;
import com.example.team2.board.dto.response.auth.SignInResponseDto;
import com.example.team2.board.dto.response.auth.SignUpResponseDto;
import com.example.team2.board.entity.UserEntity;
import com.example.team2.board.provider.TokenProvider;
import com.example.team2.board.repository.UserRepository;
import com.example.team2.board.service.AuthService;

@Service
public class AuthServiceImplements implements AuthService {
    
    @Autowired private TokenProvider tokenProvider;
    @Autowired private UserRepository userRepository;

    //? Spring Security 프레임워크에서 제공하는 클래스로 비밀번호를 암호화 하는 데에 사용
    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public ResponseDto<SignUpResponseDto> signUp(SignUpDto dto) {

        SignUpResponseDto data = null;

        String email = dto.getEmail();
        String telnumber = dto.getTelnumber();
        String password = dto.getPassword();

        try {

            boolean hasEmail = userRepository.existsByEmail(email);
            if(hasEmail) return ResponseDto.setFailed(ResponseMessage.EXIST_EMAIL);

            boolean hasTelnumber = userRepository.existsByTelnumber(telnumber);
            if(hasTelnumber) return ResponseDto.setFailed(ResponseMessage.EXIST_TELNUMBER);

            String encodedPassword = passwordEncoder.encode(password);
            dto.setPassword(encodedPassword);

            UserEntity userEntity = new UserEntity(dto);
            userRepository.save(userEntity);

            data = new SignUpResponseDto(true);

        } catch(Exception exception) {
            exception.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }
        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);
    }

    public ResponseDto<SignInResponseDto> signIn(SignInDto dto) {

        SignInResponseDto data = null;

        String email = dto.getEmail();
        String password = dto.getPassword();

        UserEntity userEntity = null;

        try {

            userEntity = userRepository.findByEmail(email);
            if(userEntity == null) return ResponseDto.setFailed(ResponseMessage.FAIL_SIGN_IN);

            boolean isEqualPassword = passwordEncoder.matches(password, userEntity.getPassword());
            if(!isEqualPassword) return ResponseDto.setFailed(ResponseMessage.FAIL_SIGN_IN);

        } catch(Exception exception) {
            exception.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        } 

        try {
            String token = tokenProvider.create(email);
            data = new SignInResponseDto(userEntity, token);

        } catch(Exception exception) {
            exception.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.FAIL_SIGN_IN);
        }
        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);
    }
}
