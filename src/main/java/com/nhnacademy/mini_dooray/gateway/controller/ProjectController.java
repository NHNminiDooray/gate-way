package com.nhnacademy.mini_dooray.gateway.controller;

import com.nhnacademy.mini_dooray.gateway.dto.project.ProjectIndexListRequestDto;
import com.nhnacademy.mini_dooray.gateway.dto.project.ProjectIndexListResponseDto;
import com.nhnacademy.mini_dooray.gateway.dto.project.ProjectRegisterRequestDto;
import com.nhnacademy.mini_dooray.gateway.dto.project_member.ProjectMemberRequestDto;
import com.nhnacademy.mini_dooray.gateway.exception.DuplicateMemberException;
import com.nhnacademy.mini_dooray.gateway.service.ProjectService;
import java.util.List;
import javax.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/projects/register")
@Slf4j
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping
    public String showProjects(Model model, HttpSession session) {
        String memberId = (String) session.getAttribute("memberId");
        List<ProjectIndexListResponseDto> projectList = projectService.getAllProjects(new ProjectIndexListRequestDto(memberId));
        model.addAttribute("projectList", projectList);
        return "projectList";
    }
    @GetMapping("/create")
    public String showProjectRegistrationForm(Model model) {
        return "newproject";
    }

    @PostMapping
    public String registerProject(Model model,
                                  @RequestParam Long projectStatusId,
                                  @RequestParam String projectName,
                                  @RequestParam String memberId1,
                                  @RequestParam String memberId2,
                                  @RequestParam String memberId3) {

        try {
            if (memberId1.equals(memberId2) || memberId1.equals(memberId3) || memberId2.equals(memberId3)) {
                throw new DuplicateMemberException("멤버는 중복될 수 없습니다.");
            }
            ProjectRegisterRequestDto requestDto =
                    new ProjectRegisterRequestDto(
                            projectStatusId,
                            projectName,
                            List.of(new ProjectMemberRequestDto(memberId1,"멤버"),
                                    new ProjectMemberRequestDto(memberId2,"멤버"),
                                    new ProjectMemberRequestDto(memberId3,"멤버")));
            log.info("projectRegisterResponseDto : {}", requestDto);

            projectService.registerProject(requestDto);

            return "redirect:/projects";
        } catch (DuplicateMemberException e) {
            return "redirect:/projects/register";
        }
    }
}