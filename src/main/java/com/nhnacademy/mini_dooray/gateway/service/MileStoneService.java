package com.nhnacademy.mini_dooray.gateway.service;

import java.time.LocalDate;

public interface MileStoneService {

    void createMilestone(Long projectId, String milestoneName, LocalDate startDate, LocalDate endDate);

    void editMileStone(Long milestoneId,String newMilestoneName);

    void deleteMileStine(Long mileStoneId);
}
