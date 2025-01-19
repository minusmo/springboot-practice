package net.scit.springBootPractice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 여기를 '엔트리포인트'라고 생각하시면 됩니다. 엔트리포인트는 한국말로 '진입점'인데요,
 * 우리가 자바 프로그래밍 배울 때 메인 클래스에 public static void main 함수 작성했던거 기억하시나요?
 * 그거랑 같습니다. 스프링부트 애플리케이션이 실행되면 바로 이 클래스의 메인함수를 호출해서
 * 웹 애플리케이션을 실행합니다.
 * 스프링부트 애플리케이션이 실행되면, 이 엔트리포인트로부터,
 * 같은 패키지 이하의 디렉토리(폴더) 레벨에 있는 스프링부트의 구성요소를 탐색하여, 스프링부트 애플리케이션에 등록합니다.
 * 스프링부트의 구성요소는 @Controller, @Service 등의 애노테이션을 붙이는 것으로 '이게 스프링부트 구성요소다'라고
 * 지정할 수 있습니다.
 */
/*
	이 애노테이션이 붙어야만 스프링부트 애플리케이션의 진입점으로 인식됩니다.
	애노테이션이라는 것은 자바의 클래스나 메서드에 부착해서, 부가기능을 추가하는 것이라고 생각하시면 됩니다.
	애노테이션을 사용하는 이유는,
	1. 탈부착하는 것만으로 기능을 추가, 제거하기 쉽고,
	2. 애노테이션을 통해 여러 메서드, 클래스에 공통 기능을 적용하기 쉽고,
	3. 적절한 애노테이션을 부착하는 것만으로 어떤 기능을 가진 클래스,메서드인지 판단하기 쉽기 때문입니다.
 */
@SpringBootApplication
public class SpringbootPracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootPracticeApplication.class, args);
	}

}
