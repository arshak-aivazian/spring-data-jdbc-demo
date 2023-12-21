package ru.flamexander.spring.data.jdbc.demo.repositories;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;
import ru.flamexander.spring.data.jdbc.demo.dtos.DetailedBookDto;
import ru.flamexander.spring.data.jdbc.demo.dtos.RatingBookDetailDto;
import ru.flamexander.spring.data.jdbc.demo.dtos.TopBookDto;
import ru.flamexander.spring.data.jdbc.demo.entities.Book;

import java.util.List;

@Repository
public interface BooksRepository extends ListCrudRepository<Book, Long> {
    @Query(
            "select b.id, b.title, b.genre, a.full_name as author_name, bd.description from BOOKS b " +
                    " left join AUTHORS a on b.author_id = a.id " +
                    " left join BOOKS_DETAILS bd on bd.book_id = b.id"
    )
    List<DetailedBookDto> findAllDetailedBooks();

    @Query("update books set title = :title where id = :id")
    @Modifying
    void changeTitleById(Long id, String title);

    @Query(
            "select b.id, b.title, b.genre, a.full_name as author_name, bd.description from BOOKS b " +
                    " left join AUTHORS a on b.author_id = a.id " +
                    " left join BOOKS_DETAILS bd on bd.book_id = b.id" +
                    " limit :limit offset :offset"
    )
    List<DetailedBookDto> findAll(int offset, int limit);

    @Query(
            "select b.id, b.title, AVG(r.rate) avg_rating from BOOKS b " +
                    " left join REVIEWS r on b.id = r.book_id" +
                    " where b.id = :id" +
                    " group by b.id"
    )
    RatingBookDetailDto getRating(Long id);

    @Query(
            "select b.id, b.title from BOOKS b " +
                    " left join REVIEWS r on b.id = r.book_id" +
                    " where r.created_at > dateadd('MONTH', -1, current_date )" +
                    " group by b.id" +
                    " order by AVG(r.rate) desc" +
                    " limit :limit"
    )
    List<TopBookDto> findMonthTopBooks(int limit);
}