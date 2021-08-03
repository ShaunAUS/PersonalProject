package com.example.Todo.service;


import com.example.Todo.entity.TodoEntity;
import com.example.Todo.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// 등록, 리스트, 수정, 삭제
@Service
public class TodoService {

    @Autowired
    private ToDoRepository service;

    //등록
    public void register(TodoEntity todoEntity){

        service.save(todoEntity);
    }



    //리스트

    public List<TodoEntity> list(){

        List<TodoEntity> result =service.findAll();

        return result;
    }




    //수정

    public void update(TodoEntity todoEntity){

        Optional<TodoEntity> result = service.findById(todoEntity.getId());

        if(result.isPresent()){

            TodoEntity entity=result.get();


            entity.changeContent(todoEntity.getContent());


            service.save(entity);
        }

    }



    //삭제
    public void delete(long id){

        service.deleteById(id);
    }

}
