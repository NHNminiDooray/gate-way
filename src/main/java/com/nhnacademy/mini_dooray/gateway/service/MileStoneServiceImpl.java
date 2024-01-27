package com.nhnacademy.mini_dooray.gateway.service;

import com.nhnacademy.mini_dooray.gateway.adaptor.TaskAdaptor;
import java.time.LocalDate;
import org.springframework.stereotype.Service;

@Service
public class MileStoneServiceImpl implements MileStoneService{

    private final TaskAdaptor taskAdaptor;

    public MileStoneServiceImpl(TaskAdaptor taskAdaptor) {
        this.taskAdaptor = taskAdaptor;
    }

    @Override
    public void createMilestone(Long projectId, String milestoneName, LocalDate startDate, LocalDate endDate) {

    }

    @Override
    public void editMileStone(Long tagId, String newTagName) {

    }


    @Override
    public void deleteMileStine(Long mileStoneId) {
        taskAdaptor.deleteMileStone(mileStoneId);
    }
}
