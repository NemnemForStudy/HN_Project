package com.example.team2.board.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.team2.board.dto.request.board.PostBoardRequestDto;
import com.example.team2.board.dto.response.ResponseDto;
import com.example.team2.board.service.BoardService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;

@Api(description="게시글 모듈")
@RestController
@RequestMapping(ApiPattern.BOARD)
public class BoardController {
    
    @Autowired private BoardService boardService;

    public ResponseDto<PostBoardResponseDto> postBoard(
        @ApiParam(hidden=true)
        @AuthenticationPrincipal String email,
        @Valid @RequestBody PostBoardRequestDto requestBody
    ) {
        ResponseDto<PostBoardResponseDto> response = boardService.postBoard(email, requestBody);
        return response;
    }
}
