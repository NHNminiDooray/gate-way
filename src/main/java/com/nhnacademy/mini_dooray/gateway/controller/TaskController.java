package com.nhnacademy.mini_dooray.gateway.controller;

import com.nhnacademy.mini_dooray.gateway.dto.task.TaskIndexListResponseDto;
import com.nhnacademy.mini_dooray.gateway.dto.task.TaskRequestDto;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/projects/{projectId}/tasks")
@Slf4j
public class TaskController {
    @GetMapping
    public String showTaskList(Model model, @PathVariable Long projectId, @PathVariable Long taskId) {
//        List<Task> taskList = service.getTaskList();
        List<TaskIndexListResponseDto> taskList = List.of(
                new TaskIndexListResponseDto(1L,"qwe"),
                new TaskIndexListResponseDto(2L,"asd"),
                new TaskIndexListResponseDto(3L,"zxc")
        );

        model.addAttribute("projectId", projectId);
        model.addAttribute("taskId", taskId);
        model.addAttribute("taskList", taskList);

        return "taskList";
    }
    @GetMapping("/create")
    public String showTaskForm(Model model, @PathVariable Long projectId) {
        model.addAttribute("projectId", projectId);
        return "newtask";
    }
    @PostMapping("/create")
    public String createTask(TaskRequestDto taskRequestDto) {
        log.info("TaskRequestDto : {}",taskRequestDto);
        //taskWriteMemberId가 현재는 널, (로그인 세션에서 받음>?>)
//        taskService.createTask(taskCreateRequestDto);

        return "redirect:/projects/{projectId}/tasks";
    }
}
