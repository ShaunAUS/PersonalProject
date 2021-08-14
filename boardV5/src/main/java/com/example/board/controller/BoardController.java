package com.example.board.controller;


import com.example.board.dto.BoardDTO;
import com.example.board.dto.PageRequestDTO;
import com.example.board.service.BoardSerivce;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/board")
@Log4j2
@RequiredArgsConstructor
public class BoardController {

    private final BoardSerivce boardSerivce;

    //리스트 목록 Get
    @GetMapping("/list")
    public void list (PageRequestDTO pageRequestDTO, Model model){

            log.info("list......"+ pageRequestDTO);

            model.addAttribute("result", boardSerivce.getList(pageRequestDTO));
    }

    //등록  Get. Post
    @GetMapping("/register")
    public void register(){
        log.info("register get.l....");
    }

    @PostMapping("/register")
    public String registerPost(BoardDTO dto, RedirectAttributes redirectAttributes){

        log.info("dto...."+dto);
        
        
        //새로 추가된 엔티티의 번호 //저장하고 게시물 번호 반환
        Long bno = boardSerivce.register(dto);

        log.info("BNO:"+ bno);

        //리다이렉트 하는 뷰단에서 쓸값 넣기,  일회용
        redirectAttributes.addFlashAttribute("msg",bno);

        return "redirect:/board/list";
    }
    
    //조회 , 디테일페이지
    @GetMapping({"/read","/modify"})
    public void read(@ModelAttribute("requestDTO")PageRequestDTO pageRequestDTO,Long bno, Model model){

        log.info("bno:"+ bno);

        BoardDTO boardDTO = boardSerivce.get(bno);

        log.info(boardDTO);

        model.addAttribute("bto", boardDTO);


    }

    @PostMapping("/remove")
    public String remove(long bno,RedirectAttributes redirectAttributes){

        log.info("bno"+bno);

        boardSerivce.removeWithReplies(bno);

        redirectAttributes.addFlashAttribute("msg",bno);

        return "redirect:/board/list";
    }

    @PostMapping("/modify")
    public String modify(BoardDTO dto,@ModelAttribute("requestDTO")PageRequestDTO requestDTO, RedirectAttributes redirectAttributes){

        log.info("post modify.............");
        log.info("dto:"+dto);

        redirectAttributes.addAttribute("page",requestDTO.getPage());
        redirectAttributes.addAttribute("type",requestDTO.getType());
        redirectAttributes.addAttribute("keyword",requestDTO.getKeyword());

        redirectAttributes.addAttribute("bno",dto.getBno());

        return"redirect:/board/read";

    }


}
