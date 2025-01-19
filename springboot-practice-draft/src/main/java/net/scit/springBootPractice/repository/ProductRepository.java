package net.scit.springBootPractice.repository;

import net.scit.springBootPractice.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
