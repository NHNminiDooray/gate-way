package com.nhnacademy.mini_dooray.gateway.service;

import com.nhnacademy.mini_dooray.gateway.adaptor.TaskAdaptor;
import com.nhnacademy.mini_dooray.gateway.dto.manage.ManageListResponseDto;
import com.nhnacademy.mini_dooray.gateway.dto.tag.TagRequestDto;
import com.nhnacademy.mini_dooray.gateway.dto.tag.TaskManageListResponseDto;
import org.springframework.stereotype.Service;

@Service
public class TagServiceImpl implements TagService {

    public TagServiceImpl(TaskAdaptor taskAdaptor) {
        this.taskAdaptor = taskAdaptor;
    }

    private final TaskAdaptor taskAdaptor;


    @Override
    public void createTag(Long projectId, String tagName) {
        TagRequestDto tagRequestDto = new TagRequestDto(tagName);
        taskAdaptor.registerTag(projectId ,tagRequestDto);
    }

    @Override
    public void editTag(Long projectId, Long tagId, String newTagName) {
        TagRequestDto tagRequestDto = new TagRequestDto(newTagName);
        taskAdaptor.editTag(projectId,tagId,tagRequestDto);
    }

    @Override
    public void deleteTag(Long projectId,Long tagId) {
        taskAdaptor.deleteTag(projectId,tagId);
    }

    @Override
    public ManageListResponseDto manageList(Long projectId) {
        return taskAdaptor.manageList(projectId);
    }

    @Override
    public void addTaskTag(Long projectId, Long taskId, Long tagId) {
        taskAdaptor.addTaskTag(projectId,taskId,tagId);
    }

    @Override
    public void deleteTaskTag(Long projectId, Long taskId, Long tagId) {
        taskAdaptor.deleteTaskTag(projectId,taskId,tagId);
    }

    @Override
    public TaskManageListResponseDto showTaskTag(Long projectId, Long taskId) {
        return taskAdaptor.showTaskTag(projectId,taskId);
    }
}
