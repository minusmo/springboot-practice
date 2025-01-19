package net.scit.springBootPractice.dto;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record ProductResponse(
        Integer seq,
        String name,
        int stock,
        String description,
        String category,
        int price,
        LocalDateTime creationDate,
        LocalDateTime updateDate
) {
}
