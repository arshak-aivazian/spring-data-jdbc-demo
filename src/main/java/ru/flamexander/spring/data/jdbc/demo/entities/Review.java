package ru.flamexander.spring.data.jdbc.demo.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Table("REVIEWS")
public class Review {
    @Id
    private Long id;
    private Long bookId;
    private Integer rate;
    private String text;
    private String createdBy;
    private LocalDateTime createdAt;

    @PersistenceCreator
    public Review(Long id, Long bookId, Integer rate, String text, String createdBy, LocalDateTime createdAt) {
        this.id = id;
        this.bookId = bookId;
        this.rate = rate;
        this.text = text;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
    }

    public Review(Long bookId, Integer rate, String text, String createdBy, LocalDateTime createdAt) {
        this.bookId = bookId;
        this.rate = rate;
        this.text = text;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
