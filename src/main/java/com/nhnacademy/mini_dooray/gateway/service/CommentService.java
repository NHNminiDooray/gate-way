package com.nhnacademy.mini_dooray.gateway.service;

public interface CommentService {

    void addComment(Long projectId, Long taskId, String memberId, String comment);

    void editComment(Long projectId, Long taskId,String memberId, Long commentID, String editedComment);
    void deleteComment(Long projectId, Long taskId, Long commentId);
}
