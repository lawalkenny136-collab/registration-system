package com.amigoscode.registrationsystem.userbooking;

public interface UserBookingDao {

    public void saveBooking (UserBooking userBooking);
    public void deleteBooking (Integer bookingId);
    public void viewBooking (Integer bookingId);
}
