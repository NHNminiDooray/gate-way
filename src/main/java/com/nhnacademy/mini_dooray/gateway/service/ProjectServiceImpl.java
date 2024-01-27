package com.nhnacademy.mini_dooray.gateway.service;

import com.nhnacademy.mini_dooray.gateway.adaptor.TaskAdaptor;
import com.nhnacademy.mini_dooray.gateway.dto.project.ProjectIndexListRequestDto;
import com.nhnacademy.mini_dooray.gateway.dto.project.ProjectIndexListResponseDto;
import com.nhnacademy.mini_dooray.gateway.dto.project.ProjectRegisterRequestDto;
import com.nhnacademy.mini_dooray.gateway.dto.project_member.ProjectMemberRequestDto;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ProjectServiceImpl implements ProjectService{


    private final TaskAdaptor taskAdaptor;

    public ProjectServiceImpl(TaskAdaptor taskAdaptor) {
        this.taskAdaptor = taskAdaptor;
    }

    @Override
    public List<ProjectIndexListResponseDto> getAllProjects(ProjectIndexListRequestDto projectIndexListRequestDto) {
        return taskAdaptor.getAllProjects(projectIndexListRequestDto);
    }

    @Override
    public void registerProject(Long projectStatusId, String projectName, List<String> memberIds) {
        List<ProjectMemberRequestDto> projectMemberRequestDtoList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            ProjectMemberRequestDto projectMemberRequestDto = new ProjectMemberRequestDto(memberIds.get(i),"멤버");
            projectMemberRequestDtoList.add(projectMemberRequestDto);
        }
        ProjectRegisterRequestDto projectRegisterRequestDto = new ProjectRegisterRequestDto(projectStatusId,projectName,projectMemberRequestDtoList);
        taskAdaptor.registerProject(projectRegisterRequestDto);

    }

}
