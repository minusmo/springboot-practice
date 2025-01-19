package net.scit.springBootPractice.controller;

import lombok.RequiredArgsConstructor;
import net.scit.springBootPractice.dto.ProductAndReviews;
import net.scit.springBootPractice.dto.ProductResponse;
import net.scit.springBootPractice.dto.ProductUpdateRequest;
import net.scit.springBootPractice.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;
    /*
        여기서는 상품을 조회할 때 상품의 정보와
        상품에 대한 리뷰를 모두 조회하는 것을 해보겠습니다.
        어떤 요청 경로를 지정할 때는, 우리가 평소에 웹 서비스에서 자주 본 것과
        가능한 비슷하게 지정한다고 생각하시면됩니다.
        경로를 지정하는 것에도 방법이 있지만, 우선은 여기까지만 알아두셔도 됩니다.
     */
    @GetMapping("/{seq}/details")
    public String getProductDetail(
            @PathVariable("seq") Integer productSeq,
            Model model
    ) {
        ProductAndReviews productAndReviews = productService.findProductWithReviewsById(productSeq);
        /*
            Model은 타임리프 템플릿 엔진이 타임리프 html에 값을 넣어 순수한 html을 생성하기 위해
            사용하는 객체의 타입입니다.
         */
        model.addAttribute("productAndReviews", productAndReviews);
        return "products/details";
    }

    @GetMapping("/{seq}/edit")
    public String getProductUpdatePage(
            @PathVariable("seq") Integer productSeq,
            Model model
    ) {
        ProductResponse product = productService.findProductById(productSeq);
        model.addAttribute("product", product);
        return "products/edit";
    }

    @PostMapping("/{seq}/edit")
    public String updateProductDetail(
            @ModelAttribute ProductUpdateRequest productUpdateRequest,
            @PathVariable("seq") Integer productSeq
    ) {
        productService.updateProductById(productSeq, productUpdateRequest);
        /*
            리다이렉트는 강제로 브라우저에서 다른 웹 페이지를 요청하게 만드는 방법입니다.
            리다이렉트에서 중요한 점은, 기존처럼 포워딩해서 html을 전송하는 것이 아니라,
            그전에, 브라우저에 리다이렉트 메시지를 전달하고, 브라우저에서 서버에 요청을 하게
            만드는 것이라는 것입니다. 즉, 하나의 중간 과정을 더 거친다는 것을 의미합니다.
         */
        return String.format("redirect:/products/%d/details",productSeq);
    }
}
