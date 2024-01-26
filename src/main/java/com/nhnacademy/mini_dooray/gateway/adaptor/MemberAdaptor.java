package com.nhnacademy.mini_dooray.gateway.adaptor;

import com.nhnacademy.mini_dooray.gateway.dto.CreateMemberDto;
import com.nhnacademy.mini_dooray.gateway.dto.LoginRequestDto;

public interface MemberAdaptor {

    void createMember(CreateMemberDto createMemberDto);
    void loginMember(LoginRequestDto loginRequestDto);

}
