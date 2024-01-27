package com.nhnacademy.mini_dooray.gateway.service;

import com.nhnacademy.mini_dooray.gateway.adaptor.TaskAdaptor;
import com.nhnacademy.mini_dooray.gateway.dto.tag.TagIndexRequestDto;
import com.nhnacademy.mini_dooray.gateway.dto.tag.TagRegisterRequestDto;
import org.springframework.stereotype.Service;

@Service
public class TagServiceImpl implements TagService {

    public TagServiceImpl(TaskAdaptor taskAdaptor) {
        this.taskAdaptor = taskAdaptor;
    }

    private final TaskAdaptor taskAdaptor;


    @Override
    public void createTag(Long projectId, String tagName) {
        TagRegisterRequestDto tagRegisterRequestDto = new TagRegisterRequestDto(projectId,tagName);
        taskAdaptor.registerTag(tagRegisterRequestDto);
    }

    @Override
    public void editTag(Long tagId, String newTagName) {
        TagIndexRequestDto tagEditRequestDto = new TagIndexRequestDto(tagId,newTagName);
        taskAdaptor.editTag(tagEditRequestDto);
    }

    @Override
    public void deleteTag(Long tagId) {
        taskAdaptor.deleteTag(tagId);
    }
}
