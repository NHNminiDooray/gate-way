package com.nhnacademy.mini_dooray.gateway.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProjectIndexListResponseDto {
    private Long projectId;
    private String projectName;
}