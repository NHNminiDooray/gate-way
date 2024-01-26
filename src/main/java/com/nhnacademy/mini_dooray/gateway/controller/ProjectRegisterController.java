package com.nhnacademy.mini_dooray.gateway.controller;

import com.nhnacademy.mini_dooray.gateway.dto.ProjectRegisterResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/projects")
@Slf4j
public class ProjectRegisterController {
    @GetMapping("/register")
    public String showProjectRegistrationForm() {
        return "registerProject";
    }

    @PostMapping
    public String registerProject(Model model, @RequestBody ProjectRegisterResponseDto projectRegisterResponseDto) {
        log.info("projectRegisterResponseDto : {}",projectRegisterResponseDto);
        //service
        return "redirect:/projects";
    }
}
