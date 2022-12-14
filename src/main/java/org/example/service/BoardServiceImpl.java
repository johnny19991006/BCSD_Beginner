package org.example.service;

import org.example.domain.Board;
import org.example.repository.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService {

    private final BoardMapper boardMapper;

    @Autowired
    public BoardServiceImpl(BoardMapper boardMapper) {
        this.boardMapper = boardMapper;
    }

    public Board getBoardInfo(long BoardId) {
        return boardMapper.getBoardById(BoardId);
    }

    public void createBoard(Board board) {
        boardMapper.create(board);
    }

    public void updateBoard(long BoardId, Board updateBoard) {
        Board boardTest= boardMapper.getBoardById(BoardId);

        if(boardTest!=null){

            boardTest.setBoardTitle(updateBoard.getBoardTitle());
            boardTest.setBoardDate(updateBoard.getBoardDate());
            boardTest.setBoardContent(updateBoard.getBoardContent());
            boardTest.setUser_UserId(updateBoard.getUser_UserId());
            boardMapper.update(boardTest);
        }else {
            throw new IllegalStateException("회원이 존재하지 않습니다.");
        }

    }

    public void deleteBoard(long BoardId) {
        if(boardMapper.getBoardById(BoardId)!=null){
            boardMapper.delete(BoardId);
        }else{
            throw new IllegalStateException("회원이 존재하지 않습니다");
        }
    }
}

