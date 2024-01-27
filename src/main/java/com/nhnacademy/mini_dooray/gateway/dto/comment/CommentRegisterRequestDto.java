package com.nhnacademy.mini_dooray.gateway.dto.comment;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CommentRegisterRequestDto {
    private LocalDateTime commentCreatedAt;
    private String commentWriterMemberId;
    private String commentContent;

    public CommentRegisterRequestDto(String commentWriterMemberId,
                                     String commentContent) {
        this.commentCreatedAt = LocalDateTime.now();
        this.commentWriterMemberId = commentWriterMemberId;
        this.commentContent = commentContent;
    }
}
