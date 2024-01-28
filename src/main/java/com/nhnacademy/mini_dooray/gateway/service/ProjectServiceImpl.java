package com.nhnacademy.mini_dooray.gateway.service;

import com.nhnacademy.mini_dooray.gateway.adaptor.TaskAdaptor;
import com.nhnacademy.mini_dooray.gateway.dto.project.ProjectIndexListRequestDto;
import com.nhnacademy.mini_dooray.gateway.dto.project.ProjectIndexListResponseDto;
import com.nhnacademy.mini_dooray.gateway.dto.project.ProjectRegisterRequestDto;
import com.nhnacademy.mini_dooray.gateway.dto.project_member.ProjectMemberRequestDto;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
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
    public void registerProject(Long projectStatusId, String projectName, List<String> memberIds, String adminMemberId) {
        List<ProjectMemberRequestDto> projectMemberRequestDtoList = Stream.concat(
                memberIds.stream().limit(3).map(memberId -> new ProjectMemberRequestDto(memberId, "멤버")),
                Stream.of(new ProjectMemberRequestDto(adminMemberId, "관리자"))
        ).collect(Collectors.toList());

        ProjectRegisterRequestDto projectRegisterRequestDto = new ProjectRegisterRequestDto(projectStatusId, projectName, projectMemberRequestDtoList);
        taskAdaptor.registerProject(projectRegisterRequestDto);
    }


}
