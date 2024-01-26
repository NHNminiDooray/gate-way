package com.nhnacademy.mini_dooray.gateway.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class ProjectndexListController {
//    private ProjectService projectService;

    @GetMapping
    public String showProjects(Model model) {
//        List<ProjectIndexListRequestDto> projectList = projectService.getAllProjects();
//        model.addAttribute("projectList", projectList);
        return "projectList";
    }
//    @GetMapping("/create")
//    public String showProjectCreationForm() {
//        return "newproject";
//    }
}
