package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "vendor_code")
    private String vendorCode;

    @Column
    private String title;

    @Column(name = "publication_year")
    private Integer publicationYear;

    @Column
    private String brand;

    @Column
    private Integer stock;

    @Column
    private Double price;
} 