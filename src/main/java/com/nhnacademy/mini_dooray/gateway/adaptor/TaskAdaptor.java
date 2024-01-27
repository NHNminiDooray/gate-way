package com.nhnacademy.mini_dooray.gateway.adaptor;

import com.nhnacademy.mini_dooray.gateway.dto.milestone.MilestoneRequestDto;
import com.nhnacademy.mini_dooray.gateway.dto.project.ProjectIndexListRequestDto;
import com.nhnacademy.mini_dooray.gateway.dto.project.ProjectIndexListResponseDto;
import com.nhnacademy.mini_dooray.gateway.dto.project.ProjectRegisterRequestDto;
import com.nhnacademy.mini_dooray.gateway.dto.tag.TagRequestDto;
import com.nhnacademy.mini_dooray.gateway.dto.task.TaskDetailResponseDto;
import com.nhnacademy.mini_dooray.gateway.dto.task.TaskIndexListResponseDto;
import java.util.List;

public interface TaskAdaptor {


    List<ProjectIndexListResponseDto> getAllProjects(ProjectIndexListRequestDto projectIndexListRequestDto);

    void registerProject(ProjectRegisterRequestDto projectRegisterRequestDto);

    List<TaskIndexListResponseDto> getAllTasks(Long projectId);

    TaskDetailResponseDto getTaskDetails(Long projectId,Long taskId);

    void registerTag(Long projectId, TagRequestDto tagRequestDto);

    void editTag(Long tagId, TagRequestDto tagRequestDto);

    void deleteTag(Long tagOd);

    void registerMileStone(Long projectId, MilestoneRequestDto milestoneRequestDto) ;

    void editMileStone(Long projectId, Long mileStoneId, MilestoneRequestDto milestoneRequestDto);

    void deleteMileStone(Long projectId, Long mileStoneId);
}
