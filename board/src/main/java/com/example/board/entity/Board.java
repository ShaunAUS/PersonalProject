package com.example.board.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class Board extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bno;

    private String title;

    private String content;
    
    
    //jpa에서 관계 고민할떄는 fk쪽을 먼저해석, 
    //이 애노테이션은 데이터베이스상에서 외래키의 관계로 연결된 엔티티 클래스에 설정한다
    //join= fk쪽의 엔티티가져올떄 pk 쪽엔티티도 가져온다
    // fetch= 연관관계 데이터 어떻게 가져올까. Eager= 연관관계가 있는 모든 엔티티, lazy= 그반대
    @ManyToOne(fetch=FetchType.LAZY)
    private Member writer;

}
