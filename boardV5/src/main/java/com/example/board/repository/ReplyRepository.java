package com.example.board.repository;

import com.example.board.entity.Reply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ReplyRepository extends JpaRepository<Reply,Long> {


    @Modifying //delete 와 update에는 항상써준다
    @Query("delete from Reply r where r.board.bno=:bno")
    void deleteByBno(Long bno);

}
