package com.amigoscode.registrationsystem.userbooking;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class UserBooking {

    @Id
    @SequenceGenerator(
            name = "booking_id_sequence",
            sequenceName = "booking_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "booking_id_sequence"
    )
    private Integer bookingId;

    @Column(nullable = false)
    private Integer userId;

    @Column(nullable = false)
    private Integer bookId;

    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(nullable = false)
    private LocalDateTime expectedReturnDate;

    @Column(nullable = false)
    private String status;

    public UserBooking(Integer bookingId, Integer userId, Integer bookId, LocalDateTime createdAt, LocalDateTime expectedReturnDate, String status) {
        this.bookingId = bookingId;
        this.userId = userId;
        this.bookId = bookId;
        this.createdAt = createdAt;
        this.expectedReturnDate = expectedReturnDate;
        this.status = status;
    }

    public UserBooking() {
    }

    public Integer getBookingId() {
        return bookingId;
    }

    public void setBookingId(Integer bookingId) {
        this.bookingId = bookingId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getExpectedReturnDate() {
        return expectedReturnDate;
    }

    public void setExpectedReturnDate(LocalDateTime expectedReturnDate) {
        this.expectedReturnDate = expectedReturnDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserBooking that = (UserBooking) o;
        return Objects.equals(bookingId, that.bookingId) && Objects.equals(userId, that.userId) && Objects.equals(bookId, that.bookId) && Objects.equals(createdAt, that.createdAt) && Objects.equals(expectedReturnDate, that.expectedReturnDate) && Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookingId, userId, bookId, createdAt, expectedReturnDate, status);
    }

    @Override
    public String toString() {
        return "UserBooking{" +
                "bokingId=" + bookingId +
                ", userId=" + userId +
                ", bookId=" + bookId +
                ", createdAt=" + createdAt +
                ", expectedReturnDate=" + expectedReturnDate +
                ", status='" + status + '\'' +
                '}';
    }
}
