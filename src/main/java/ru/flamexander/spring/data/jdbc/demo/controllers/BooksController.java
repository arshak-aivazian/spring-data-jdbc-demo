package ru.flamexander.spring.data.jdbc.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.flamexander.spring.data.jdbc.demo.dtos.*;
import ru.flamexander.spring.data.jdbc.demo.services.BooksService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
public class BooksController {
    private final BooksService booksService;

    @Autowired
    public BooksController(BooksService booksService) {
        this.booksService = booksService;
    }

    @GetMapping
    public SimplestPageDto<DetailedBookDto> findAllDetailedBooks() {
        return new SimplestPageDto<>(booksService.findAllDetailedBooks());
    }

    @GetMapping("/page")
    public PageDto<DetailedBookDto> findDetailedBooksByPage(@RequestParam("number") Integer pageNumber,
                                                            @RequestParam("size") Integer pageSize) {
        return booksService.getDetailedBooksPage(pageSize, pageNumber);
    }

    @GetMapping("/{id}/rating")
    public RatingBookDetailDto getBookRating(@PathVariable Long id) {
        return booksService.getRatingDetail(id);
    }

    @GetMapping("/top10")
    public List<TopBookDto> getTop10Books() {
        return booksService.getTop10Books();
    }

    @PatchMapping("/{id}/title")
    public void updateTitleById(@PathVariable Long id, @RequestParam String value) {
        booksService.updateTitleById(id, value);
    }
}
