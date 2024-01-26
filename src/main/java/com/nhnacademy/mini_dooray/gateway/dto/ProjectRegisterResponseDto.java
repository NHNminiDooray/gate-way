package com.nhnacademy.mini_dooray.gateway.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ProjectRegisterResponseDto {
    private Long projectId;
    private Long projectStatusId;
    private String projectName;
}