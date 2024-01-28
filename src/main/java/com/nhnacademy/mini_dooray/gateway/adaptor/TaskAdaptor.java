package com.nhnacademy.mini_dooray.gateway.adaptor;

import com.nhnacademy.mini_dooray.gateway.dto.comment.CommentModifyRequestDto;
import com.nhnacademy.mini_dooray.gateway.dto.comment.CommentRegisterRequestDto;
import com.nhnacademy.mini_dooray.gateway.dto.manage.ManageListResponseDto;
import com.nhnacademy.mini_dooray.gateway.dto.milestone.MilestoneRequestDto;
import com.nhnacademy.mini_dooray.gateway.dto.project.ProjectIndexListRequestDto;
import com.nhnacademy.mini_dooray.gateway.dto.project.ProjectIndexListResponseDto;
import com.nhnacademy.mini_dooray.gateway.dto.project.ProjectRegisterRequestDto;
import com.nhnacademy.mini_dooray.gateway.dto.tag.TagRequestDto;
import com.nhnacademy.mini_dooray.gateway.dto.task.TaskDetailResponseDto;
import com.nhnacademy.mini_dooray.gateway.dto.task.TaskIndexListResponseDto;
import com.nhnacademy.mini_dooray.gateway.dto.task.TaskRequestDto;
import java.util.List;

public interface TaskAdaptor {


    List<ProjectIndexListResponseDto> getAllProjects(ProjectIndexListRequestDto projectIndexListRequestDto);

    void registerProject(ProjectRegisterRequestDto projectRegisterRequestDto);

    List<TaskIndexListResponseDto> getAllTasks(Long projectId);

    TaskDetailResponseDto getTaskDetails(Long projectId,Long taskId);

    void registerTag(Long projectId, TagRequestDto tagRequestDto);

    void editTag(Long projectId,Long tagId, TagRequestDto tagRequestDto);

    void deleteTag(Long projectId,Long tagOd);

    void registerMileStone(Long projectId, MilestoneRequestDto milestoneRequestDto) ;

    void editMileStone(Long projectId, Long mileStoneId, MilestoneRequestDto milestoneRequestDto);

    void deleteMileStone(Long projectId, Long mileStoneId);

    ManageListResponseDto manageList(Long projectId);

    void addComment(Long projectId, Long taskId, CommentRegisterRequestDto commentRegisterRequestDto);

    void editComment(Long projectId, Long taskId,Long commentId, CommentModifyRequestDto commentModifyRequestDto);

    void deleteComment(Long projectId, Long taskId, Long commentId);

    void addTaskTag(Long projectId, Long taskId, Long tagId);

    void deleteTaskTag(Long projectId, Long taskId, Long tagId);

    void addTaskMileStone(Long projectId, Long taskId, Long mileStoneId);

    void deleteTaskMileStone(Long projectId, Long taskId, Long mileStoneId);

    void createTask(Long projectId, TaskRequestDto taskRequestDto);
}
