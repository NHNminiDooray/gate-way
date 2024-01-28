package com.nhnacademy.mini_dooray.gateway.controller;
import com.nhnacademy.mini_dooray.gateway.dto.comment.CommentResponseDto;
import com.nhnacademy.mini_dooray.gateway.service.CommentService;
import javax.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/projects/{projectId}/tasks/{taskId}/comment")
@Slf4j
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping
    public String addComment(@PathVariable Long projectId, @PathVariable Long taskId, @RequestParam String comment, HttpSession session, Model model) {
        try {
        String memberId = (String) session.getAttribute("memberId");
        commentService.addComment(projectId,taskId,memberId,comment);
        return "redirect:/projects/" + projectId + "/tasks/" + taskId;
        } catch (Exception e) {
            log.error("error :{}",e.getMessage());
            return "redirect:/member/create";
        }
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
        String memberId = (String) session.getAttribute("memberId");
        commentService.editComment(projectId,taskId,memberId,commentId,editedComment);
        return "redirect:/projects/" + projectId + "/tasks/" + taskId;
    }
    @DeleteMapping("/{commentId}/delete")
    public String deleteComment(@PathVariable Long projectId, @PathVariable Long taskId, @PathVariable Long commentId, Model model) {
        commentService.deleteComment(projectId,taskId,commentId);

        return "redirect:/projects/" + projectId + "/tasks/" + taskId;
    }
}
