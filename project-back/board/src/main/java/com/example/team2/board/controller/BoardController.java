package com.example.team2.board.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.team2.board.dto.request.board.PostBoardRequestDto;
import com.example.team2.board.dto.response.ResponseDto;
import com.example.team2.board.dto.response.board.PostBoardResponseDto;
import com.example.team2.board.service.BoardService;
import com.example.team2.board.common.constant.ApiPattern;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(description="게시글 모듈")
@RestController
@RequestMapping(ApiPattern.BOARD)
public class BoardController {
    
    @Autowired private BoardService boardService;

    private final String POST_BOARD = "";

    @ApiOperation(value="게시물 작성", notes="제목, 내용, 이미지를 전송하면 게시물 작성 결과로 작성된 게시물 정보를 반환, 실패시 실패 메시지를 반환")
    @PostMapping(POST_BOARD)
    public ResponseDto<PostBoardResponseDto> postBoard(
        @ApiParam(hidden=true)
        @AuthenticationPrincipal String email,
        @Valid @RequestBody PostBoardRequestDto requestBody
    ) {
        ResponseDto<PostBoardResponseDto> response = boardService.postBoard(email, requestBody);
        return response;
    }

    // public ResponseDto<PatchBoardResponseDto> patchBoard(

    // ) {
    //     ResponseDto<PatchBoardResponseDto> response = boardService.patchBoard(email,)
    // }
}
