package net.scit.springBootPractice.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import net.scit.springBootPractice.domain.Product;
import net.scit.springBootPractice.dto.*;
import net.scit.springBootPractice.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository repository;

    /*
        이처럼 메서드의 이름은 조금 길다고 생각될지라도,
        충분히 메서드의 목적을 표현할 수 있도록 적어주는 것이 중요합니다.
     */
    public ProductAndReviews findProductWithReviewsById(Integer productSeq) {
        /*
            이렇게 .메서드이름() 을 여러개 연결해서 원하는 작업을 수행하는 것을
            "메서드 체이닝"이라고합니다.
            지금까지는 Optional을 이용하는 방법을 많이 배우셨을 텐데요,
            Optional로 엔티티가 있는지 없는지를 판단하는 것보다는
            아래처럼 엔티티가 없을 시 명확하게 에러를 내는 것이 좋습니다.
            어차피 엔티티가 없다는 것은 의도한 상황이 아닌 에러 상황이니까요.
            프로그래밍에서는 의도를 명확히하는 것이 정말로 중요합니다.
         */
        Product product = repository
                .findById(productSeq)
                // Optinal의 메서드로, Optional이 비어있을 경우, 에러를 던집니다.
                .orElseThrow(() -> new EntityNotFoundException("ID에 해당하는 상품 조회 실패"));
        List<ReviewResponse> reviews = product
                .getReviews()
                .stream()
                .map(review ->
                        ReviewResponse
                                .builder()
                                .seq(review.getSeq())
                                .title(review.getTitle())
                                .content(review.getContent())
                                .createDate(review.getCreationDate())
                                .updateDate(review.getUpdateDate())
                                .build())
                .toList();
        return ProductAndReviews
                .builder()
                .productSeq(product.getSeq())
                .name(product.getName())
                .stock(product.getStock())
                .description(product.getDescription())
                .price(product.getPrice())
                .category(product.getCategory())
                .creationDate(product.getCreationDate())
                .updateDate(product.getUpdateDate())
                .reviews(new ReviewsResponse(reviews.size(), reviews))
                .build();
    }

    public ProductResponse findProductById(Integer productSeq) {
        Product product = repository
                .findById(productSeq)
                .orElseThrow(() -> new EntityNotFoundException("ID에 해당하는 상품 조회 실패"));
        return ProductResponse
                .builder()
                .seq(product.getSeq())
                .name(product.getName())
                .stock(product.getStock())
                .category(product.getCategory())
                .description(product.getDescription())
                .price(product.getPrice())
                .creationDate(product.getCreationDate())
                .updateDate(product.getUpdateDate())
                .build();
    }

    /*
        @Transactional은 우리가 데이터베이스 시간에 배웠던 그 트랜잭션을,
        자바 애플리케이션까지 확장한 것입니다. 이 애노테이션의 역할과 기능에 대한
        자세한 개념은 초심자에게는 상당히 어려워서, 지금은,
        "DML(Insert, Update, Delete) 작업을 할 때 붙이는 애노테이션이다"라고만
        이해하시고 잊지말고 붙여주시면 됩니다.
        이 애노테이션을 붙이면 한마디로, "이 함수가 성공적으로 반환되면, 트랜잭션을 커밋한다"
        를 명시하는 것이라고 생각하시면 됩니다.
     */
    @Transactional
    public void updateProductById(Integer productSeq, ProductUpdateRequest productUpdateRequest) {
        Product product = repository
                .findById(productSeq)
                .orElseThrow(() -> new EntityNotFoundException("ID에 해당하는 상품 조회 실패"));
        /**
         * 어떻게 이렇게 필드 값만 변경했는데 업데이트가 되는지 궁금하실텐데요,
         * 마법이 있는게 아닙니다.
         * jpa에서는, 엔티티를 추적, 감시하면서, 필드의 값이 변경이 생기면,
         * 그 값을 이전의 상태의 값과 비교해서, 변경된 엔티티에 대해서 업데이트 쿼리를
         * 생성합니다.
         */
        product.setName(productUpdateRequest.name());
        product.setCategory(productUpdateRequest.category());
        product.setPrice(productUpdateRequest.price());
        product.setDescription(productUpdateRequest.description());
        product.setStock(productUpdateRequest.stock());
    }
}
