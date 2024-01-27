package com.nhnacademy.mini_dooray.gateway.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/projects/{projectId}/tasks/{taskId}/manage")
public class TaskTagMilestoneController {
    @GetMapping("/tag")
    public String showTaskTags(Model model, @PathVariable Long projectId, @PathVariable Long taskId) {
        model.addAttribute("projectId",projectId);
        model.addAttribute("taskId",taskId);
        return  "";
    }
    @PostMapping("/milestone/delete")
    public String deleteTag(@PathVariable Long projectId, @PathVariable Long taskId) {
        //TODO
        // 테스크 안의 태그 삭제 로직

        return "redirect:/projects/" + projectId + "/tasks/" + taskId;
    }
    @GetMapping("/milestone")
    public String showTaskMilestone(Model model, @PathVariable Long projectId, @PathVariable Long taskId) {
        model.addAttribute("projectId",projectId);
        model.addAttribute("taskId",taskId);
        return  "";
    }

    @PostMapping("/milestone/delete")
    public String deleteMilestone(@PathVariable Long projectId, @PathVariable Long taskId) {
        //TODO
        // 테스크 안의 마일스톤 삭제 로직

        return "redirect:/projects/" + projectId + "/tasks/" + taskId;
    }
}
