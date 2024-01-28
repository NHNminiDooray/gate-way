package com.nhnacademy.mini_dooray.gateway.controller;

import com.nhnacademy.mini_dooray.gateway.dto.manage.ManageListResponseDto;
import com.nhnacademy.mini_dooray.gateway.dto.milestone.MileStoneIndexListResponseDto;
import com.nhnacademy.mini_dooray.gateway.dto.tag.TagResponseDto;
import com.nhnacademy.mini_dooray.gateway.dto.task.TaskDetailResponseDto;
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
//      api 추가
            TaskDetailResponseDto taskDetailResponseDto = taskService.getTaskDetails(projectId, taskId);
            List<TagResponseDto> taskTagList = taskDetailResponseDto.getTagList();

            model.addAttribute("taskTagList", taskTagList);
            model.addAttribute("tagList", taskTagList);
            return "taskTagManagement";
        } catch (Exception e) {
            log.error("error :{}", e.getMessage());
            return "redirect:/projects/" + projectId + "/tasks" + taskId;
        }
    }

    @PostMapping("/tag/add")
    public String addTag(@PathVariable Long projectId, @PathVariable Long taskId, @RequestParam Long tagId) {
        try {
            tagService.addTaskTag(projectId, taskId, tagId);
            return "redirect:/projects/" + projectId + "/tasks/" + taskId;
        } catch (Exception e) {
            log.error("error :{}", e.getMessage());
            return "redirect:/projects/" + projectId + "/tasks" + taskId + "/tag";
        }
    }

    @DeleteMapping("/tag/delete/{tagId}")
    public String deleteTag(@PathVariable Long projectId, @PathVariable Long taskId, @PathVariable Long tagId) {
        try {
            tagService.deleteTaskTag(projectId, taskId, tagId);
            return "redirect:/projects/" + projectId + "/tasks/" + taskId;
        } catch (Exception e) {
            log.error("error :{}", e.getMessage());
            return "redirect:/projects/" + projectId + "/tasks" + taskId + "/tag";
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
            return "redirect:/projects/" + projectId + "/tasks" + taskId;
        }
    }

    @PostMapping("/milestone/add")
    public String addMilestone(@PathVariable Long projectId, @PathVariable Long taskId, @RequestParam Long mileStoneId) {
        try {
            mileStoneService.addTaskMileStone(projectId, taskId, mileStoneId);

            return "redirect:/projects/" + projectId + "/tasks/" + taskId;
        } catch (Exception e) {
            log.error("error :{}", e.getMessage());
            return "redirect:/projects/" + projectId + "/tasks" + taskId + "/milestone";
        }
    }

    @DeleteMapping("/milestone/delete")
    public String deleteTaskMilestone(@PathVariable Long projectId, @PathVariable Long taskId, @RequestParam Long mileStoneId) {
        try {
            mileStoneService.deleteTaskMileStone(projectId, taskId, mileStoneId);
            return "redirect:/projects/" + projectId + "/tasks/" + taskId;
        } catch (Exception e) {
            log.error("error :{}", e.getMessage());
            return "redirect:/projects/" + projectId + "/tasks" + taskId + "/milestone";
        }
    }
}
