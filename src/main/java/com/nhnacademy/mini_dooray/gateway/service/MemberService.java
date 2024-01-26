package com.nhnacademy.mini_dooray.gateway.service;

import com.nhnacademy.mini_dooray.gateway.dto.CreateMemberDto;
import com.nhnacademy.mini_dooray.gateway.dto.LoginRequestDto;

public interface MemberService {


    void createMember(CreateMemberDto createMemberDto);

    void loginMember(LoginRequestDto loginRequestDto);

}
