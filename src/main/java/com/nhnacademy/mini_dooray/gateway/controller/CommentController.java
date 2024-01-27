package com.nhnacademy.mini_dooray.gateway.controller;
import com.nhnacademy.mini_dooray.gateway.dto.comment.CommentResponseDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/projects/{projectId}/tasks/{taskId}/comment")
public class CommentController {
    @PostMapping
    public String addComment(@PathVariable Long projectId, @PathVariable Long taskId, @RequestParam String comment, Model model) {

        //TODO
        return "redirect:/projects/" + projectId + "/tasks/" + taskId;
    }
    @GetMapping("/{commentId}/edit")
    public String showCommentEditForm(@PathVariable Long projectId, @PathVariable Long taskId, @PathVariable Long commentId, Model model) {
        model.addAttribute("projectId",projectId);
        model.addAttribute("taskId",taskId);

        //TODO
        CommentResponseDto comment = new CommentResponseDto(commentId,"commentWriteMemberId","qwe");

        model.addAttribute("comment",comment);
        return "commentEditForm";
    }
    @PostMapping("/{commentId}/edit")
    public String editComment(@PathVariable Long projectId, @PathVariable Long taskId, @PathVariable Long commentId, @RequestParam String editedComment, Model model) {

        //TODO

        return "redirect:/projects/" + projectId + "/tasks/" + taskId;
    }
    @DeleteMapping("/{commentId}/delete")
    public String deleteComment(@PathVariable Long projectId, @PathVariable Long taskId, @PathVariable Long commentId, Model model) {
        //TODO
        return "redirect:/projects/" + projectId + "/tasks/" + taskId;
    }
}
