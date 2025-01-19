package net.scit.springBootPractice.controller;

import lombok.RequiredArgsConstructor;
import net.scit.springBootPractice.dto.ReviewResponse;
import net.scit.springBootPractice.dto.ReviewsResponse;
import net.scit.springBootPractice.service.ReviewService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
/*
    @RequestMapping은 컨트롤러 클래스의 모든 메서드가 공통적인 경로의 요청을 처리할 때,
    공통 부분을 분리해서 관리하기 쉽게 하기 위해 사용됩니다.
    프로그래밍의 세계에서는, 중복되는 코드가 있으면 분리해서 재사용하려는 경향이 있습니다.
 */
@RequestMapping("/reviews")
/*
    @RequiredArgsConstructor는 클래스의 필드 중에서 반드시 초기화가 되어야만하는
    필드에 대한 생성자를 자동생성해줍니다. 반드시 초기화가 되어야하만하는 필드란,
    final 필드, 그리고 null이 되면 안되는 필드를 말합니다.
    final 필드는 한번 초기화한 후에 그 값이 변하지 않는 필드를 의미하므로, 필드 선언시나
    생성자 호출시(인스턴스 생성시)에 초기화가 되어야만합니다.
    final 지시어는 프로그래머에게 특별히 어떤 변수의 값의 불변성을 보장시킬 수 있도록
    명시하는 기능을 준 것입니다. 따라서, final을 사용할 때는 프로그래머에 의한 명시적인 초기화가
    반드시 있어야합니다. 값의 불변성이라는 것은 기본적으로 어떠한 의도된 값이 존재한다는 것을 상정한 것이므로,
    기본값이 반드시 있어야겠죠.
 */
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;
    /*
        @ResponseBody 애노테이션은 이 메서드가 html 페이지를 보내주는 것이 아닌,
        다른 형태의 데이터를 보내주는 것임을 명시합니다.
        다른 형태의 데이터는 json이 될 수도 있고, 그냥 텍스트가 될 수도 있고, xml, yml 등의 데이터가 될 수도 있습니다.
        이와 같은 형식의 데이터는 ajax 뿐만 아니라 다른 서버, 시스템 간에 데이터를 교환할 때도 용이하게 때문에
        @ReponseBody가 굉장히 많이 사용됩니다.
        참고로 이 @ResponseBody를 클래스 레벨에 적용하는 @RestController라는 것도 있습니다.
     */
    @ResponseBody
    /*
        여러분은 지금까지 boolean, List, Map 이런 형태의 반환값을
        많이 배웠을텐데요, 자바의 기본 객체를 그대로 DTO로 반환하는 것은 좋지 않은 방법입니다.
        왜냐하면, 자바 기본 객체는 우리가 임의로 원하는 값을 필드로 추가하거나
        구조를 변경할수도 없을 뿐더러,
        애초에 자바 기본 객체는 이런식으로 애플리케이션 외부로 전송하기 위한 것이 아닙니다.
        여기에 사용해야하는것은 DTO입니다. DTO(DataTransferObject)는 그 목적 자체가
        외부로 전송하기 위한 것이기 때문입니다.

        그리고 DTO라는 글자를 꼭 뒤에 붙이지 않아도 됩니다.
        굳이 필요없는데도 관습적으로 붙이는 문자는 지양해야합니다.

        하나의 DTO는, 하나의 컨트롤러 메서드의 반환 값으로만 사용되어야합니다.
        DTO라는 것은 api 스펙(수업시간에 봤던 것과 같은)에 종속적입니다. 그런데
        api 스펙이라는 것은 기본적으로 하나의 컨트롤러에 해당하는 요구사항이자 명세서입니다.
        따라서 하나의 DTO를 두 개 이상의 컨트롤러의 반환값으로 사용하는 것은 옳지 않습니다.
        이렇게 하면 어느 DTO가 어느 컨트롤러 메서드에서 무슨 의도로 사용되는지
        개발자에게 혼란만 가중시킬 뿐입니다.
     */
    @GetMapping
    public ReviewsResponse getReviews(
            /*
                페이징을 위한 쿼리 파라미터를 받기 쉽게 해주는 애노테이션입니다.
                페이징이라는 것은 그 자체로 어려운 개념은 아닙니다.
                페이징은 단순히 우리가 책장을 넘기듯이 많은 수의 데이터를 페이지로 나누어,
                페이지 단위로 데이터를 보여주기 위해 고안된 기술입니다.
                아마 여러분들은 페이징 그 자체보다는, 수업시간에 나온 페이징에 필요한 로직이
                어려웠을 것이라 생각됩니다. 그 부분은 사실을 그렇게 어렵지 않습니다.
                기본적으로는 초등 수학 수준에 불과합니다.
                여기서는 페이징의 기본적인 용어만 짚고 넘어가겠습니다.
                오프셋: 건너뛸 데이터의 개수
                리밋: 페이지의 크기(가져올 데이터 개수)
                페이지: 데이터 뭉치의 단위
             */
            @PageableDefault Pageable pageable,
            /*
                요청이 쿼리스트링을 포함할 때, 즉, GET요청이거나, POST이면서 x-www-form-urlencoded
                인 경우의 값을 받을 수 있게 하는 애노테이션 입니다.
                스프링부트에서는 이렇게 특정 형식의 요청에 대해 편리하게 값을 자바 프로그램으로
                읽어들일 수 있는 기능을 제공합니다.
                원래는 이러한 기능을 직접 http의 명세에 맞게 직접 구현해야합니다.
                우선 경우에 따라 적절한 스프링부트 기능을 활용한다는 것만 알아두세요.
             */
            @RequestParam("productSeq") Integer productSeq
            ) {
        /*
            어떤 서비스의 메서드 이름을 붙일 때는 그 목적을 가장 잘 나타낼 수 있는 이름을 택한다는 것을
            알아두세요. 당장은 어렵겠지만 이 것을 두고두고 떠올리면서 메서드를 만들 때마다 적용하는 연습을 해보셔야합니다.
            그리고 또 중요한 것은, 남들도 이해하기 쉬운 이름을 붙이는 것입니다.
            이름 붙이기에도 법칙이 있다는 것 정도를 알아두시고, 여유가 있을 때 찾아보시면 좋습니다.
         */
        List<ReviewResponse> reviews = reviewService.findAllReviews(pageable);
        return new ReviewsResponse(
                reviews.size(),
                reviews
        );
    }

}
