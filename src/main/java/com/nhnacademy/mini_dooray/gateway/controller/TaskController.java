package com.nhnacademy.mini_dooray.gateway.controller;

import com.nhnacademy.mini_dooray.gateway.dto.task.TaskDetailResponseDto;
import com.nhnacademy.mini_dooray.gateway.dto.task.TaskIndexListResponseDto;
import com.nhnacademy.mini_dooray.gateway.dto.task.TaskRequestDto;
import com.nhnacademy.mini_dooray.gateway.service.TaskService;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/projects/{projectId}/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public String showTaskList(Model model, @PathVariable Long projectId) {
        List<TaskIndexListResponseDto> taskList =taskService.getAllTasks(projectId);
        model.addAttribute("projectId", projectId);
        model.addAttribute("taskList", taskList);

        return "taskList";
    }
    @GetMapping("/{taskId}")
    public String showTaskDetails(Model model, @PathVariable Long projectId, @PathVariable Long taskId) {
        TaskDetailResponseDto task =  taskService.getTaskDetails(projectId,taskId);
        model.addAttribute("task", task);
        return "taskdetails";
    }
    //todo
}
