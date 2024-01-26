package com.nhnacademy.mini_dooray.gateway.service;

import com.nhnacademy.mini_dooray.gateway.domain.CreateMemberDto;
import com.nhnacademy.mini_dooray.gateway.domain.LoginRequestDto;

public interface MemberService {


    void createMember(CreateMemberDto createMemberDto);

    void loginMember(LoginRequestDto loginRequestDto);

}
