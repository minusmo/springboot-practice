package net.scit.springBootPractice.service;

import lombok.RequiredArgsConstructor;
import net.scit.springBootPractice.dto.*;
import net.scit.springBootPractice.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository repository;

    public ProductAndReviews findProductWithReviewsById(Integer productSeq) {
        /*
            적절한 코드를 입력해주세요.
         */
    }

    public ProductResponse findProductById(Integer productSeq) {
        /*
            적절한 코드를 입력해주세요.
         */
    }

    @Transactional
    public void updateProductById(Integer productSeq, ProductUpdateRequest productUpdateRequest) {
        /*
            적절한 코드를 입력해주세요.
         */
    }
}
