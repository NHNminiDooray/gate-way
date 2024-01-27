package com.nhnacademy.mini_dooray.gateway.dto.task;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TaskRequestDto {
    private Long projectId;
    private String taskTitle;
    private String taskContent;
    private String taskWriteMemberId;
}