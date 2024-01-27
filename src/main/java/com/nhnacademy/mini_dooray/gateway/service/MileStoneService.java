package com.nhnacademy.mini_dooray.gateway.service;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface MileStoneService {

    void createMilestone(Long projectId, String milestoneName, LocalDateTime startDate, LocalDateTime endDate);

    void editMileStone(Long projectId, Long milestoneId,String newMilestoneName,LocalDateTime startDate, LocalDateTime endDate);

    void deleteMileStine(Long projectId, Long mileStoneId);
}
