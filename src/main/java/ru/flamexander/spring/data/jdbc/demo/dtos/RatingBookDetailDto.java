package ru.flamexander.spring.data.jdbc.demo.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RatingBookDetailDto {
    private Long id;
    private String title;
    @JsonProperty("avg_rating")
    private Integer avgRating;

    public RatingBookDetailDto() {
    }

    public RatingBookDetailDto(Long id, String title, Integer avgRating) {
        this.id = id;
        this.title = title;
        this.avgRating = avgRating;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getAvgRating() {
        return avgRating;
    }

    public void setAvgRating(Integer avgRating) {
        this.avgRating = avgRating;
    }
}
