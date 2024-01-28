package com.nhnacademy.mini_dooray.gateway.dto.milestone;

import java.time.LocalDateTime;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MileStoneResponseDto {
    private Long milestoneId;
    private LocalDateTime startPeriod;
    private LocalDateTime endPeriod;
}
