package com.nhnacademy.mini_dooray.gateway.service;

import com.nhnacademy.mini_dooray.gateway.adaptor.MemberAdaptor;

import com.nhnacademy.mini_dooray.gateway.dto.member.CreateMemberDto;
import com.nhnacademy.mini_dooray.gateway.security.Member;
import com.nhnacademy.mini_dooray.gateway.dto.member.LoginRequestDto;
import com.nhnacademy.mini_dooray.gateway.dto.member.MemberIdsDto;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService{

    private final MemberAdaptor memberAdaptor;

    public MemberServiceImpl(MemberAdaptor memberAdaptor) {
        this.memberAdaptor = memberAdaptor;
    }

    @Override
    public void createMember(CreateMemberDto createMemberDto) {
        createMemberDto.setMemberStatus("가입");
        memberAdaptor.createMember(createMemberDto);
    }

    @Override
    public Member loginMember(LoginRequestDto loginRequestDto) {
        return memberAdaptor.loginMember(loginRequestDto);
    }

    @Override
    public MemberIdsDto getAllMembers() {
        return memberAdaptor.getAllMembers();
    }
}
