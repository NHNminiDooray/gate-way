package com.nhnacademy.mini_dooray.gateway.dto.milestone;

import java.time.LocalDateTime;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class MilestoneRequestDto {
    private Long taskId;
    private String milestoneName;
    private LocalDateTime startPeriod;
    private LocalDateTime endPeriod;
}
