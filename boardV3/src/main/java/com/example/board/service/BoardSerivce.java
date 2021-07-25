package com.example.board.service;

import com.example.board.dto.BoardDTO;
import com.example.board.dto.PageRequestDTO;
import com.example.board.dto.PageResultDTO;
import com.example.board.entity.Board;
import com.example.board.entity.Member;
import org.springframework.data.domain.PageRequest;

public interface BoardSerivce {

    //등록
    Long register(BoardDTO dto);

    //목록처리
    PageResultDTO<BoardDTO, Object[]> getList(PageRequestDTO pageRequest);
    //조회(=detail)
    BoardDTO get(Long bno);
    //삭제
    void removeWithReplies(Long bno);
    //수정
    void modify(BoardDTO boardDTO);






    //BoardDTO 는 member 엔티티와 + board 엔티티 를 구성해야함
    default Board dtoTOEntity(BoardDTO dto) {
        
        //member 엔티티   //writer 대신에 == writer name ,writer email
        Member member = Member.builder().email(dto.getWriterEmail()).build();
        
        //board 엔티티
        Board board=Board.builder()


                //board 엔티티(Board dto),       dto-> 엔티티
                .bno(dto.getBno())
                .title(dto.getTitle())
                .content(dto.getContent())
                .writer(member)   //fk //맴버 객체까지 끌어오니 맴버객체에 넣어서..
                .build();

        return board;
    };

    /*entity => DTO*/
    // 목록
    //보드, 맴버,  댓글
    default BoardDTO entityToDTO(Board board,Member member,Long replyCount){

        BoardDTO boardDTO=BoardDTO.builder()
                .bno(board.getBno())
                .title(board.getTitle())
                .content(board.getContent())
                .regDate(board.getRegDate())
                .modDate(board.getModDate())
                .writerEmail(member.getEmail())
                .writeName(member.getName())         //fk 로 memeber 객체 호출한다
                .replyCount(replyCount.intValue())   //long 으로 나오므로 int 로 처리하도록

                .build();

            return boardDTO;
    }


}
