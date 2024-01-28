package com.nhnacademy.mini_dooray.gateway.dto.milestone;


import java.time.LocalDateTime;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MileStoneIndexListResponseDto {
    private Long milestoneId;
    private String milestoneName;
    private LocalDateTime startPeriod;
    private LocalDateTime endPeriod;
}
