package com.nhnacademy.mini_dooray.gateway.service;

import com.nhnacademy.mini_dooray.gateway.adaptor.TaskAdaptor;
import com.nhnacademy.mini_dooray.gateway.dto.manage.ManageListResponseDto;
import com.nhnacademy.mini_dooray.gateway.dto.tag.TagRequestDto;
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
        taskAdaptor.editTag(tagId,tagRequestDto);
    }

    @Override
    public void deleteTag(Long projectId,Long tagId) {
        taskAdaptor.deleteTag(projectId,tagId);
    }

    @Override
    public ManageListResponseDto manageList(Long projectId) {
        return taskAdaptor.manageList(projectId);
    }


}
