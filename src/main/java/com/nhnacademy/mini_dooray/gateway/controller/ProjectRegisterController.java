package com.nhnacademy.mini_dooray.gateway.controller;

import com.nhnacademy.mini_dooray.gateway.dto.project.ProjectRegisterRequestDto;
import com.nhnacademy.mini_dooray.gateway.dto.project_member.ProjectMemberRequestDto;
import com.nhnacademy.mini_dooray.gateway.exception.DuplicateMemberException;
import java.util.List;
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
public class ProjectRegisterController {
    @GetMapping
    public String showProjectRegistrationForm(Model model) {
        // 예시
        ProjectRegisterRequestDto requestDto =
                new ProjectRegisterRequestDto(
                        1L,
                        "projectName",
                        List.of(new ProjectMemberRequestDto("qwe","멤버"),
                                new ProjectMemberRequestDto("asd","멤버"),
                                new ProjectMemberRequestDto("zxc","멤버")));
//        ProjectRegisterRequestDto registerRequestDto = service 구현
        log.info("registerRequestDto : {}", requestDto);
        model.addAttribute("registerRequestDto", requestDto);
        return "newproject";
    }

    @PostMapping
    public String registerProject(Model model,
                                  @RequestParam Long status,
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
                            status,
                            projectName,
                            List.of(new ProjectMemberRequestDto(memberId1,"멤버"),
                                    new ProjectMemberRequestDto(memberId2,"멤버"),
                                    new ProjectMemberRequestDto(memberId3,"멤버")));
            log.info("projectRegisterResponseDto : {}", requestDto);
            // service 구현

            return "redirect:/projects";
        } catch (DuplicateMemberException e) {
            return "redirect:/projects/register";
        }
    }
}
