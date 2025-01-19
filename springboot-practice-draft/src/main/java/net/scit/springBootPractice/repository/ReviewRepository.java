package net.scit.springBootPractice.repository;

import net.scit.springBootPractice.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
}
