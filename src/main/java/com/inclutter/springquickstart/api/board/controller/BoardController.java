package com.inclutter.springquickstart.api.board.controller;

import com.inclutter.springquickstart.api.board.model.BoardDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class BoardController {
    /** 토큰 암호 키 */
    @Value("#{systemProperties['token.encrypt.key']}")
    private String secretKey;

    public BoardController() {
        System.out.println("===> BoardCOntroller 생성");
    }

    @GetMapping("/hello")
    public String hello(String name) {
        if(secretKey.equals("abcd1234")){
            System.out.println("====> secretKey : " + secretKey);
        }
        return "Hello : " + name;
    }

    @GetMapping("/boards/get")
    public BoardDTO getBoard() {
        BoardDTO board = new BoardDTO();
        board.setSeq(1);
        board.setTitle("테스트 제목....");
        board.setWriter("테스터");
        board.setContent("테스트 내용입니다..........");
        board.setCreateDate(new Date());
        board.setCnt(0);
        return board;
    }

    @GetMapping("/boards")
    public List<BoardDTO> getBoardList() {
        List<BoardDTO> boardList = new ArrayList<BoardDTO>();
        for (int i = 0; i <= 10; i++) {
            BoardDTO board = new BoardDTO();
            board.setSeq(i);
            board.setTitle("제목" + i);
            board.setWriter("테스터");
            board.setContent(i + "번 내용입니다.");
            board.setCreateDate(new Date());
            board.setCnt(0);
            boardList.add(board);
        }
        return boardList;
    }

}
