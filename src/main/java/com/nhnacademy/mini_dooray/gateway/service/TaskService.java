package com.nhnacademy.mini_dooray.gateway.service;

import com.nhnacademy.mini_dooray.gateway.dto.task.TaskIndexListResponseDto;
import com.nhnacademy.mini_dooray.gateway.dto.task.TaskRequestDto;
import java.util.List;

public interface TaskService {

    List<TaskIndexListResponseDto> getAllTasks(TaskRequestDto taskRequestDto);
}
