package ru.flamexander.spring.data.jdbc.demo.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateReviewDtoRq {
    @JsonProperty("book_id")
    private Long bookId;
    private Integer rate;
    private String text;
    @JsonProperty("created_by")
    private String createdBy;

    public CreateReviewDtoRq() {
    }

    public CreateReviewDtoRq(Long bookId, Integer rate, String text, String createdBy) {
        this.bookId = bookId;
        this.rate = rate;
        this.text = text;
        this.createdBy = createdBy;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
}
