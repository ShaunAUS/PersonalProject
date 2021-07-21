package org.zerock.guestbook.service;


import org.zerock.guestbook.dto.GuestbookDTO;
import org.zerock.guestbook.dto.PageRequestDTO;
import org.zerock.guestbook.dto.PageResultDTO;
import org.zerock.guestbook.entity.Guestbook;


public interface GuestbookService {


    //등록
    Long register(GuestbookDTO dto);
    //목록
    PageResultDTO<GuestbookDTO,Guestbook>getList(PageRequestDTO requestDTO);
    //조회 Detail
    GuestbookDTO read(Long gno);
    //삭제
    void remove(Long gno);
    //수정
    void modify(GuestbookDTO dto);
    
    
    
    
    
    
    //인터페이스의 실제내용을 가지는 코드= default선언
    //DTO ->ENTITY
    default Guestbook dtoToEntity(GuestbookDTO dto){
        Guestbook entity= Guestbook.builder()
                .gno(dto.getGno())
                .title(dto.getTitle())
                .content(dto.getContent())
                .writer(dto.getWriter())
                .build();
                return entity;

    }


    //page<entity> ->  Entity->DTO 로 변환
    default GuestbookDTO entityToDto(Guestbook entity){

        GuestbookDTO dto = GuestbookDTO.builder()
                .gno(entity.getGno())
                .title(entity.getTitle())
                .content(entity.getContent())
                .writer(entity.getWriter())
                .regDate(entity.getRegDate())
                .modDate(entity.getModDate())
                .build();

                return dto;

    }
}
