package com.example.team2.board.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import com.example.team2.board.dto.request.board.PostCommentRequestDto;

import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="Comment")
@Table(name="Comment")

public class CommentEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int commentNumber;
    private String commentContent;
    private String writeDatetime;
    private int boardNumber;
    private String writerId;
    private String writerProfileUrl;
    private String writerNickname;

    public CommentEntity(UserEntity userEntity, PostCommentRequestDto dto) {
        Date now = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        this.commentContent = dto.getCommentContent();
    }
}
