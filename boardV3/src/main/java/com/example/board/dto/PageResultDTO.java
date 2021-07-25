package com.example.board.dto;


import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


@Data
//                        =<DTO,Entity>
public class PageResultDTO<DTO,EN> {
    
    //메인정보//DTO 리스트//DTO 타입으로 저장한다// 리스트 검색 총 결과넵
    private List<DTO> dtoList;

    //--------페이징정보------
    //총페이지 번호
    private int totalPage;
    //현재 페이지 번호
    private int page;
    //목록 사이즈
    private int size;
    //시작 페이지 번호, 끝 페이지 번호
    private int start,end;
    //이전, 다음
    private  boolean prev,next;

    // 페이지 번호 , 목록
    private List<Integer> pageList;

// Function<EN,DTO> =  JPA 에서 나온 Entity들을  DTO로 변환해준다
    //service.getList = 총결과
    public PageResultDTO(Page<EN> result, Function<EN,DTO> fn){


        //page<Entity> ->DTO
        dtoList=result.stream().map(fn).collect(Collectors.toList());



        //===========--------page-------------------------
        //JPA에서 나온결과(=클라요청페이지).getTotalPages
        totalPage= result.getTotalPages();
        makePageList(result.getPageable());
    }
    
    private void makePageList(Pageable pageable){
        
        this.page=pageable.getPageNumber()+1; // 0부터 시작하므로 1을 추가한다
        this.size=pageable.getPageSize();

        //temp end page
        //보이는 끝페이지
        int tempEnd=(int)(Math.ceil(page/10.0))*10;

        start = tempEnd-9;
        
        //이전페이지 조건
        prev = start>1;

        end =totalPage>tempEnd ? tempEnd: totalPage;
        
        //다음페이지 조건
        next = totalPage>tempEnd;

        pageList= IntStream.rangeClosed(start,end).boxed().collect(Collectors.toList());
    }

}
