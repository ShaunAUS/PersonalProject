package org.zerock.guestbook.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


//DTO = 목적자체가 데이터 전달 , 일회성
//단점은 엔티티와 유사한 코드중복, 엔티티를 DTO로  DTO를 엔티티로 변환하는 과정 필요
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class GuestbookDTO {

    private Long gno;
    private String title;
    private String content;
    private String writer;
    private LocalDateTime regDate, modDate;

}
