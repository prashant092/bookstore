package com.bookstore.bookstore.Service;


import com.bookstore.bookstore.Repository.BookRepository;
import com.bookstore.bookstore.Repository.Entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ServiceClass {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBook(){
        return (List<Book>)bookRepository.findAll();
    }

    public Book addBook(Book book ) {
        return bookRepository.save(book);
    }


}
