package com.amigoscode.registrationsystem.book;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/getallbooks")
    public List <Books> getAllBooks (){
        return bookService.getAllBooks();
    }

    @GetMapping("/search/{search-input}")
    public List <Books> searchBooks (@PathVariable("search-input") String searchInput){
        return bookService.searchBooksByTitleOrAuthor(searchInput,searchInput);
    }

    @GetMapping("/availablebook/{bookid}")
    public boolean availableBook (@PathVariable("bookid") Integer bookid){
        return bookService.isBookAvailable(bookid);
    }

    @PostMapping("/savebooks")
    public void saveBook (@RequestBody  Books books) {
        bookService.saveBook(books);
    }

    @DeleteMapping("/deletebook/{author},{title}")
    public void deleteBook (@PathVariable ("author") String author,
    @PathVariable("title")String title){
        bookService.deleteBook(title, author);
    }
}
