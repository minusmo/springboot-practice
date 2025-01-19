package net.scit.springBootPractice.repository;

import net.scit.springBootPractice.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/*
 * 기본적으로는 @Repository 애노테이션을 달아줘야합니다.
 * 하지만 이 경우에는 JpaRepository를 상속받았기 때문에 생략해도 됩니다.
 * 스프링 부트에서는 JpaRepository 타입을 찾아서 스프링부트의 구성요소로 등록해줍니다.
 */
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
