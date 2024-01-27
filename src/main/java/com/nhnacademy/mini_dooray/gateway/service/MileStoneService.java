package com.nhnacademy.mini_dooray.gateway.service;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface MileStoneService {

    void createMilestone(Long projectId, String milestoneName, LocalDateTime startDate, LocalDateTime endDate);

    void editMileStone(Long projectId, Long milestoneId,String newMilestoneName,LocalDateTime startDate, LocalDateTime endDate);

    void deleteMileStone(Long projectId, Long mileStoneId);

    void addTaskMileStone(Long projectId, Long taskId, Long mileStoneId);

    void deleteTaskMileStone(Long projectId, Long taskId, Long mileStoneId);
}
