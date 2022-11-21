package org.example.domain;



import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Board {

    private Long BoardId;
    private String BoardTitle;
    private String BoardContent;
    @DateTimeFormat(pattern = "yyyy-MM-dd")

    private Date BoardDate;
    private Long User_UserId;

    public Long getBoardId() {
        return BoardId;
    }

    public void setBoardId(Long boardId) {
        BoardId = boardId;
    }

    public String getBoardTitle() {
        return BoardTitle;
    }

    public void setBoardTitle(String boardTitle) {
        BoardTitle = boardTitle;
    }

    public String getBoardContent() {
        return BoardContent;
    }

    public void setBoardContent(String boardContent) {
        BoardContent = boardContent;
    }

    public Date getBoardDate() {
        return BoardDate;
    }

    public void setBoardDate(Date boardDate) {
        BoardDate = boardDate;
    }

    public Long getUser_UserId() {
        return User_UserId;
    }

    public void setUser_UserId(Long user_UserId) {
        User_UserId = user_UserId;
    }
}
