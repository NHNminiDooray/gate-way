package com.nhnacademy.mini_dooray.gateway.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/projects/{projectId}/tasks/{taskId}/manage")
public class TaskTagMilestoneController {
    @GetMapping("/tag")
    public String showTaskTags(Model model, @PathVariable Long projectId, @PathVariable Long taskId) {
        model.addAttribute("projectId",projectId);
        model.addAttribute("taskId",taskId);
        //TODO
        //테스크 안의 태그 리스트(삭제 하기 위함) 및 모든 태그 리스트 (추가 하기 위함)
//        model.addAttribute("taskTagList",taskTagList);
//        model.addAttribute("tagList",tagList);
        return  "taskTagManagement";
    }
    @PostMapping("/tag/add")
    public String addTag(@PathVariable Long projectId, @PathVariable Long taskId, @RequestParam Long tagId) {
        //TODO
        // 테스크 안의 태그 추가 로직

        return "redirect:/projects/" + projectId + "/tasks/" + taskId;
    }
    @DeleteMapping("/tag/delete/{tagId}")
    public String deleteTag(@PathVariable Long projectId, @PathVariable Long taskId, @PathVariable Long tagId) {
        //TODO
        // 테스크 안의 태그 삭제 로직

        return "redirect:/projects/" + projectId + "/tasks/" + taskId;
    }
    @GetMapping("/milestone")
    public String addTaskMilestone(Model model, @PathVariable Long projectId, @PathVariable Long taskId) {
        model.addAttribute("projectId",projectId);
        model.addAttribute("taskId",taskId);
        //TODO
        // 프로젝트의 모든 마일스톤 리스트
        //model.addAttribute("milestoneList",milestoneList);
        return  "newTaskMilestone";
    }
    @PostMapping("/milestone/add")
    public String addMilestone(@PathVariable Long projectId, @PathVariable Long taskId) {
        //TODO
        // 테스크 안의 마일스톤 추가 로직

        return "redirect:/projects/" + projectId + "/tasks/" + taskId;
    }
    @DeleteMapping("/milestone/delete")
    public String deleteTaskMilestone(@PathVariable Long projectId, @PathVariable Long taskId) {
        //TODO
        // 테스크 안의 마일스톤 삭제 로직

        return "redirect:/projects/" + projectId + "/tasks/" + taskId;
    }
}
