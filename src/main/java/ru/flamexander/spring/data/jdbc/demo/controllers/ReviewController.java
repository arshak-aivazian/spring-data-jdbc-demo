package ru.flamexander.spring.data.jdbc.demo.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.flamexander.spring.data.jdbc.demo.dtos.CreateReviewDtoRq;
import ru.flamexander.spring.data.jdbc.demo.services.ReviewsService;

@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController {
    private final ReviewsService reviewsService;

    public ReviewController(ReviewsService reviewsService) {
        this.reviewsService = reviewsService;
    }

    @PostMapping
    public void addNewReview(@RequestBody CreateReviewDtoRq dto) {
        reviewsService.addReview(dto);
    }
}
