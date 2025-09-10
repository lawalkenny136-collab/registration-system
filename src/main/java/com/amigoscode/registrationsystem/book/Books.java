package com.amigoscode.registrationsystem.book;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Books {

    @Id

    @SequenceGenerator(
            name = "book_id_sequence",
            sequenceName = "book_id_sequence"
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "book_id_sequence"
    )
    private Integer bookId;

    @Column(
            nullable = false
    )

    private String title;

    @Column(
            nullable = false
    )

    private String author;

    @Column(
            nullable = false
    )

    private boolean isAvailable;



    public Books(int bookId, String title, String author, boolean isAvailable) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.isAvailable = isAvailable;
    }


    public Books() {
    }

    public Books(String title, String author, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.isAvailable = isAvailable;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Books books = (Books) o;
        return isAvailable == books.isAvailable && Objects.equals(bookId, books.bookId) && Objects.equals(title, books.title) && Objects.equals(author, books.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookId, title, author, isAvailable);
    }

    @Override
    public String toString() {
        return "Books{" +
                "bookId=" + bookId +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", isAvailable=" + isAvailable +
                '}';
    }
}
