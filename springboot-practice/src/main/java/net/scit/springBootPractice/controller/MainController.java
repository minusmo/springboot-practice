package net.scit.springBootPractice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Controller 애노테이션은, 부착시 이 클래스가 스프링부트 애플리케이션의
 * 구성요소로 인식되어질 수 있도록 하는 역할을 합니다. 특히, 컨트롤러 역할을 하는
 * 구성요소임을 의미합니다.
 */
@Controller
public class MainController {
    /**
     * @GetMapping은 Http Get 요청을 처리하는 메서드를 지정합니다.
     * 아래와 같이 {}(배열 표기)를 사용할 경우 2개 이상의 경로로 유입되는 요청을 처리할 수 있습니다.
     * @Controller는 기본적으로 MVC(ModelViewController) 패턴이라는 아키텍처를 사용하는 웹 애플리케이션 서버의 컨트롤러를 의미합니다.
     * MVC는 고전적인 웹 애플리케이션 설계 방식이라고 이해하시면 됩니다.
     * 웹 애플리케이션을 3개의 구성요소로 나누고 각각에 역할과 의미를 부여한 것입니다.
     * 이 고전 웹 애플리케이션은 클라이언트(주로 브라우저)의 요청에 대한 응답으로 웹 문서(주로 html)을 보내줍니다.
     * 그래서 여기서도 응답으로 html을 보내주게 되는데요,
     * 만약 html 파일이 아무것도 변경할게 없는 채인 순수 html이라면 그냥 그 파일을 보내주면되지만,
     * 현대의 많은 웹 애플리케이션은, 클라이언트가 뭔가 특별히 데이터를 요청해서, 그걸 특정 형식으로 보여주기 위해 존재합니다.
     * 이러한 경우는, 그냥 html파일을 보내줄 수가 없습니다. 데이터와 결합된 html을 보내줘야합니다.
     * 그래서 특별히 데이터와 html을 결합시켜주는 "템플릿엔진"이라는 자바 객체를 이용합니다.
     * 우리는 "타임리프 템플릿엔진"이라는 타임리프 표현식에 특화된 녀석을 이용합니다.
     * 이 @Controller에서는 일반적으로 템플릿엔진에게 전달할 html 템플릿의 경로를 반환하게됩니다.
     * (redirect: 와 같은 특수 반환값은 조금 다른 과정을 거쳐 특정 페이지를 요청하게 합니다.)
     * 그래서 여러분은 컨트롤러의 반환값을 써주실 때, 클라이언트에게 보내주고자하는 타임리프 html 파일의
     * 경로를 적어주시면 되는것이고, 경로는 templates 폴더를 기준으로 파일 확장자(.html)을 제외하고 적어주시면 됩니다.
     * 예를 들어 파일이 "templates/products/detail.html" 과 같은 경로에 있다면,
     * "products/detail"이라고 적어주시면됩니다.
     * @return 보내주고자하는 타임리프 html 파일의 경로
     */
    @GetMapping({"","/"})
    public String handleIndexRequest() {
        return "index";
    }
}
