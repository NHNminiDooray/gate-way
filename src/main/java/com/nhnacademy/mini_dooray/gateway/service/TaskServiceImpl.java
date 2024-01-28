package com.nhnacademy.mini_dooray.gateway.service;

import com.nhnacademy.mini_dooray.gateway.adaptor.TaskAdaptor;
import com.nhnacademy.mini_dooray.gateway.dto.task.TaskDetailResponseDto;
import com.nhnacademy.mini_dooray.gateway.dto.task.TaskIndexListResponseDto;
import com.nhnacademy.mini_dooray.gateway.dto.task.TaskRequestDto;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService{

    private final TaskAdaptor taskAdaptor;

    public TaskServiceImpl(TaskAdaptor taskAdaptor) {
        this.taskAdaptor = taskAdaptor;
    }

    @Override
    public List<TaskIndexListResponseDto> getAllTasks(Long projectId){
         return taskAdaptor.getAllTasks(projectId);
     }

    @Override
    public TaskDetailResponseDto getTaskDetails(Long projectId, Long taskId) {
        return taskAdaptor.getTaskDetails(projectId,taskId);
    }

    @Override
    public void createTask(Long projectId, String taskTitle, String taskContent, String memberID) {
        TaskRequestDto taskRequestDto = new TaskRequestDto(projectId,taskTitle,taskContent,memberID);
        taskAdaptor.createTask(projectId, taskRequestDto);

    }


}
