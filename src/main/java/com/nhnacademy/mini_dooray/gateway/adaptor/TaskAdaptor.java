package com.nhnacademy.mini_dooray.gateway.adaptor;

import com.nhnacademy.mini_dooray.gateway.dto.project.ProjectIndexListRequestDto;
import com.nhnacademy.mini_dooray.gateway.dto.project.ProjectIndexListResponseDto;
import com.nhnacademy.mini_dooray.gateway.dto.project.ProjectRegisterRequestDto;
import com.nhnacademy.mini_dooray.gateway.dto.tag.TagIdDto;
import com.nhnacademy.mini_dooray.gateway.dto.tag.TagIndexRequestDto;
import com.nhnacademy.mini_dooray.gateway.dto.tag.TagRegisterRequestDto;
import com.nhnacademy.mini_dooray.gateway.dto.task.TaskIndexListResponseDto;
import com.nhnacademy.mini_dooray.gateway.dto.task.TaskRequestDto;
import java.util.List;

public interface TaskAdaptor {


    List<ProjectIndexListResponseDto> getAllProjects(ProjectIndexListRequestDto projectIndexListRequestDto);

    void registerProject(ProjectRegisterRequestDto projectRegisterRequestDto);

    List<TaskIndexListResponseDto> getAllTasks(TaskRequestDto taskRequestDto);

    void registerTag(TagRegisterRequestDto tagRegisterRequestDto);

    void editTag(TagIndexRequestDto tagEditRequestDto);

    void deleteTag(Long tagOd);

    void registerMileStone(TagRegisterRequestDto tagRegisterRequestDto);

    void editMileStone(TagIndexRequestDto tagEditRequestDto);

    void deleteMileStone(Long mileStoneId);
}
