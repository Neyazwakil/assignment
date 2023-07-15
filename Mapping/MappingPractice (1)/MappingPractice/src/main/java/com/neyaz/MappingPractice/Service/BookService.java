package com.neyaz.MappingPractice.Service;

import com.neyaz.MappingPractice.Model.Book;
import com.neyaz.MappingPractice.Repository.BookRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BookService {

    private final BookRepository bookRepository;
    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book>  getAllBooks(){
        return bookRepository.findAll();

    }
    public Book getBookById(String Id){
        return bookRepository.findById(Id).orElse(null);

    }
    public Book createBook(Book book){
        return bookRepository.save(book);

    }
    public Book updateBook(Book book){
        return bookRepository.save(book);

    }
    public void deleteBook(String Id){
        bookRepository.deleteById(Id);

    }




}

