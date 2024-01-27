package com.nhnacademy.mini_dooray.gateway.adaptor;

import com.nhnacademy.mini_dooray.gateway.dto.project.ProjectIndexListRequestDto;
import com.nhnacademy.mini_dooray.gateway.dto.project.ProjectIndexListResponseDto;
import com.nhnacademy.mini_dooray.gateway.dto.project.ProjectRegisterRequestDto;
import com.nhnacademy.mini_dooray.gateway.dto.tag.TagIndexRequestDto;
import com.nhnacademy.mini_dooray.gateway.dto.tag.TagRequestDto;
import com.nhnacademy.mini_dooray.gateway.dto.task.TaskIndexListResponseDto;
import com.nhnacademy.mini_dooray.gateway.dto.task.TaskRequestDto;
import java.util.List;

public interface TaskAdaptor {


    List<ProjectIndexListResponseDto> getAllProjects(ProjectIndexListRequestDto projectIndexListRequestDto);

    void registerProject(ProjectRegisterRequestDto projectRegisterRequestDto);

    List<TaskIndexListResponseDto> getAllTasks(TaskRequestDto taskRequestDto);

    void registerTag(Long projectId, TagRequestDto tagRequestDto);

    void editTag(Long tagId, TagRequestDto tagRequestDto);

    void deleteTag(Long tagOd);

    void registerMileStone(TagRegisterRequestDto tagRegisterRequestDto);

    void editMileStone(TagIndexRequestDto tagEditRequestDto);

    void deleteMileStone(Long mileStoneId);
}
