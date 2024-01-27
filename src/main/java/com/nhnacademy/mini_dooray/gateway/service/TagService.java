package com.nhnacademy.mini_dooray.gateway.service;

public interface TagService {

    void createTag(Long projectId, String tagName);

    void editTag(Long tagId,String newTagName);

    void deleteTag(Long tagId);
}
