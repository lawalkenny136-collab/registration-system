package com.amigoscode.registrationsystem.book;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public class BookDaoService implements BookDao {

    private final BookRepository bookRepository;

    public BookDaoService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    @Override
    public List<Books> selectAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Books> selectBookById(Integer id) {
        return bookRepository.findById(id);
    }

    @Override
    public List<Books> searchBooksByTitleOrAuthor(String title, String author) {
        return  bookRepository.findBooksByTitleContainingIgnoreCaseOrAuthorContainingIgnoreCase(title, author);
    }

    public boolean doesBookExist(String author, String title){
       return bookRepository.existsBooksByAuthorIgnoreCaseAndTitleIgnoreCase(author, title);
    }

    public void saveBook (Books books) {
        bookRepository.save(books);
    }

    public void deleteBook (String title, String author){
        bookRepository.deleteBooksByAuthorIgnoreCaseOrOrTitleIgnoreCase(author,title);
    }
}
