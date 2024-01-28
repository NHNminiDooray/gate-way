package com.nhnacademy.mini_dooray.gateway.controller;

import com.nhnacademy.mini_dooray.gateway.dto.task.TaskIndexListResponseDto;
import com.nhnacademy.mini_dooray.gateway.service.TaskService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/projects/{projectId}/tasks")
@Slf4j
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public String showTaskList(Model model, @PathVariable Long projectId) {
        try {
            //TODO
            //오류
            List<TaskIndexListResponseDto> taskList = taskService.getAllTasks(projectId);
            model.addAttribute("projectId", projectId);
            model.addAttribute("taskList", taskList);

            return "taskList";
        } catch (Exception e) {
            log.error("error :{}", e.getMessage());
            return "redirect:/projects";
        }
    }

    @GetMapping("/create")
    public String createTask(Model model, @PathVariable Long projectId) {
        model.addAttribute("projectId", projectId);
        return "newtask";
    }

    @PostMapping("/create")
    public String createTaskSave(Model model, @PathVariable Long projectId, @RequestParam String taskTitle, @RequestParam String taskContent) {
        try {
            //TODO
            //업무 등록 누락으로 인한 오류
            //save Task
            model.addAttribute("projectId", projectId);
            return "newtask";
        } catch (Exception e) {
            log.error("error :{}", e.getMessage());
            return "redirect:/projects/" + projectId + "/tasks";
        }
    }

    @GetMapping("/{taskId}")
    public String showTaskDetails(Model model, @PathVariable Long projectId, @PathVariable Long taskId) {
        try {
            //TODO

            return "taskdetails";
        } catch (Exception e) {
            log.error("error :{}", e.getMessage());
            return "redirect:/projects/" + projectId + "/tasks";
        }
    }
}
