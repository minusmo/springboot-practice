package net.scit.springBootPractice.dto;

import java.time.LocalDateTime;

public record ProductUpdateRequest(
        String name,
        int stock,
        String description,
        String category,
        int price,
        LocalDateTime creationDate,
        LocalDateTime updateDate
) {
}
