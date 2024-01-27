package com.nhnacademy.mini_dooray.gateway.dto.tag;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TagIndexRequestDto {
    private Long tagId;
    private String tagName;
}
