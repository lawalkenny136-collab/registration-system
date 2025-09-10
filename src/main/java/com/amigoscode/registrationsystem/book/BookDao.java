package com.amigoscode.registrationsystem.book;

import java.util.List;
import java.util.Optional;

public interface BookDao {
    List<Books> selectAllBooks();
    Optional<Books> selectBookById(Integer id);
    List<Books> searchBooksByTitleOrAuthor(String title, String author);
    void deleteBook (String author, String title);
}