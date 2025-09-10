package com.amigoscode.registrationsystem.book;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository <Books,Integer> {

    List<Books> findBooksByTitleContainingIgnoreCaseOrAuthorContainingIgnoreCase(String title, String authorName);
    void deleteBooksByAuthorIgnoreCaseOrOrTitleIgnoreCase (String authorName, String title);
    boolean existsBooksByAuthorIgnoreCaseAndTitleIgnoreCase (String authorName, String title);
    Books findBooksByBookId(Integer bookId);

}

