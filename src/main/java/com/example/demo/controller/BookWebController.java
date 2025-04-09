package com.example.demo.controller;

import com.example.demo.entity.Book;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/books")
public class BookWebController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public String listBooks(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String brand,
            @RequestParam(required = false) Integer publicationYear,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "2") int size,
            Model model) {
        
        Page<Book> books = bookService.findByFilters(
            title, brand, publicationYear, PageRequest.of(page, size));
        
        model.addAttribute("books", books);
        model.addAttribute("title", title);
        model.addAttribute("brand", brand);
        model.addAttribute("publicationYear", publicationYear);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", books.getTotalPages());
        
        return "books/list";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("book", new Book());
        return "books/form";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("book", bookService.findById(id));
        return "books/form";
    }

    @PostMapping("/save")
    public String saveBook(@ModelAttribute Book book) {
        bookService.save(book);
        return "redirect:/books";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookService.deleteById(id);
        return "redirect:/books";
    }
} 