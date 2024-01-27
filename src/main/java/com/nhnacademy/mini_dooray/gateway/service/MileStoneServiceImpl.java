package com.nhnacademy.mini_dooray.gateway.service;

import com.nhnacademy.mini_dooray.gateway.adaptor.TaskAdaptor;
import com.nhnacademy.mini_dooray.gateway.dto.milestone.MilestoneRequestDto;
import java.time.LocalDateTime;
import org.springframework.stereotype.Service;

@Service
public class MileStoneServiceImpl implements MileStoneService{

    private final TaskAdaptor taskAdaptor;

    public MileStoneServiceImpl(TaskAdaptor taskAdaptor) {
        this.taskAdaptor = taskAdaptor;
    }

    @Override
    public void createMilestone(Long projectId, String milestoneName, LocalDateTime startDate, LocalDateTime endDate) {
        MilestoneRequestDto milestoneRequestDto = new MilestoneRequestDto(milestoneName,startDate,endDate);
        taskAdaptor.registerMileStone(projectId,milestoneRequestDto);
    }

    @Override
    public void editMileStone(Long projectId, Long milestoneId, String newMilestoneName,LocalDateTime startDate, LocalDateTime endDate) {
        MilestoneRequestDto milestoneRequestDto = new MilestoneRequestDto(newMilestoneName,startDate,endDate);
        taskAdaptor.editMileStone(projectId, milestoneId, milestoneRequestDto);
    }


    @Override
    public void deleteMileStone(Long projectId, Long mileStoneId) {
        taskAdaptor.deleteMileStone(projectId, mileStoneId);
    }

    @Override
    public void addTaskMileStone(Long projectId, Long taskId, Long mileStoneId) {
        taskAdaptor.addTaskMileStone(projectId,taskId,mileStoneId);
    }

    @Override
    public void deleteTaskMileStone(Long projectId, Long taskId, Long mileStoneId) {
        taskAdaptor.deleteTaskMileStone(projectId,taskId,mileStoneId);
    }
}
