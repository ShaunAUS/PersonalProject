package com.example.board.repository;


import com.example.board.entity.Board;
import com.example.board.entity.Reply;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
public class ReplyRepositoryTests {

    @Autowired
    ReplyRepository replyRepository;

    @Test
    public void insertReply(){

        IntStream.rangeClosed(1,100).forEach(i->{

            long bno=(long)(Math.random()*100)+1;


            //board pk 값 여기서는 fk
            Board board= Board.builder().bno(bno).build();

            Reply reply =Reply.builder()
                    .text("Reply..."+i)
                    .board(board)      // //board pk 값 여기서는 fk
                    .replyer("guest")
                    .build();

            replyRepository.save(reply);
        });
    }
    @Test
    public void testReply1(){

        Optional<Reply> result=replyRepository.findById(1L); //데이터 베이스에 존재하는 번호

        Reply reply=result.get();

        System.out.println(reply);
        System.out.println(reply.getBoard());
    }



}
