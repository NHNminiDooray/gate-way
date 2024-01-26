package com.nhnacademy.mini_dooray.gateway.adaptor;

import com.nhnacademy.mini_dooray.gateway.domain.CreateMemberDto;
import com.nhnacademy.mini_dooray.gateway.domain.LoginRequestDto;
import java.lang.reflect.Member;

public interface MemberAdaptor {


    void createMember(CreateMemberDto createMemberDto);
    void loginMember(LoginRequestDto loginRequestDto);

}
