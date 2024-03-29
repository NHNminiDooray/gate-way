package com.nhnacademy.mini_dooray.gateway.dto.manage;


import com.nhnacademy.mini_dooray.gateway.dto.milestone.MileStoneIndexListResponseDto;
import com.nhnacademy.mini_dooray.gateway.dto.tag.TagIndexRequestDto;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ManageListResponseDto {
    List<TagIndexRequestDto> tagList;
    List<MileStoneIndexListResponseDto> milestoneList;
}