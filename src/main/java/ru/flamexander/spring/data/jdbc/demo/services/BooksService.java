package ru.flamexander.spring.data.jdbc.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.flamexander.spring.data.jdbc.demo.dtos.DetailedBookDto;
import ru.flamexander.spring.data.jdbc.demo.dtos.PageDto;
import ru.flamexander.spring.data.jdbc.demo.dtos.RatingBookDetailDto;
import ru.flamexander.spring.data.jdbc.demo.dtos.TopBookDto;
import ru.flamexander.spring.data.jdbc.demo.repositories.BooksRepository;

import java.util.List;

@Service
public class BooksService {
    private final BooksRepository booksRepository;

    @Autowired
    public BooksService(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    public List<DetailedBookDto> findAllDetailedBooks() {
        return booksRepository.findAllDetailedBooks();
    }

    public PageDto<DetailedBookDto> getDetailedBooksPage(int pageSize, int pageNumber) {
        int offset = pageSize * (pageNumber - 1);
        List<DetailedBookDto> detailedBooksPage = booksRepository.findAll(offset, pageSize);
        return new PageDto<>(detailedBooksPage, pageNumber, pageSize);
    }

    public void updateTitleById(Long id, String newTitle) {
        booksRepository.changeTitleById(id, newTitle);
    }

    public RatingBookDetailDto getRatingDetail(Long id) {
        return booksRepository.getRating(id);
    }

    public List<TopBookDto> getTop10Books() {
        return booksRepository.findMonthTopBooks(10);
    }
}
