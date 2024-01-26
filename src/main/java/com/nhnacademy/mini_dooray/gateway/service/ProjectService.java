package com.nhnacademy.mini_dooray.gateway.service;

import com.nhnacademy.mini_dooray.gateway.dto.ProjectIndexListRequestDto;
import com.nhnacademy.mini_dooray.gateway.dto.ProjectIndexListResponseDto;
import java.util.List;

public interface ProjectService {

    List<ProjectIndexListResponseDto> getAllProjects(ProjectIndexListRequestDto projectIndexListRequestDto);
}
