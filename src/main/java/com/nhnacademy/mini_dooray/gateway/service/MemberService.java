package com.nhnacademy.mini_dooray.gateway.service;

import com.nhnacademy.mini_dooray.gateway.dto.member.CreateMemberDto;
import com.nhnacademy.mini_dooray.gateway.dto.member.LoginRequestDto;

public interface MemberService {


    void createMember(CreateMemberDto createMemberDto);

//    void loginMember(LoginRequestDto loginRequestDto);

}
