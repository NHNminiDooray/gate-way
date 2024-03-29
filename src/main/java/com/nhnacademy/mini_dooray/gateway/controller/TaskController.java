package com.nhnacademy.mini_dooray.gateway.controller;

import com.nhnacademy.mini_dooray.gateway.dto.task.TaskDetailResponseDto;
import com.nhnacademy.mini_dooray.gateway.dto.task.TaskIndexListResponseDto;
import com.nhnacademy.mini_dooray.gateway.security.Member;
import com.nhnacademy.mini_dooray.gateway.service.TaskService;
import java.util.List;
import javax.servlet.http.HttpSession;
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
            log.info("projectId : {}", projectId);
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
    public String createTaskSave(Model model, @PathVariable Long projectId, @RequestParam String taskTitle, @RequestParam String taskContent,
                                 HttpSession session) {
        try {
            Member member = (Member) session.getAttribute("member");
            taskService.createTask(projectId, taskTitle, taskContent, member.getMemberId());
            model.addAttribute("projectId", projectId);
            return "redirect:/projects/" + projectId + "/tasks";
        } catch (Exception e) {
            log.error("error :{}", e.getMessage());
            return "redirect:/projects/" + projectId + "/tasks/create";
        }
    }

    @GetMapping("/{taskId}")
    public String showTaskDetails(Model model, @PathVariable Long projectId, @PathVariable Long taskId , HttpSession session) {
        try {
            TaskDetailResponseDto taskDetail = taskService.getTaskDetails(projectId, taskId);
            Member member = (Member) session.getAttribute("member");

            model.addAttribute("loginMemberId", member.getMemberId());
            model.addAttribute("taskDetails", taskDetail);
            return "taskdetails";
        } catch (Exception e) {
            log.error("error :{}", e.getMessage());
            return "redirect:/projects/" + projectId + "/tasks";
        }
    }
}
