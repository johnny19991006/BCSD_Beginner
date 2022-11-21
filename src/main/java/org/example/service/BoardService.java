package org.example.service;

import org.example.domain.Board;


public interface BoardService {
    Board getBoardInfo(long BoardId);

    void createBoard(Board board);

    void updateBoard(long boardId, Board board);

    void deleteBoard(long boardId);
}
