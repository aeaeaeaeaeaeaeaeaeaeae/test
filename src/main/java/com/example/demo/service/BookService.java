package com.example.demo.service;

import com.example.demo.entity.Book;
import com.example.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    
    @Autowired
    private BookRepository bookRepository;
    
    public Page<Book> findAll(Pageable pageable) {
        return bookRepository.findAll(pageable);
    }
    
    public Page<Book> findByFilters(String title, String brand, Integer publicationYear, Pageable pageable) {
        return bookRepository.findByFilters(title, brand, publicationYear, pageable);
    }
    
    public Book findById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found with id: " + id));
    }
    
    public Book save(Book book) {
        return bookRepository.save(book);
    }
    
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }
} 