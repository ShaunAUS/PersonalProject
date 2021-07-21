package org.zerock.guestbook.service;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.guestbook.dto.GuestbookDTO;
import org.zerock.guestbook.dto.PageRequestDTO;
import org.zerock.guestbook.dto.PageResultDTO;
import org.zerock.guestbook.entity.Guestbook;

@SpringBootTest
public class GuestbookServiceTests {
    @Autowired
    private GuestbookService service;

    @Test
    public void testRegister() {

        //DTO 만든다
        GuestbookDTO guestbookDTO = GuestbookDTO.builder()
                .title("Sample Titile..")
                .content("Sample Content..")
                .writer("Sample Writer")
                .build();

        //DTO 를 ENTITY로 변환
        //인터페이스 호출= 형변환
        System.out.println(service.register((guestbookDTO)));
    }

    @Test
    public void testList() {


        //요구 request
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder().page(1).size(10).build();
        //결과 result, // getList = pageable 변환후 dto변환까지,페이징까지
        PageResultDTO<GuestbookDTO, Guestbook> resultDTO = service.getList(pageRequestDTO);

        //boolean   항목들 있나없나 체크
        System.out.println("PREV:" + resultDTO.isPrev());
        System.out.println("NEXT:" + resultDTO.isNext());
        System.out.println("total:" + resultDTO.getTotalPage());


        //page<Entity> -> DTO 정보 출력
        System.out.println("======================");
        for (GuestbookDTO guestbookDTO : resultDTO.getDtoList()) {
            System.out.println(guestbookDTO);


        //페이징 정보 출력
            System.out.println("=====================");
            resultDTO.getPageList().forEach(i -> System.out.println(i));
        }
    }
}
