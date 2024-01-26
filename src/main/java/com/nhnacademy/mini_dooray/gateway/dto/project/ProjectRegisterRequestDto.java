package com.nhnacademy.mini_dooray.gateway.dto.project;
import com.nhnacademy.mini_dooray.gateway.dto.project_member.ProjectMemberRequestDto;
import java.util.List;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ProjectRegisterRequestDto {
    private Long projectStatusId;
    private String projectName;
    private List<ProjectMemberRequestDto> requestMembers;
}
