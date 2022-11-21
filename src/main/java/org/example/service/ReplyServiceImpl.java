package org.example.service;

import org.example.domain.Reply;
import org.example.repository.ReplyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReplyServiceImpl implements ReplyService {

    private final ReplyMapper replyMapper;

    @Autowired
    public ReplyServiceImpl(ReplyMapper replyMapper) {
        this.replyMapper = replyMapper;
    }

    public Reply getReplyInfo(long ReplyId) {
        return replyMapper.getReplyById(ReplyId);
    }

    public void createReply(Reply reply) {
        replyMapper.create(reply);
    }



    public void updateReply(long ReplyId,Reply reply) {
        /*Reply replyTest= replyMapper.getReplyById(ReplyId);

        if(replyTest!=null){
            replyMapper.update(replyTest);
        }else{
            throw new IllegalStateException("회원이 존재하지 않습니다.");
        }*/
        replyMapper.update(reply);

    }

    public void deleteReply(long ReplyId) {
        if(replyMapper.getReplyById(ReplyId)!=null){
            replyMapper.delete(ReplyId);
        }else{
            throw new IllegalStateException("회원이 존재하지 않습니다");
        }
    }
}
