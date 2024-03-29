package com.nhnacademy.mini_dooray.gateway.dto.member;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateMemberDto {
    String memberId;
    String email;
    String password;
    String memberStatus;
}
