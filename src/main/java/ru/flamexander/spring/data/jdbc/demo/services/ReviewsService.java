package ru.flamexander.spring.data.jdbc.demo.services;

import org.springframework.stereotype.Service;
import ru.flamexander.spring.data.jdbc.demo.dtos.CreateReviewDtoRq;
import ru.flamexander.spring.data.jdbc.demo.entities.Review;
import ru.flamexander.spring.data.jdbc.demo.repositories.ReviewsRepository;

import java.time.LocalDateTime;

@Service
public class ReviewsService {
    private final ReviewsRepository reviewsRepository;

    public ReviewsService(ReviewsRepository reviewsRepository) {
        this.reviewsRepository = reviewsRepository;
    }

    public void addReview(CreateReviewDtoRq dto) {
        var review = new Review(
                dto.getBookId(),
                dto.getRate(),
                dto.getText(),
                dto.getCreatedBy(),
                LocalDateTime.now()
        );
        reviewsRepository.save(review);
    }
}
