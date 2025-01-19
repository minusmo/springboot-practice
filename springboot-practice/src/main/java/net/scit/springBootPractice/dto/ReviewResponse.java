package net.scit.springBootPractice.dto;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record ReviewResponse(
    Integer seq,
    String title,
    String content,
    LocalDateTime createDate,
    LocalDateTime updateDate
) {
}
