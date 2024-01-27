package com.nhnacademy.mini_dooray.gateway.service;

public interface CommentService {

    void addComment(Long projectId, Long taskId, String memberId, String comment);
}
