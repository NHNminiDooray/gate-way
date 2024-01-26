package com.nhnacademy.mini_dooray.gateway.service;

import com.nhnacademy.mini_dooray.gateway.adaptor.MemberAdaptor;

import com.nhnacademy.mini_dooray.gateway.dto.CreateMemberDto;

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
    public void loginMember(LoginRequestDto loginRequestDto) {
        memberAdaptor.loginMember(loginRequestDto);
    }
}
