package com.nhnacademy.mini_dooray.gateway.controller;
import com.nhnacademy.mini_dooray.gateway.dto.comment.CommentResponseDto;
import com.nhnacademy.mini_dooray.gateway.security.Member;
import com.nhnacademy.mini_dooray.gateway.service.CommentService;
import java.time.LocalDateTime;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/projects/{projectId}/tasks/{taskId}/comment")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping
    public String addComment(@PathVariable Long projectId, @PathVariable Long taskId, @RequestParam String comment, HttpSession session, Model model) {
        Member member = (Member) session.getAttribute("member");

        commentService.addComment(projectId,taskId,member.getMemberId(),comment);
        return "redirect:/projects/" + projectId + "/tasks/" + taskId;
    }
    @GetMapping("/{commentId}/edit")
    public String showCommentEditForm(@PathVariable Long projectId, @PathVariable Long taskId, @PathVariable Long commentId, Model model) {
        model.addAttribute("projectId",projectId);
        model.addAttribute("taskId",taskId);
        model.addAttribute("commentId",commentId);
        return "commentEditForm";
    }
    @PostMapping("/{commentId}/edit")
    public String editComment(@PathVariable Long projectId, @PathVariable Long taskId, @PathVariable Long commentId, @RequestParam String editedComment,HttpSession session, Model model) {
        Member member = (Member) session.getAttribute("member");
        commentService.editComment(projectId,taskId,commentId,member.getMemberId(),commentId,editedComment);
        return "redirect:/projects/" + projectId + "/tasks/" + taskId;
    }
    @PostMapping("/{commentId}/delete")
    public String deleteComment(@PathVariable Long projectId, @PathVariable Long taskId, @PathVariable Long commentId, Model model) {
        commentService.deleteComment(projectId,taskId,commentId);

        return "redirect:/projects/" + projectId + "/tasks/" + taskId;
    }
}
