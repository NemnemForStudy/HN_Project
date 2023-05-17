package com.example.team2.board.service;

import com.example.team2.board.dto.request.board.PostBoardRequestDto;
import com.example.team2.board.dto.response.ResponseDto;
import com.example.team2.board.dto.response.board.PostBoardResponseDto;

public interface BoardService {

    public ResponseDto<PostBoardResponseDto> postBoard(String email, PostBoardRequestDto dto);
    
}
