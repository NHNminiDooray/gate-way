package com.nhnacademy.mini_dooray.gateway.service;

<<<<<<<<< Temporary merge branch 1
import com.nhnacademy.mini_dooray.gateway.dto.CreateMemberDto;
=========
import com.nhnacademy.mini_dooray.gateway.domain.CreateMemberDto;
import com.nhnacademy.mini_dooray.gateway.domain.LoginRequestDto;
>>>>>>>>> Temporary merge branch 2

public interface MemberService {


    void createMember(CreateMemberDto createMemberDto);

    void loginMember(LoginRequestDto loginRequestDto);

}
