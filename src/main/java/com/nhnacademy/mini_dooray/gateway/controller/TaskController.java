package com.nhnacademy.mini_dooray.gateway.controller;

import com.nhnacademy.mini_dooray.gateway.dto.task.TaskIndexListResponseDto;
import com.nhnacademy.mini_dooray.gateway.dto.task.TaskRequestDto;
import com.nhnacademy.mini_dooray.gateway.service.TaskService;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/projects/{projectId}/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }


    @GetMapping
    public String showTaskList(Model model, @PathVariable Long projectId) {

        TaskRequestDto taskRequestDto;
        List<TaskIndexListResponseDto> taskList = taskService.getAllTasks(new TaskRequestDto());

        model.addAttribute("projectId", projectId);
        model.addAttribute("taskList", taskList);

        return "taskList";
    }
    @GetMapping("/{taskId}")
    public String showTaskDetails(Model model, @PathVariable Long projectId, @PathVariable Long taskId) {

        //taskId로 TaskDetailResponseDto 받아서 모델로 넘겨주세영
//        model.addAttribute("taskDetails", taskDetails);

        return "taskdetails";
    }
}
