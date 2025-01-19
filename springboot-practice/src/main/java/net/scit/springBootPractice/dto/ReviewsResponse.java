package net.scit.springBootPractice.dto;

import java.util.List;

public record ReviewsResponse(
        int count,
        List<ReviewResponse> reviewList
) {
}
