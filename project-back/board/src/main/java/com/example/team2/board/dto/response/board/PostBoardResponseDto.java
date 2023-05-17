package com.example.team2.board.dto.response.board;

import com.example.team2.board.entity.BoardEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostBoardResponseDto {
    
    private BoardEntity board;
    private List<CommentEntity> commentList;
}
