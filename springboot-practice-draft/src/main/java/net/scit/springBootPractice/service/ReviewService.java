package net.scit.springBootPractice.service;

import lombok.RequiredArgsConstructor;
import net.scit.springBootPractice.repository.ReviewRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository repository;

    public List<ReviewResponse> findAllReviews(Pageable pageable) {
        /*
            적절한 코드를 입력해주세요.
         */
    }
}
