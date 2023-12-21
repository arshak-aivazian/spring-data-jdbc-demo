package ru.flamexander.spring.data.jdbc.demo.repositories;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;
import ru.flamexander.spring.data.jdbc.demo.entities.Review;

@Repository
public interface ReviewsRepository extends ListCrudRepository<Review, Long> {
}
