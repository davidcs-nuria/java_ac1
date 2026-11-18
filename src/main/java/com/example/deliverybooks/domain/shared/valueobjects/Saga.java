package com.example.deliverybooks.domain.shared.valueobjects;

import java.util.HashSet;

import com.example.deliverybooks.domain.books.Book;
import com.example.deliverybooks.domain.shared.validators.Checker;

public final class Saga {
    private String name, description;
    private long sagaId;
    private HashSet<Book> books;
    private HashSet<Genre> genres;


    public Saga (long sagaId, String name, String description, HashSet<Book> books, HashSet<Genre> genres) {
        this.setName(Checker.minLengthString(name, 3));
        this.setDescription(Checker.minLengthString(description, 50));
        this.setSagaId(Checker.longIsPositive(sagaId));
        this.setBooks(books);
        this.setGenres(genres);
    }

    public String getName () {
        return this.name;
    }

    public void setName (String name) {
        this.name = Checker.minLengthString(name, 3);
    }

    public String getDescription () {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = Checker.minLengthString(description, 50);
    }

    public long getSagaId() {
        return sagaId;
    }

    public void setSagaId(long sagaId) {
        this.sagaId = Checker.longIsPositive(sagaId);
    }

    public HashSet<Book> getBooks() {
        return books;
    }

    public void setBooks(HashSet<Book> books) {
        if (books.isEmpty()) {
            throw new IllegalArgumentException("The given list of books is empty.");
        }
        this.books = books;
    }

    public HashSet<Genre> getGenres() {
        return genres;
    }

    public void setGenres(HashSet<Genre> genres) {
        if (genres.isEmpty()) {
            throw new IllegalArgumentException("The given list of genres is empty.");
        }
        this.genres = genres;
    }
}
