package com.nhnacademy.mini_dooray.gateway.controller;

import com.nhnacademy.mini_dooray.gateway.dto.project.ProjectIndexListResponseDto;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/projects")
public class ProjectndexListController {
//    private ProjectService projectService;

    @GetMapping
    public String showProjects(Model model) {

//        ProjectIndexListResponseDto projectList = projectService.getAllProjects();

        List<ProjectIndexListResponseDto> projectIndexList = List.of(new ProjectIndexListResponseDto(1L, "qwe"), new ProjectIndexListResponseDto(2L, "asd"), new ProjectIndexListResponseDto(3L, "zxc"));
        model.addAttribute("projectIndexList", projectIndexList);
        return "projectList";
    }
}
