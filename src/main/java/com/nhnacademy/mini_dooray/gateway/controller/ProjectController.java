package com.nhnacademy.mini_dooray.gateway.controller;

import com.nhnacademy.mini_dooray.gateway.domain.ProjectDto;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class ProjectController {
//    private ProjectService projectService;

    @GetMapping
    public String showProjects(Model model) {
//        List<ProjectDto> projectList = projectService.getAllProjects();
//        model.addAttribute("projectList", projectList);
        return "projectList";
    }
//    @GetMapping("/create")
//    public String showProjectCreationForm() {
//        return "newproject";
//    }
}
