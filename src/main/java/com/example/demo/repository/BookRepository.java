package com.example.demo.repository;

import com.example.demo.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BookRepository extends JpaRepository<Book, Long> {
    Page<Book> findByTitleContainingIgnoreCase(String title, Pageable pageable);
    Page<Book> findByBrandContainingIgnoreCase(String brand, Pageable pageable);
    Page<Book> findByPublicationYear(Integer publicationYear, Pageable pageable);
    
    @Query("SELECT b FROM Book b WHERE " +
           "(:title IS NULL OR LOWER(b.title) LIKE LOWER(CONCAT('%', :title, '%'))) AND " +
           "(:brand IS NULL OR LOWER(b.brand) LIKE LOWER(CONCAT('%', :brand, '%'))) AND " +
           "(:publicationYear IS NULL OR b.publicationYear = :publicationYear)")
    Page<Book> findByFilters(
            @Param("title") String title,
            @Param("brand") String brand,
            @Param("publicationYear") Integer publicationYear,
            Pageable pageable);
} 