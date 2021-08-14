package com.example.board.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor

// Board entity + Member entity
public class BoardDTO {

    private Long bno;

    private String title;

    private String content;

    private String  writerEmail;     //작성자 이메일(id)

    private String  writeName;      //작성자 이름

    private LocalDateTime regDate;

    private LocalDateTime  modDate;

    private int replyCount;  //헤당 게시글 댓글 수



}
