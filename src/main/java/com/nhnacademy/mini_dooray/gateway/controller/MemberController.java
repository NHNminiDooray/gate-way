package com.nhnacademy.mini_dooray.gateway.controller;

import com.nhnacademy.mini_dooray.gateway.dto.member.CreateMemberDto;
import com.nhnacademy.mini_dooray.gateway.dto.member.LoginRequestDto;
import com.nhnacademy.mini_dooray.gateway.security.Member;
import com.nhnacademy.mini_dooray.gateway.service.MemberService;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
    @GetMapping("/create")
    public String getCreateMember(Model model){
        return "signup";
    }

    @GetMapping("/login")
    public String getLogin(){
        return "login";
    }

    @PostMapping("/create")
    public String doCreateMember(CreateMemberDto createMemberDto){
        memberService.createMember(createMemberDto);
        return "redirect:/member/login";

    }

    @PostMapping("/login")
    public String doLogin(LoginRequestDto loginRequestDto, HttpSession session){
        Member member = memberService.loginMember(loginRequestDto);
        session.setAttribute("member", member);
        return "redirect:/projects";
    }
    @GetMapping("/logout")
    public String doLogout(HttpSession session) {
        session.removeAttribute("member");
        return "redirect:/member/login";
    }
}
