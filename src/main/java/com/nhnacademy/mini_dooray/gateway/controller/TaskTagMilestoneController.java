package com.nhnacademy.mini_dooray.gateway.controller;

import com.nhnacademy.mini_dooray.gateway.dto.manage.ManageListResponseDto;
import com.nhnacademy.mini_dooray.gateway.dto.milestone.MileStoneIndexListResponseDto;
import com.nhnacademy.mini_dooray.gateway.dto.tag.TaskManageListResponseDto;
import com.nhnacademy.mini_dooray.gateway.service.MileStoneService;
import com.nhnacademy.mini_dooray.gateway.service.TagService;
import com.nhnacademy.mini_dooray.gateway.service.TaskService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/projects/{projectId}/tasks/{taskId}/manage")
@Slf4j
public class TaskTagMilestoneController {

    private final TagService tagService;
    private final MileStoneService mileStoneService;
    private final TaskService taskService;


    public TaskTagMilestoneController(TagService tagService, MileStoneService mileStoneService, TaskService taskService) {
        this.tagService = tagService;
        this.mileStoneService = mileStoneService;
        this.taskService = taskService;
    }

    @GetMapping("/tag")
    public String showTaskTags(Model model, @PathVariable Long projectId, @PathVariable Long taskId) {
        try {
            model.addAttribute("projectId", projectId);
            model.addAttribute("taskId", taskId);

            TaskManageListResponseDto taskManageListResponseDto = tagService.showTaskTag(projectId,taskId);
            taskManageListResponseDto.getTaskTagList();

            model.addAttribute("taskTagList", taskManageListResponseDto.getTaskTagList());
            model.addAttribute("tagList", taskManageListResponseDto.getProjectTagList());
            return "taskTagManagement";
        } catch (Exception e) {
            log.error("error :{}", e.getMessage());
            return "redirect:/projects/" + projectId + "/tasks/" + taskId;
        }
    }

    @PostMapping("/tag/add")
    public String addTag(@PathVariable Long projectId, @PathVariable Long taskId, @RequestParam Long tagId) {
        try {
            tagService.addTaskTag(projectId, taskId, tagId);
            return "redirect:/projects/" + projectId + "/tasks/" + taskId;
        } catch (Exception e) {
            log.error("error :{}", e.getMessage());
            return "redirect:/projects/" + projectId + "/tasks/" + taskId + "/manage/tag";
        }
    }

    @PostMapping("/tag/delete/{tagId}")
    public String deleteTag(@PathVariable Long projectId, @PathVariable Long taskId, @PathVariable Long tagId) {
        try {
            tagService.deleteTaskTag(projectId, taskId, tagId);
            return "redirect:/projects/" + projectId + "/tasks/" + taskId;
        } catch (Exception e) {
            log.error("error :{}", e.getMessage());
            return "redirect:/projects/" + projectId + "/tasks/" + taskId + "/tag";
        }
    }

    @GetMapping("/milestone")
    public String addTaskMilestone(Model model, @PathVariable Long projectId, @PathVariable Long taskId) {
        try {
            model.addAttribute("projectId", projectId);
            model.addAttribute("taskId", taskId);
            ManageListResponseDto manageListResponseDto = tagService.manageList(projectId);
            List<MileStoneIndexListResponseDto> milestoneList = manageListResponseDto.getMilestoneList();
            model.addAttribute("milestoneList", milestoneList);
            return "newTaskMilestone";
        } catch (Exception e) {
            log.error("error :{}", e.getMessage());
            return "redirect:/projects/" + projectId + "/tasks/" + taskId;
        }
    }

    @PostMapping("/milestone/add")
    public String addMilestone(@PathVariable Long projectId, @PathVariable Long taskId, @RequestParam Long milestoneId) {
        log.info("milestoneId: {}", milestoneId);
        try {
            mileStoneService.addTaskMileStone(projectId, taskId, milestoneId);

            return "redirect:/projects/" + projectId + "/tasks/" + taskId;
        } catch (Exception e) {
            log.error("error :{}", e.getMessage());
            return "redirect:/projects/" + projectId + "/tasks/" + taskId + "/milestone";
        }
    }

    @PostMapping("/milestone/delete")
    public String deleteTaskMilestone(@PathVariable Long projectId, @PathVariable Long taskId, @RequestParam Long milestoneId) {
        try {
            mileStoneService.deleteTaskMileStone(projectId, taskId, milestoneId);
            return "redirect:/projects/" + projectId + "/tasks/" + taskId;
        } catch (Exception e) {
            log.error("error :{}", e.getMessage());
            return "redirect:/projects/" + projectId + "/tasks/" + taskId + "/milestone";
        }
    }
}
