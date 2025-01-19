package net.scit.springBootPractice.service;

import lombok.RequiredArgsConstructor;
import net.scit.springBootPractice.dto.ReviewResponse;
import net.scit.springBootPractice.repository.ReviewRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Service는 이 클래스가 스프링부트의 서비스 컴포넌트임을 지정하는 애노테이션입니다.
 * @Controller와 같은 역할을 합니다.
 */
@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository repository;

    public List<ReviewResponse> findAllReviews(Pageable pageable) {
        /**
         * 아마 처음보시는 문법이라고 생각되고, 잘 이해가 되지 않을 것이라고 생각됩니다만,
         * 이렇게 처리하는 것이, 수업 시간에 배운
         * null을 이용한 코드보다 훨씬 나은 코드라는 것만 우선 기억해두세요.
         * 프로그래밍에서는 null과 같은 특정 값을 매우 주의해서 다루어야하는데요,
         * 프로그램에 치명적인 오류를 발생시키기 때문입니다.
         * 따라서 null을 아예 사용하지 않는 코드가 더 좋은 코드 입니다.
         *
         * 하지만 이렇게 처리하는 방식에는 장점만 있는 것이 아닙니다.
         * 더 잘 만들어져있는 코드를 사용하는 만큼, 그에 대한 이해가 수반되어야합니다.
         * 만약 이 코드를 본인이 이해하고 사용할 자신이 없다면,
         * 수업시간에 배운 방법을 사용해도 괜찮습니다.
         * 다만, 반드시 "null"을 사용하는 부분에 있어서는 NullPointerException과 같은 에러가
         * 발생하지 않도록 주의를 기울여야합니다.(Optional도 null을 사용하지 않기 위해 고안된 방법 중 하나입니다.)
         *
         * 아래의 코드는 수업시간에 다루지 않은 것이기 때문에, 간단하게만 설명을 드리겠습니다.
         * 자세한 원리를 이해하면 더 좋지만, 지금은 사용하는 것만으로 충분합니다.
         */
        return repository
                // Pageable 파라미터를 받아 전체 레코드 중 일부를 조회합니다.
                .findAll(PageRequest.of(pageable.getPageNumber(), pageable.getPageSize()))
                // Page 객체에 있는 핵심 컨텐츠 즉, 엔티티의 리스트를 조회합니다.
                .getContent()
                /*
                    stream이라는 api인데요, 쉽게 말하면 이 api를 이용해서 여러 자바 컬렉션에서
                    통일된 방법으로 컬렉션의 요소를 변환할 수 있습니다.
                 */
                .stream()
                // 엔티티를 맵핑 즉, 다른 타입의 데이터로 변환합니다.
                .map(review ->
                        /*
                            이건 람다표현식이라는 문법인데요, 클래스가 기본이 되는 자바에서
                            클래스가 굳이 필요없을 정도로 간단한 기능(메서드 단하나)인데도
                            클래스를 만들어야만하는 불필요한 코드를 없애기 위해 고안된 방법입니다.
                            이런게 있다고만 알아두시고, 나중에 꼭 필요할 때가 오면, 그 때
                            찾아보시면 되겠습니다.
                         */
                        ReviewResponse
                                .builder()
                                .seq(review.getSeq())
                                .title(review.getTitle())
                                .content(review.getContent())
                                .createDate(review.getCreationDate())
                                .updateDate(review.getUpdateDate())
                                .build())
                .toList();
    }
}
