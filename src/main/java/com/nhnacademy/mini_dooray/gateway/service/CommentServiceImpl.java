package com.nhnacademy.mini_dooray.gateway.service;

import com.nhnacademy.mini_dooray.gateway.adaptor.TaskAdaptor;
import com.nhnacademy.mini_dooray.gateway.dto.comment.CommentRegisterRequestDto;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService{

    private final TaskAdaptor taskAdaptor;

    public CommentServiceImpl(TaskAdaptor taskAdaptor) {
        this.taskAdaptor = taskAdaptor;
    }

    @Override
    public void addComment(Long projectId, Long taskId, String memberId, String comment) {
        CommentRegisterRequestDto commentRegisterRequestDto = new CommentRegisterRequestDto(memberId,comment);
        taskAdaptor.addComment(projectId,taskId,commentRegisterRequestDto);
    }
}
