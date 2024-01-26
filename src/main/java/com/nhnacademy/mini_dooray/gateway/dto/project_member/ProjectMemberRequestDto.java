package com.nhnacademy.mini_dooray.gateway.dto.project_member;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ProjectMemberRequestDto {
    private String projectMemberId;
    private String projectRole;
}
