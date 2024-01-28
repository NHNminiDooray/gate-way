package com.nhnacademy.mini_dooray.gateway.security;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Member {

    private String memberId;

    private String email;

    private String password;

    private String memberStatus;

}