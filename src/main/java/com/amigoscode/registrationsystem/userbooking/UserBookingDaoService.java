package com.amigoscode.registrationsystem.userbooking;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public class UserBookingDaoService implements UserBookingDao{

    private final UserBookingRepository userBookingRepository;

    public UserBookingDaoService(UserBookingRepository userBookingRepository) {
        this.userBookingRepository = userBookingRepository;
    }

    @Override
    public void saveBooking(UserBooking userBooking) {
        userBookingRepository.save(userBooking);
    }

    @Override
    public void deleteBooking(Integer bookingId) {
        userBookingRepository.deleteById(bookingId);
    }

    @Override
    public void viewBooking(Integer bookingId) {
        userBookingRepository.findById(bookingId);
    }

    public List<UserBooking> viewAllBookings (){
      return  userBookingRepository.findAll();
    }

    public Optional <UserBooking> viewUserBookingById (Integer userBookingId){
      return   userBookingRepository.findById(userBookingId);
    }


}
