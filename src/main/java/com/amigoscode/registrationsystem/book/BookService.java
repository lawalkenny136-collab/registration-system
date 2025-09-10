package com.amigoscode.registrationsystem.book;

import com.amigoscode.registrationsystem.exception.DuplicateResourceException;
import com.amigoscode.registrationsystem.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookDaoService bookDaoService;

    public BookService(BookDaoService bookDaoService) {
        this.bookDaoService = bookDaoService;
    }


    public List<Books> getAllBooks (){
        return bookDaoService.selectAllBooks();
    }

    public boolean isBookAvailable (Integer bookId){
        bookDaoService.selectBookById(bookId)
                .orElseThrow(()-> new ResourceNotFoundException("Book with id [%s] not found".formatted(bookId)));
        return true;
    }



    public List<Books> searchBooksByTitleOrAuthor(String title, String author){
        return bookDaoService.searchBooksByTitleOrAuthor(title,author);
    }

    public void saveBook (Books books) {
        if (bookDaoService.doesBookExist(books.getAuthor(), books.getTitle())== false){
            bookDaoService.saveBook(books);
        }
        else {
            throw new DuplicateResourceException("Book already in database");
        }
    }

    public void deleteBook (String title, String author) {
        if (bookDaoService.doesBookExist(author, title) == true){
            bookDaoService.deleteBook(title, author);
        }
        else {
            throw new ResourceNotFoundException("[%s] not found".formatted(title, author));
        }

    }


}
