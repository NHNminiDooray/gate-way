package com.nhnacademy.mini_dooray.gateway.controller;

import com.nhnacademy.mini_dooray.gateway.dto.member.MemberIdsDto;
import com.nhnacademy.mini_dooray.gateway.dto.project.ProjectIndexListRequestDto;
import com.nhnacademy.mini_dooray.gateway.dto.project.ProjectIndexListResponseDto;
import com.nhnacademy.mini_dooray.gateway.exception.DuplicateMemberException;
import com.nhnacademy.mini_dooray.gateway.security.Member;
import com.nhnacademy.mini_dooray.gateway.service.MemberService;
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
@RequestMapping("/projects")
@Slf4j
public class ProjectController {

    private final ProjectService projectService;
    private final MemberService memberService;


    public ProjectController(ProjectService projectService, MemberService memberService) {
        this.projectService = projectService;
        this.memberService = memberService;
    }

    @GetMapping
    public String showProjects(Model model, HttpSession session) {
        try {
        Member member = (Member) session.getAttribute("member");

        List<ProjectIndexListResponseDto> projectList = projectService.getAllProjects(new ProjectIndexListRequestDto(
                member.getMemberId()));
        log.info("projectList :{}",projectList);
        model.addAttribute("projectList", projectList);
        return "projectList";
        } catch (Exception e) {
            log.error("error :{}",e.getMessage());
            return "redirect:/member/login";
        }
    }
    @GetMapping("/register")
    public String showProjectRegistrationForm(Model model) {
        try {
        MemberIdsDto memberIdsDto = memberService.getAllMembers();
        model.addAttribute("memberIdsDto", memberIdsDto);

        return "newproject";
        } catch (Exception e) {
            log.error("error :{}",e.getMessage());
            return "redirect:/projects";
        }
    }

    @PostMapping("/register")
    public String registerProject(Model model,
                                  @RequestParam Long projectStatusId,
                                  @RequestParam String projectName,
                                  @RequestParam String memberId1,
                                  @RequestParam String memberId2,
                                  @RequestParam String memberId3,
    HttpSession session) {

        try {
            if (memberId1.equals(memberId2) || memberId1.equals(memberId3) || memberId2.equals(memberId3)) {
                throw new DuplicateMemberException("멤버는 중복될 수 없습니다.");
            }
            Member member = (Member) session.getAttribute("member");

            projectService.registerProject(projectStatusId,projectName,List.of(memberId1,memberId2,memberId3),member.getMemberId());
            return "redirect:/projects";
        } catch (Exception e) {
            log.error("error :{}",e.getMessage());
            return "redirect:/projects/register";
        }
    }
}
