package com.example.board.repository;

import com.example.board.dto.BoardDTO;
import com.example.board.entity.Board;
import com.example.board.entity.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
public class BoardRepositoryTests {


    @Autowired
    private BoardRepository boardRepository;

    @Test
    public void insertBoard(){

        IntStream.rangeClosed(1,100).forEach(i->{

            //member pk 값 여기서는 fk
            Member member=Member.builder().email("user"+i+"@aaa.com").build();

            Board board= Board.builder()
                    .title("Title...."+i)
                    .content("Content..."+i)
                    .writer(member)         //member pk 값 여기서는 fk //멤버 객체도 불러온다
                    .build();

            boardRepository.save(board);
        });
    }
    
    //left outer join 실행된다
    //member 가 Board에 붙는다
    @Transactional
    @Test
    public void testRead1(){
        
        Optional<Board> result=boardRepository.findById(100L); //데이터 베이스에 존재하는 번호

         Board board=result.get();

        System.out.println(board);

        //memeber 테이블고 join 부분,
        //fetchType =lazy 이면 @Transactional 선언해야함 , 안그러면 48번에 멈춤,
        //데이터베익스 다시연결 하기 위해 @Transactional 선언
        System.out.println(board.getWriter());
    }

    @Test
    public void testReadWithWriter(){
        
        //@Query = 현재 필요한 데이터만을 Object[] 형태로 추출할수 있다
        Object result=boardRepository.getBoardWithWriter(100L);
        
        //결과 2개니까 배열
        Object[] arr =(Object[])result;
        
        System.out.println("--------");
        System.out.println(Arrays.toString(arr));
    }

    @Test
     public void testGetBoardWithReply(){

    List<Object[]> result=boardRepository.getBoardWithWriter(100L);

    for(Object[] arr : result){
        System.out.println(arr);
    }

    }

    @Test
    public void testWithReplyCount() {

        Pageable pageable = PageRequest.of(0, 10, Sort.by("bno").descending());

        Page<Object[]> result = boardRepository.getBoardWithReplyCount(pageable);

        result.get().forEach(row -> {

            Object[] arr = (Object[]) row;

            System.out.println(Arrays.toString(arr));

        });

    }
    @Test
    public void testRead3 () {

        Object result = boardRepository.getBoardByBno(100L);

        Object[] arr = (Object[]) result;

        System.out.println(Arrays.toString(arr));
    }




}