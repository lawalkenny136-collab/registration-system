package com.amigoscode.registrationsystem.userbooking;

import com.amigoscode.registrationsystem.book.BookRepository;
import com.amigoscode.registrationsystem.book.BookService;
import com.amigoscode.registrationsystem.book.Books;
import com.amigoscode.registrationsystem.exception.ResourceNotFoundException;
import com.amigoscode.registrationsystem.user.User;
import com.amigoscode.registrationsystem.user.UserRepository;
import com.amigoscode.registrationsystem.user.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class UserBookingService {

   private final UserBookingDaoService userBookingDaoService;
   private final UserService userService;
   private final BookService bookService;
   private final UserRepository userRepository;
   private final BookRepository bookRepository;

    public UserBookingService(UserBookingDaoService userBookingDaoService, UserService userService, BookService bookService, UserRepository userRepository, BookRepository bookRepository) {
        this.userBookingDaoService = userBookingDaoService;
        this.userService = userService;
        this.bookService = bookService;
        this.userRepository = userRepository;
        this.bookRepository = bookRepository;
    }

    public List<UserBooking> viewAllUserBookings (){
        return userBookingDaoService.viewAllBookings();
    }

    public Optional <UserBooking> viewAllUserBookingById (Integer userBookingId) {
        return userBookingDaoService.viewUserBookingById(userBookingId);
    }

    public void borrowBook (UserBooking userBooking) {
        User user = userRepository.findById(userBooking.getUserId()).orElseThrow (() -> new ResourceNotFoundException("User not found"));
        Books books = bookRepository.findById(userBooking.getBookId()).orElseThrow(() -> new ResourceNotFoundException("Book not found"));

        if (books.isAvailable()) {
            books.setAvailable(false);
            bookService.saveBook(books);
            userBooking.setStatus("BORROWED");
            userBookingDaoService.saveBooking(userBooking);
            System.out.println(userBooking);
        }
        else {
            throw new ResourceNotFoundException("Book with id [%s] is not available".formatted(books.getBookId()));
        }
    }
    public void returnBook (Integer bookingId){
        UserBooking userBooking = userBookingDaoService.viewUserBookingById(bookingId).orElseThrow(() -> new ResourceNotFoundException("booking with  id [%s] not found".formatted(bookingId)));
        if (userBooking.getStatus() .equals("RETURNED")){
            throw new ResourceNotFoundException("Book already returned");
        }

        Books books = bookRepository.findBooksByBookId(userBooking.getBookId());
                books.setAvailable(true);
                bookService.saveBook(books);
        userBooking.setStatus("RETURNED");
        userBookingDaoService.saveBooking(userBooking);
    }

}



