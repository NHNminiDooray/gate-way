package com.nhnacademy.mini_dooray.gateway.dto.member;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LoginRequestDto {
    private String memberId;
    private String password;
}
