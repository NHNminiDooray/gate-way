package com.nhnacademy.mini_dooray.gateway.dto.milestone;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MileStoneDomainResponseDto {
    private Long milestoneId;
    private Long projectId;
    private Long taskId;
    private String name;
    private LocalDateTime startPeriod;
    private LocalDateTime endPeriod;
}
