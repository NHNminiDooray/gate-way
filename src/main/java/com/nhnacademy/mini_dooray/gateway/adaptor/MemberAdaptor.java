package com.nhnacademy.mini_dooray.gateway.adaptor;

import com.nhnacademy.mini_dooray.gateway.dto.member.CreateMemberDto;
import com.nhnacademy.mini_dooray.gateway.dto.member.LoginRequestDto;
import com.nhnacademy.mini_dooray.gateway.dto.member.MemberIdsDto;

public interface MemberAdaptor {

    void createMember(CreateMemberDto createMemberDto);
    void loginMember(LoginRequestDto loginRequestDto);

    MemberIdsDto getAllMembers();

}
