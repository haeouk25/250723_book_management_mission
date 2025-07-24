package com.haeouk25.book_management.controller;

import com.haeouk25.book_management.model.Book;
import com.haeouk25.book_management.repository.AuthorRepository;
import com.haeouk25.book_management.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping
@RequiredArgsConstructor
public class BookController {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    @GetMapping
    public String list() {
        return "books";
    }

    @GetMapping("/books/new")
    public String form(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("authors", authorRepository.finalAll());

        return "book_form";
    }

    @PostMapping("/books")
    public String save(@ModelAttribute Book book) {
        bookRepository.save(book);

        return "redirect:/";
    }
}