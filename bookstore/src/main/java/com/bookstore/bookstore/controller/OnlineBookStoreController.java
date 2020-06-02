package com.bookstore.bookstore.controller;

import com.bookstore.bookstore.Repository.BookRepository;
import com.bookstore.bookstore.Repository.Entity.Book;
import com.bookstore.bookstore.Service.ServiceClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.lang.invoke.MethodType;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class OnlineBookStoreController {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private ServiceClass serviceClass;
    @RequestMapping(value="/addBook",produces = "application/json",consumes = "application/json",method = RequestMethod.POST)
    public Book bookAdd(@RequestBody Book book){
    return serviceClass.addBook(book);

}

    @GetMapping("/books")
    public List<Book> getAllBooks(){
    return serviceClass.getAllBook();
}

@GetMapping("/books/{ISBN}")
    public ResponseEntity<Book> getBookByISBN(@PathVariable (value = "ISBN") Long ISBN){
    ResponseEntity responseEntity;
    Book book= bookRepository.findById(ISBN).orElseThrow(() ->new RuntimeException("Not found") );
    return ResponseEntity.ok().body(book);
}

    @GetMapping("/books/{BookName}")
    public ResponseEntity<List<Book>> getBookByName(@PathVariable (value = "BookName") String title){
        List<Book> books= bookRepository.findAllByTitle(title);
        return ResponseEntity.ok().body(books.stream().filter(b -> b.getTitle().contains(title)).collect(Collectors.toList()));
    }
// findAllBookByAuthorContainsx\
@GetMapping("/books/{SearchBookName}")
    public ResponseEntity<List<Book>> getBookByNameInitials(@PathVariable (value = "SearchBookName") String title){
    List<Book> books= bookRepository.findAllBookByAuthorContainsx(title);
    return ResponseEntity.ok().body(books);
}

}
