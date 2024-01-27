package com.nhnacademy.mini_dooray.gateway.dto.comment;

import java.time.LocalDateTime;
import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class CommentModifyRequestDto {
    private LocalDateTime commentCreatedAt;
    private String commentWriterMemberId;
    private String commentContent;

    public CommentModifyRequestDto(String commentWriterMemberId,
                                   String commentContent) {
        this.commentCreatedAt = LocalDateTime.now();
        this.commentWriterMemberId = commentWriterMemberId;
        this.commentContent = commentContent;
    }
}
