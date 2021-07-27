package com.example.board.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
@Builder
@AllArgsConstructor   //매개변수로 받는 생성자
@NoArgsConstructor    //매개변수 없는 생성자
@Getter
@ToString
public class Member extends BaseEntity {

    @Id  // pk값
    private String email;

    private String password;

    private String name;
}
