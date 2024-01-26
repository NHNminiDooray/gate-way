package com.nhnacademy.mini_dooray.gateway.controller;

import com.nhnacademy.mini_dooray.gateway.domain.CreateMemberDto;
import com.nhnacademy.mini_dooray.gateway.domain.LoginRequestDto;
import com.nhnacademy.mini_dooray.gateway.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping()
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
    @GetMapping("/create")
    public String getCreateMember(Model model){
        //model.addAttribute("createMemberDto", new CreateMemberDto());
        return "signup";}


    @PostMapping("/create")
    public String doCreateMember( CreateMemberDto createMemberDto){

        memberService.createMember(createMemberDto);
        return "projectList";

    }
    @PostMapping("/login")
    public String doLogin(@RequestBody LoginRequestDto loginRequestDto){
        //model.addAttribute("member", member);
        return "member";
    }

}
