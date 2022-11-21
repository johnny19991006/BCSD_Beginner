package org.example.controller;

import org.example.domain.Board;
import org.example.domain.User;
import org.example.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/boards")
public class BoardController {
    private final BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @PostMapping()
    public String createBoard(@RequestBody Board board) {
        boardService.createBoard(board);
        return "create Board";
    }

    @RequestMapping(value = "/{BoardId}", method = RequestMethod.GET)
    public Board boardInfo(@PathVariable("BoardId") Long BoardId) {
        return boardService.getBoardInfo(BoardId);
    }


    @PutMapping("/{BoardId}")
    public String updateBoard(@PathVariable Long BoardId, @RequestBody Board board){
        boardService.updateBoard(BoardId,board);
        return "update Board";
    }

    @DeleteMapping("/{BoardId}")
    public String deleteBoard(@PathVariable Long BoardId){
        boardService.deleteBoard(BoardId);
        return "delete Board";
    }
}

