package com.bookstore.bookstore.Repository;

import com.bookstore.bookstore.Repository.Entity.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
    List<Book> findAllByTitle(String title);
    Book findByTitle(String title);
    List<Book> findAllBookByAuthorContainsx(String titleInital);
}
