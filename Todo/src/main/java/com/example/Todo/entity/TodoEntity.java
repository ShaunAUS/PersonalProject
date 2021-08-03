package com.example.Todo.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

    @Entity
    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    @Table(name="TodoTable")
    public class TodoEntity {


        @Id
        @Column
        @GeneratedValue(strategy= GenerationType.IDENTITY) //auto increment
        private Long id;

        @Column(name="content",length=200,nullable=false)
        private String content;

        @Column(name="writer",length=50,nullable=false)
        private String wirter;



        @CreationTimestamp  //생성하는 시간
        @Column(name="create_time",updatable=false)
        private LocalDateTime createTime;


        public void changeContent(String content){
            this.content=content;
        }



    }












