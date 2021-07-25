package com.example.board.service;


import com.example.board.dto.BoardDTO;
import com.example.board.entity.Board;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BoardServiceTest {

    @Autowired
    private BoardSerivce boardSerivce;

    @Test
    public void testRegister(){


        BoardDTO dto=BoardDTO.builder()
                .title("test")
                .content("test content")
                .writerEmail("user@naver.com")  //현재 데이터베이스에 존재하는 회원 이메일

                .build();

        //게시물 번호 반환
        Long bno=boardSerivce.register(dto);
    }

    @Test
    public void testGet(){

        Long bno= 100L;

        BoardDTO boardDTO=boardSerivce.get(bno);

        System.out.println(boardDTO);
    }

    @Test
    public void testRemove(){

        Long bno= 1L;

        boardSerivce.removeWithReplies(bno);
    }

    @Test
    public void testModify(){

        BoardDTO boardDTO= BoardDTO.builder()
                .bno(2L)
                .title("제목 변경합니다")
                .content("내용 변경합니다")
                .build();
    }
}
