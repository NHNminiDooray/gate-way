package com.nhnacademy.mini_dooray.gateway.dto.tag;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaskManageListResponseDto {
    List<TagIndexRequestDto> projedtTagList;
    List<TagIndexRequestDto> taskTagList;
}