package org.zerock.guestbook.repository;

//기본엔티티 ,쿼리dsl 테스트 페이지
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.zerock.guestbook.entity.Guestbook;
import org.zerock.guestbook.entity.QGuestbook;
import org.zerock.guestbook.repsoitory.GuestbookRepository;

import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
public class GuestbookRepositoryTests {

    @Autowired  //JpaReopsitory 구현한 인터페이스 연결 // jpa 기능들을 써보는 공간이다
    private GuestbookRepository guestbookRepository;

    @Test
    public void insertDummies(){
        IntStream.rangeClosed(1,300).forEach(i->{

            Guestbook guestbook= Guestbook.builder()
                    .title("Title.."+i)
                    .content("Content.."+i)
                    .writer("user"+(i%10))
                    .build();
                    System.out.println(guestbookRepository.save(guestbook));

        });
    }
    
    //엔티티 테스트
    //BaseEntity 의 modDate 마지막수정시간 반영이라 save해야 반영됌
    @Test
    public void updateTest(){
        
        //JPA 를 구현한 인터페이스를 통해 jpa 기본기능  '조회' 기능
        Optional<Guestbook> result = guestbookRepository.findById(300L);
        
        //조회결과 있으면
        if(result.isPresent()){
            
            Guestbook guestbook=result.get();
            
            //조건에 해당하는 데이터 변경
            guestbook.changeTitle("Changed Title...");
            guestbook.changeContent("Changed Content...");
            
            //메서드후 바뀐결과를 jpa기본기능 save로 저장
            guestbookRepository.save(guestbook);
        }
    }
    //쿼리dsl 테스트
    //단일 항목 검색 테스트
    @Test
    public void testQuery1(){


        Pageable pageable= PageRequest.of(0,1, Sort.by("gno").descending());
        
        //q도메인클래스 얻어온다=엔티티클래스에 선언된 title,content,같은 컬럼들 변수로 사용가능
        QGuestbook qGuestbook= QGuestbook.guestbook;
    
        String keyword="1";

        //BooleanBuilder =  컨테이너
        BooleanBuilder builder=new BooleanBuilder();
        //BooleanExpression= 메인조건문//      필드 변수로 사용해서 검색 //where조건문
        BooleanExpression expression = qGuestbook.title.contains(keyword);
        
        //메인조건문과 where조건문(컨테이너) 합친다
        builder.and(expression);
        //findAll=정렬,페이지 처리
        Page<Guestbook> result=guestbookRepository.findAll(builder,pageable);

        result.stream().forEach(guestbook->{
            System.out.println(guestbook);
        });
    }
    //쿼리dsl 테스트
    //다중항목 테스트
    @Test
    public void testQuery2(){


        Pageable pageable= PageRequest.of(0,1, Sort.by("gno").descending());

        //q도메인클래스 얻어온다=엔티티클래스에 선언된 title,content,같은 컬럼들 변수로 사용가능
        QGuestbook qGuestbook= QGuestbook.guestbook;

        String keyword="1";

        //BooleanBuilder = 조건문이들어가는 컨테이너
        BooleanBuilder builder=new BooleanBuilder();
        //BooleanExpression= 조건문//      필드 변수로 사용해서 검색
        //조건 1
        BooleanExpression exTitle = qGuestbook.title.contains(keyword);
        //조건 2
        BooleanExpression exContent = qGuestbook.content.contains(keyword);
        //조건 총합
        BooleanExpression exAll =exTitle.or(exContent);
        
        //builder + 조건총합
        builder.and(exAll);
        //조건 추가
        builder.and(qGuestbook.gno.gt(0L));

        //findAll=정렬,페이지 처리
        Page<Guestbook> result=guestbookRepository.findAll(builder,pageable);

        result.stream().forEach(guestbook->{
            System.out.println(guestbook);
        });
    }
}
