package com.nhnacademy.mini_dooray.gateway.adaptor;

import com.nhnacademy.mini_dooray.gateway.dto.ProjectIndexListRequestDto;
import com.nhnacademy.mini_dooray.gateway.dto.ProjectIndexListResponseDto;
import java.util.List;

public interface TaskAdaptor {


    List<ProjectIndexListResponseDto> getAllProjects(ProjectIndexListRequestDto projectIndexListRequestDto);
}
