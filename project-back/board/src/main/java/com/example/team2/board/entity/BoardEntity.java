package com.example.team2.board.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="Board")
@Table(name="Board")
public class BoardEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int BoardNumber;
    private String boardTitle;
    private String boardContent;
    private String boardImgUrl;
    private String boardWriteDatetime;
    private String writerId;
    private String writerProfileUrl;
    private String writerBickname;
    private int viewCount;
    private int commentCount;
}
