package com.bookstore.bookstore.Repository.Entity;

import com.bookstore.bookstore.Repository.BookRepository;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table
@EntityListeners(AuditingEntityListener.class)
public class Book implements BookRepository {


    @Id
    Long isbn;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="title",nullable =  false)
    String title;
    @Column(name="author_name",nullable =  false)
    String author_name;
    @Column(name="price",nullable =  false)
    int price;
    @Column(name="count",nullable =  true)
    int count;
    public Long getIsbn() {
        return isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }


    @Override
    public List<Book> findAllByTitle(String title) {
        return null;
    }

    @Override
    public Book findByTitle(String title) {
        return null;
    }

    @Override
    public List<Book> findAllBookByAuthorContainsx(String titleInital) {
        EntityManager entityManager= entityManager.createQuery("select * from book where author LIKE %'" + titleInital + "'+\"% ");
                Query q=
    }
}
