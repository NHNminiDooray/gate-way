package com.nhnacademy.mini_dooray.gateway.controller;

import com.nhnacademy.mini_dooray.gateway.dto.task.TaskDetailResponseDto;
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
        log.info("projectId : {}", projectId);
        //TODO
        //오류
        List<TaskIndexListResponseDto> taskList = taskService.getAllTasks(projectId);
        log.info("taskList : {}", taskList);
        model.addAttribute("projectId", projectId);
        model.addAttribute("taskList", taskList);

        return "taskList";
    }

    @GetMapping("/create")
    public String createTask(Model model, @PathVariable Long projectId) {
        model.addAttribute("projectId", projectId);
        return "newtask";
    }
    @PostMapping("/create")
    public String createTaskSave(Model model, @PathVariable Long projectId, @RequestParam String taskTitle, @RequestParam String taskContent) {
        //TODO
        //업무 등록 누락으로 인한 오류
        model.addAttribute("projectId", projectId);
        return "newtask";
    }
    @GetMapping("/{taskId}")
    public String showTaskDetails(Model model, @PathVariable Long projectId, @PathVariable Long taskId) {
        return "taskdetails";
    }
}
