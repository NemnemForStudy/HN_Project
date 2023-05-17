package com.example.team2.board.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.team2.board.common.constant.ResponseMessage;
import com.example.team2.board.dto.request.board.PostBoardRequestDto;
import com.example.team2.board.dto.response.ResponseDto;
import com.example.team2.board.dto.response.board.PostBoardResponseDto;
import com.example.team2.board.entity.BoardEntity;
import com.example.team2.board.entity.UserEntity;
import com.example.team2.board.repository.BoardRepository;
import com.example.team2.board.repository.UserRepository;
import com.example.team2.board.service.BoardService;


@Service
public class BoardServiceImplements implements BoardService {

    @Autowired private BoardRepository boardRepository;
    @Autowired private UserRepository userRepository;

    public ResponseDto<PostBoardResponseDto> postBoard(String email, PostBoardRequestDto dto){

        PostBoardResponseDto data = null;

        try {

            UserEntity userEntity = userRepository.findByEmail(email);
            if(userEntity == null) return ResponseDto.setFailed(ResponseMessage.NOT_EXIST_USER);

            BoardEntity boardEntity = new BoardEntity(userEntity, dto);
            boardRepository.save(boardEntity);

            data = new PostBoardResponseDto(boardEntity);

        } catch(Exception exception) {
            exception.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }

        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);
    }
}
