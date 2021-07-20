package org.zerock.guestbook.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;


//클라로부터 요청, JPA로 보내야하니 그쪽에서 사용하는 Pageable 타입의 객체 생성이 목적이다
@Builder
@AllArgsConstructor
@Data
public class PageRequestDTO {

    private int page;
    private int size;


    public PageRequestDTO(){
        this.page=1;
        this.size=10;
    }
    
    //JPA 에서 사용하는 Pageable 타입의 객체로 변환
        public Pageable getPageable(Sort sort){

        return PageRequest.of(page-1,size,sort);
    }
}
