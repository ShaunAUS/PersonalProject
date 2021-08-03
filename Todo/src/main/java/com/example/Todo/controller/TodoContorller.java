package com.example.Todo.controller;

import com.example.Todo.entity.TodoEntity;
import com.example.Todo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("/Todo")
@RequiredArgsConstructor //자동 주입을 위한 애노테이션
public class TodoContorller {

    @Autowired
    private final TodoService service;




    @PostMapping("/update")
    public String update(TodoEntity todoEntity){

        service.update(todoEntity);

        return "redirect/Todo/list";
    }


    //목록
    @GetMapping({"/list","/home"})
    public void list(Model model){

        List<TodoEntity> result = service.list();

        model.addAttribute("result",result);

    }


    //삭제
    @PostMapping("/delete")
    public String delete(long id){

        service.delete(id);

        return "redirect/Todo/list";
    }


    //등록
    //GET방식으로 보기
    @GetMapping("/register")
    public void register(){


    }

    //POST로 데이터 전달
    @PostMapping("/register")
    public String registerPost(TodoEntity todoEntity){

        service.register(todoEntity);

        //등록처리후 목록화면으로 이동
        return "redirect/Todo/list";
    }
    
}
