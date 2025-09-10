package com.amigoscode.registrationsystem.userbooking;

import com.amigoscode.registrationsystem.book.Books;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user-bookings")
public class UserBookingController {
    private final UserBookingService userBookingService;

    public UserBookingController(UserBookingService userBookingService) {
        this.userBookingService = userBookingService;
    }

    @GetMapping()
    public void allUserBooking (){
        userBookingService.viewAllUserBookings();
    }

    @PostMapping("/borrow-books")
    public void borrowBook(@RequestBody UserBooking userBooking){
        userBookingService.borrowBook(userBooking);
    }

    @GetMapping("/{id}")
    public void viewUserBookingById (@PathVariable(name = "userBookingId") Integer userBookingId){
        userBookingService.viewAllUserBookingById(userBookingId);
    }
}
