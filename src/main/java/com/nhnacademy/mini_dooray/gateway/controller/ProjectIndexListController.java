package com.nhnacademy.mini_dooray.gateway.controller;

import com.nhnacademy.mini_dooray.gateway.dto.project.ProjectIndexListRequestDto;
import com.nhnacademy.mini_dooray.gateway.dto.project.ProjectIndexListResponseDto;
import com.nhnacademy.mini_dooray.gateway.service.ProjectService;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class ProjectIndexListController {

    private final ProjectService projectService;

    public ProjectIndexListController(ProjectService projectService) {
        this.projectService = projectService;
    }


    @GetMapping
    public String showProjects(Model model, HttpSession session) {
        String memberId = (String) session.getAttribute("memberId");
        List<ProjectIndexListResponseDto> projectList = projectService.getAllProjects(new ProjectIndexListRequestDto(memberId));
        model.addAttribute("projectList", projectList);
        return "projectList";
    }

}
