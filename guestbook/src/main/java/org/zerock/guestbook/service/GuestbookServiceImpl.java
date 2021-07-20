package org.zerock.guestbook.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.zerock.guestbook.dto.GuestbookDTO;
import org.zerock.guestbook.dto.PageRequestDTO;
import org.zerock.guestbook.dto.PageResultDTO;
import org.zerock.guestbook.entity.Guestbook;
import org.zerock.guestbook.repsoitory.GuestbookRepository;

import java.util.function.Function;


@Service  //스프링에서 bean으로 처리돼도록
@Log4j2
@RequiredArgsConstructor // 의존성 자동 주입
public class GuestbookServiceImpl implements GuestbookService{

    
    private final GuestbookRepository repository; // 반드시 final 로 선언한다
    
    @Override
    public Long register(GuestbookDTO dto) {

        log.info("DTO--------");
        log.info(dto);
        //DTO 로 정보를 전달받고
        //DTO->Entity 로 변환 , JPA 쓰기위해
        Guestbook entity=dtoToEntity(dto);

        log.info(entity);
        
        
        //JPA를 통해 DB저장
        repository.save(entity);

        //PK값 반환
        return entity.getGno();
    }

    //entity->dto
    @Override
                        //DTO, entity
    public PageResultDTO<GuestbookDTO, Guestbook> getList(PageRequestDTO requestDTO) {


        //클라로부터 온 요구사항(페이징,정렬) dto를 -> pageable타입으로 변환
        //=Pageable pageabe= PageRequest.of(0,10,sort)
        Pageable pageable =requestDTO.getPageable(Sort.by("gno").descending());

        //페이징,정렬= finall // 반환 타입 page<entity>
        //클라로부터 온 요청 결과값=jpa에서 나온 결과값(entity)
        //pageable 타입 파라미터 finall 에 넣으면 쿼리실행
        Page<Guestbook> result=repository.findAll(pageable);
        
        
        //Guestbook(entity) 를 넣으면 GuestbookDTO(DTO) 로나온다
        Function<Guestbook, GuestbookDTO> fn =(entity-> entityToDto(entity));


        return new PageResultDTO<>(result,fn);
    }
}
