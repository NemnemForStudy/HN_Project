package com.example.team2.board.dto.response.board;

import java.util.ArrayList;
import java.util.List;

import com.example.team2.board.entity.BoardEntity;
import com.example.team2.board.entity.CommentEntity;
import com.example.team2.board.entity.LikyEntity;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostBoardResponseDto {
    
    @ApiModelProperty(value="게시물 Entity", required=true)
    private BoardEntity board;
    
    @ApiModelProperty(value="댓글 Entity List", required=true)
    private List<CommentEntity> commentList;

    @ApiModelProperty(value="좋아요 Entity List", required=true)
    private List<LikyEntity> likeList;

    public PostBoardResponseDto(BoardEntity board) {
        this.board = board;
        this.commentList = new ArrayList<>();
        this.likeList = new ArrayList<>();
    }
}
