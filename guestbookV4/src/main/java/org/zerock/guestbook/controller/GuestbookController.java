package org.zerock.guestbook.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.guestbook.dto.GuestbookDTO;
import org.zerock.guestbook.dto.PageRequestDTO;
import org.zerock.guestbook.service.GuestbookService;

@Controller
@RequestMapping("/guestbook")
@Log4j2
@RequiredArgsConstructor //자동 주입을 위한 애노테이션
public class GuestbookController {

 private final GuestbookService service; // final 로 선언

   /* @GetMapping("/")
    public String index(){
     return "redirect:/guestbook/list";
    }*/
    
    
    //스프링 mvc 는  파라미터를 자동으로 수집해 주는 기능이 있으므로 화면에서 page와 size 라는 파라미터를
    //전달하면 PageRequestDTO 객체로 자동수집됀다
    @GetMapping("/list")
    public void list(@ModelAttribute("pageRequestDTO") PageRequestDTO pageRequestDTO, Model model){

     log.info("list....."+pageRequestDTO);

     model.addAttribute("result",service.getList(pageRequestDTO));
    }



    @GetMapping("/register")
    public void register(){
        log.info("register get....");
    }

    @PostMapping("/register")
    public String registerPost(GuestbookDTO dto, RedirectAttributes redirectAttributes){
        log.info("dto..."+dto);
        //새로 추가된 엔티티의 번호
        Long gno=service.register(dto);
        //새로추가된 엔티티번호// 나중에 글등록후 나오는 모달창// 번호가있으면 뜨고 없으면 안뜬다
        // ' 한번만 ' 화면에서 사용 가능 = session
        redirectAttributes.addFlashAttribute("msg",gno);

        //등록처리후 목록화면으로 이동
        return "redirect/guestbook/list";
    }


    //detail 페이지
    //detail 페이지 안에서 수정, 삭제 리스트(목록 되돌아가기) 버튼
    @GetMapping({"/read","/modify"})
    public void read(long gno,@ModelAttribute("requestDTO")PageRequestDTO requestDTO,Model model){

            log.info("gno:"+gno);

            GuestbookDTO dto =service.read(gno);

            //read   or  modify 페이지로던진다
            model.addAttribute("dto",dto);
    }

    @GetMapping("/remove")
    public String remove(long gno, RedirectAttributes redirectAttributes){

        log.info("gno:"+gno);

        service.remove(gno);

        redirectAttributes.addFlashAttribute("msg",gno);

        return "redirect:/guestbook/list";
    }

    /* 수정은   get방식 /guestbook/modify ,  post방식 /guestbook/modify 있다*/
    //수정후
    @PostMapping("/modify")
    public String modify(GuestbookDTO dto,@ModelAttribute("requestDTO") PageRequestDTO requestDTO, RedirectAttributes redirectAttributes){

        log.info("dto:"+dto);

        service.modify(dto);

                                            //수정후  read페이지로 가도 페이지번호,키워드,타입, 유지
        redirectAttributes.addAttribute("page",requestDTO.getPage());
        redirectAttributes.addAttribute("type",requestDTO.getType());
        redirectAttributes.addAttribute("keyword",requestDTO.getKeyword());

        redirectAttributes.addAttribute("gno",dto.getGno());


        return "redirect:/guestbook/read";
    }
}
