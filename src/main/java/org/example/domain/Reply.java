package org.example.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Reply {
    private Long ReplyId;

    private String ReplyContent;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ReplyDate;
    private Long ReplyLike;
    private Long Board_BoardId;
    private Long User_UserId;

    public Long getReplyId() {
        return ReplyId;
    }

    public void setReplyId(Long replyId) {
        ReplyId = replyId;
    }

    public String getReplyContent() {
        return ReplyContent;
    }

    public void setReplyContent(String replyContent) {
        ReplyContent = replyContent;
    }

    public Date getReplyDate() {
        return ReplyDate;
    }

    public void setReplyDate(Date replyDate) {
        ReplyDate = replyDate;
    }

    public Long getReplyLike() {
        return ReplyLike;
    }

    public void setReplyLike(Long replyLike) {
        ReplyLike = replyLike;
    }

    public Long getBoard_BoardId() {
        return Board_BoardId;
    }

    public void setBoard_BoardId(Long board_BoardId) {
        Board_BoardId = board_BoardId;
    }

    public Long getUser_UserId() {
        return User_UserId;
    }

    public void setUser_UserId(Long user_UserId) {
        User_UserId = user_UserId;
    }
}
