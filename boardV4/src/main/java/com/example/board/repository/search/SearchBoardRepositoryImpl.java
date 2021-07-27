package com.example.board.repository.search;

import com.example.board.entity.Board;
import com.example.board.entity.QBoard;
import com.example.board.entity.QMember;
import com.example.board.entity.QReply;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.JPQLQuery;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

@Log4j2
public class SearchBoardRepositoryImpl extends QuerydslRepositorySupport implements  SearchBoardRepository{


    //생성자가 존재하므로 클래스 내에서 super 를 이용해 호출해야한다
    public SearchBoardRepositoryImpl() {
        super(Board.class);
    }


    @Override
    public Board search1() {

        log.info("serarch1 .........");

        // q도메인생성
        QBoard board=QBoard.board;
        QReply reply=QReply.reply;
        QMember member= QMember.member;


        //쿼리생성 board를 기준으로// 테이블 붙이기
        JPQLQuery<Board> jpqlQuery = from(board);
        jpqlQuery.leftJoin(member).on(board.writer.eq(member));
        jpqlQuery.leftJoin(reply).on(reply.board.eq(board));

        //쿼리문 실행, select
        // 엔티티객체 다윈가 아니라  각각의 데이터를 추출하는 경우에 tuple 객체를 이용
        JPQLQuery<Tuple> tuple=jpqlQuery.select(board,member.email,reply.count());

        tuple.groupBy(board);




        log.info("=============");
        log.info(tuple);
        log.info("=============");

        List<Board> result= jpqlQuery.fetch();

        return null;
    }


    //JPOQLQuery    + pageable
    @Override
    public Page<Object[]> searchPage(String type, String keyword, Pageable pageable) {

        log.info("searchPage............");


        // q도메인생성
        QBoard board=QBoard.board;
        QReply reply=QReply.reply;
        QMember member= QMember.member;


        //쿼리생성 board를 기준으로// 테이블 붙이기
        JPQLQuery<Board> jpqlQuery = from(board);
        jpqlQuery.leftJoin(member).on(board.writer.eq(member));
        jpqlQuery.leftJoin(reply).on(reply.board.eq(board));

        //select
        JPQLQuery<Tuple> tuple=jpqlQuery.select(board,member.email,reply.count());


        //검색조건 시작
        BooleanBuilder booleanBuilder=new BooleanBuilder();
        BooleanExpression expression=board.bno.gt(0l);

        booleanBuilder.and(expression);

        if(type != null){
            String[] typeArr= type.split("");
            //검색 조건을 작성하기
            BooleanBuilder conditionBuilder=new BooleanBuilder();
            // title, content, writer
            for (String t:typeArr){
                switch (t){
                    case "t":
                        conditionBuilder.or(board.title.contains(keyword));
                        break;
                    case "w":
                        conditionBuilder.or(member.email.contains(keyword));
                        break;
                    case "c":
                        conditionBuilder.or(board.content.contains(keyword));
                        break;
                }
            } //bno 가 0이상이면서 + type조건
            booleanBuilder.and(conditionBuilder);
        }

        tuple.where(booleanBuilder);

        tuple.groupBy(board);

        //쿼리문 실행
        List<Tuple> result=tuple.fetch();

        log.info(result);

        return null;
    }
}
