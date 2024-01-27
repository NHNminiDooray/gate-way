package com.nhnacademy.mini_dooray.gateway.service;

import com.nhnacademy.mini_dooray.gateway.dto.task.TaskDetailResponseDto;
import com.nhnacademy.mini_dooray.gateway.dto.task.TaskIndexListResponseDto;
import com.nhnacademy.mini_dooray.gateway.dto.task.TaskRequestDto;
import java.util.List;

public interface TaskService {

    List<TaskIndexListResponseDto> getAllTasks(Long projectId);

    TaskDetailResponseDto getTaskDetails(Long projectId, Long taskId);
}
