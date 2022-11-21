package org.example.controller;


import org.example.domain.Reply;
import org.example.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/replys")
public class ReplyController {
    private final ReplyService replyService;

    @Autowired
    public ReplyController(ReplyService replyService) {
        this.replyService = replyService;
    }

    @RequestMapping(value = "/{ReplyId}", method = RequestMethod.GET)
    public Reply replyInfo(@PathVariable("ReplyId") Long ReplyId) {
        return replyService.getReplyInfo(ReplyId);
    }

    @PostMapping()
    public String createReply(@RequestBody Reply reply) {
        replyService.createReply(reply);
        return "create Reply";
    }

    @PutMapping("/{ReplyId}")
    public String updateReply(@PathVariable Long ReplyId, @RequestBody Reply reply){
        replyService.updateReply(ReplyId,reply);
        return "update Reply";
    }

    @DeleteMapping("/{ReplyId}")
    public String deleteReply(@PathVariable Long ReplyId){
        replyService.deleteReply(ReplyId);
        return "delete Reply";
    }
}
