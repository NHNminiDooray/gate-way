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
public class MileStoneResponseDto {
    private LocalDateTime startPeriod;
    private LocalDateTime endPeriod;
}