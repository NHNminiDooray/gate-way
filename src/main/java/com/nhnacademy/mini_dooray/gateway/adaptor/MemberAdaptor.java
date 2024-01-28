package com.nhnacademy.mini_dooray.gateway.adaptor;

import com.nhnacademy.mini_dooray.gateway.dto.member.CreateMemberDto;
import com.nhnacademy.mini_dooray.gateway.dto.member.LoginRequestDto;
import com.nhnacademy.mini_dooray.gateway.dto.member.MemberIdsDto;
import com.nhnacademy.mini_dooray.gateway.security.Member;


public interface MemberAdaptor {

    void createMember(CreateMemberDto createMemberDto);
    Member loginMember(LoginRequestDto loginRequestDto);

    MemberIdsDto getAllMembers();

}
