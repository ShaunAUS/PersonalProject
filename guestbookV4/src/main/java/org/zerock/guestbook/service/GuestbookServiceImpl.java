package org.zerock.guestbook.service;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
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
import org.zerock.guestbook.entity.QGuestbook;
import org.zerock.guestbook.repsoitory.GuestbookRepository;

import java.util.Optional;
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
    //리스트+검색
    //entity->dto
    @Override
                        //DTO, entity
    public PageResultDTO<GuestbookDTO, Guestbook> getList(PageRequestDTO requestDTO) {


        //클라로부터 온 요구사항(페이징,정렬) dto를 -> pageable타입으로 변환
        //=Pageable pageabe= PageRequest.of(0,10,sort)
        Pageable pageable =requestDTO.getPageable(Sort.by("gno").descending());
        
        
        BooleanBuilder booleanBuilder=getSearch(requestDTO); //검색조건

        //페이징,정렬= finall // 반환 타입 page<entity>
        //클라로부터 온 요청 결과값=jpa에서 나온 결과값(entity)
        //pageable 타입 파라미터 finall 에 넣으면 쿼리실행
        //Page<Guestbook> result=repository.findAll(pageable);
        
        //Querydsl 사용 (검색결과) 후 리스트페이지
        Page<Guestbook> result=repository.findAll(booleanBuilder,pageable);
        
        //Guestbook(entity) 를 넣으면 GuestbookDTO(DTO) 로나온다
        Function<Guestbook, GuestbookDTO> fn =(entity-> entityToDto(entity));


        return new PageResultDTO<>(result,fn);
    }

    @Override
    public GuestbookDTO read(Long gno) {
        //findById 반환값= Optionl타입
       Optional<Guestbook> result=repository.findById(gno);
        //클라한테 보여줄떄는 dto로
       return result.isPresent()?entityToDto(result.get()):null;
    }

    @Override
    public void remove(Long gno) {

        repository.deleteById(gno);
    }

    @Override
    public void modify(GuestbookDTO dto) {

        //업데이트 항목은 '제목' , '내용'
        //해당 글을 불러온다//=디테일 페이지(read)
        Optional<Guestbook> result= repository.findById(dto.getGno());

        if(result.isPresent()){
            //결과 엔티티에 담고
            Guestbook entity=result.get();
            //수정하고
            entity.changeTitle(dto.getContent());
            entity.changeContent(dto.getContent());
            //저장한다
            repository.save(entity);
        }

    }


    private BooleanBuilder getSearch(PageRequestDTO requestDTO){

        String type=requestDTO.getType();  //검색조건 = title, content, writer

        BooleanBuilder booleanBuilder=new BooleanBuilder();     //조건문 담을 컨테이너 생성

        QGuestbook qGuestbook=QGuestbook.guestbook;       //큐 도메인 생성
        
        //검색어
        String keyword =requestDTO.getKeyword();

        BooleanExpression expression=qGuestbook.gno.gt(0L); // gno>0 조건문(기본)
        
        booleanBuilder.and(expression); //  컨테이너에 조건문 담기

        if(type==null || type.trim().length()==0){         //조건문이  널이거나 0이면(없으면)

            return booleanBuilder;
        }

        //검색 조건 작성

        BooleanBuilder conditionBuilder = new BooleanBuilder();  // 컨테이너 2
        
        //제목으로검색
        //type = 제목,작성자, 내용 에 keyword로 검색
        if(type.contains("t")){
            conditionBuilder.or(qGuestbook.title.contains(keyword));
        }
        // 내용으로검색

        if(type.contains("c")){
            conditionBuilder.or(qGuestbook.content.contains(keyword));
        }
        // 작성자로검색

        if(type.contains("w")){
            conditionBuilder.or(qGuestbook.writer.contains(keyword));
        }

        //모든 조건 통합
        // 컨테이너 1 + 컨테이너 2
        booleanBuilder.and(conditionBuilder);

        return booleanBuilder;


    }
}
