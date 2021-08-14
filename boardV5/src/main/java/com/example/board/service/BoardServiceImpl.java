package com.example.board.service;

import com.example.board.dto.BoardDTO;

import com.example.board.dto.PageRequestDTO;
import com.example.board.dto.PageResultDTO;
import com.example.board.entity.Board;
import com.example.board.entity.Member;
import com.example.board.repository.BoardRepository;
import com.example.board.repository.ReplyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.function.Function;


@Service
@RequiredArgsConstructor
@Log4j2
public class BoardServiceImpl implements BoardSerivce {

    private final BoardRepository repository;     //자동주입 final
    private final ReplyRepository replyRepository;


    @Override
    public Long register(BoardDTO dto) {

        log.info(dto);
        
        
        //BoardDTO -> BoardEntity  // 엔티티로 바꿔야 JPA SAVE사용가능
        Board board= dtoTOEntity(dto);
        //저장하고
        repository.save(board);
        //게시물 번호 반환
        return board.getBno();
    }

    @Override
    public PageResultDTO<BoardDTO, Object[]> getList(PageRequestDTO pageRequestDTO) {

        log.info(pageRequestDTO);
        
        //entity ->dto
        //@Query 리턴값은 Object[]
        Function<Object[],BoardDTO> fn =(en->entityToDTO((Board)en[0],(Member)en[1],(Long)en[2]));


        //기본정렬,페이징+ 테이블3개합친(멤버,보드,댓글)== jpa에서 나온 entity들이다
        //getBoardWithReplyCount(Pageable)
        //@Query 리턴값은 Object[]
        Page<Object[]> result=repository.getBoardWithReplyCount(pageRequestDTO.getPageable(Sort.by("bno").descending()));


        return new PageResultDTO<>(result,fn);
    }

    @Override
    public BoardDTO get(Long bno) {

        // 게시물번호로 특정 디테일 페이지 조회 = 배열로 결과값 나온다
        //@Query 반환타입=  object[]
        Object result=repository.getBoardByBno(bno);

        Object[] arr= (Object[]) result;

        return entityToDTO((Board)arr[0], (Member)arr[1],(Long)arr[2]);

        
    }
    //댓글부터 삭제 하고 게시물삭제
    // 하나의 메서드로 묶음
    @Transactional
    @Override
    public void removeWithReplies(Long bno) {
        
        //댓글부터 삭제
        replyRepository.deleteByBno(bno);

        //jpa 기본 기능 //삭제
        repository.deleteById(bno);
    }

    @Override
    public void modify(BoardDTO boardDTO) {

        Board board=repository.getOne(boardDTO.getBno());

            board.changeTitle(boardDTO.getTitle());
            board.changeContent(boardDTO.getContent());

            repository.save(board);
    }


}
