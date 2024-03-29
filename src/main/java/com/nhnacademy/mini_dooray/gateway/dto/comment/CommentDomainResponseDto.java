package com.nhnacademy.mini_dooray.gateway.dto.comment;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CommentDomainResponseDto {
    private Long commentId;
    private Long taskId;
    private LocalDateTime commentCreatedAt;
    private String commentWriterMemberId;
    private String commentContent;
}
