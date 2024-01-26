package com.nhnacademy.mini_dooray.gateway.controller;

import com.nhnacademy.mini_dooray.gateway.dto.task.TaskIndexListResponseDto;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/projects/{projectId}/tasks")
public class TaskController {
    @GetMapping
    public String showTaskList(Model model, @PathVariable Long projectId) {
//        List<Task> taskList = service.getTaskList();
        List<TaskIndexListResponseDto> taskList = List.of(
                new TaskIndexListResponseDto(1L,"qwe"),
                new TaskIndexListResponseDto(2L,"asd"),
                new TaskIndexListResponseDto(3L,"zxc")
        );

        model.addAttribute("projectId", projectId);
        model.addAttribute("taskList", taskList);

        return "taskList";
    }
}
