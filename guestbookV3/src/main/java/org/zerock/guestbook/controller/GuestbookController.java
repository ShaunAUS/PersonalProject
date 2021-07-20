package org.zerock.guestbook.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.guestbook.dto.PageRequestDTO;
import org.zerock.guestbook.service.GuestbookService;

@Controller
@RequestMapping("/guestbook")
@Log4j2
@RequiredArgsConstructor //자동 주입을 위한 애노테이션
public class GuestbookController {

 private final GuestbookService service; // final 로 선언

    @GetMapping("/")
    public String index(){
     return "redirect:/guestbook/list";
    }
    
    
    //스프링 mvc 는  파라미터를 자동으로 수집해 주는 기능이 있으므로 화면에서 page와 size 라는 파라미터를
    //전달하면 PageRequestDTO 객체로 자동수집됀다
    @GetMapping("/list")
    public void list(PageRequestDTO pageRequestDTO, Model model){

     log.info("list....."+pageRequestDTO);

     model.addAttribute("result",service.getList(pageRequestDTO));
    }
}
