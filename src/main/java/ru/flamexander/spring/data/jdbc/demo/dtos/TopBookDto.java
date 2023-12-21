package ru.flamexander.spring.data.jdbc.demo.dtos;

public class TopBookDto {
    private Long id;
    private String title;

    public TopBookDto() {
    }

    public TopBookDto(Long id, String title) {
        this.id = id;
        this.title = title;
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
}
