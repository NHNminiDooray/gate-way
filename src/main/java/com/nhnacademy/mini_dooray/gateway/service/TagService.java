package com.nhnacademy.mini_dooray.gateway.service;

import com.nhnacademy.mini_dooray.gateway.dto.manage.ManageListResponseDto;

public interface TagService {

    void createTag(Long projectId, String tagName);

    void editTag(Long projectId,Long tagId, String newTagName);

    void deleteTag(Long projectId,Long tagId);

    ManageListResponseDto manageList(Long projectId);
}
