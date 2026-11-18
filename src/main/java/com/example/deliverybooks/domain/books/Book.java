package com.example.deliverybooks.domain.books;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.HashSet;

import com.example.deliverybooks.domain.authors.Author;
import com.example.deliverybooks.domain.publishers.Publisher;
import com.example.deliverybooks.domain.shared.validators.Checker;
import com.example.deliverybooks.domain.shared.valueobjects.BindingType;
import com.example.deliverybooks.domain.shared.valueobjects.Dimensions;
import com.example.deliverybooks.domain.shared.valueobjects.Genre;
import com.example.deliverybooks.domain.shared.valueobjects.Isbn;
import com.example.deliverybooks.domain.shared.valueobjects.Money;
import com.example.deliverybooks.domain.shared.valueobjects.Saga;
import com.example.deliverybooks.domain.shared.valueobjects.Weight;

public final class Book {
    private long bookID;
    private Isbn isbn;
    private String title, language, sinopsis;
    private Integer totalPages, minimumAge;
    private LocalDate releaseDate;
    private HashSet<Author> authors;
    private HashSet<Genre> genres;
    private Publisher publisher;
    private BindingType binding;
    private Saga saga;
    private Weight weight;
    private Dimensions dimensions;
    private Money price;

    private final DateTimeFormatter DEFAULT_FORMAT = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    private static String errorMessage = "";

    protected Book() {

    }

    public static Book of(String birthDate, long authorID, String name) {
        var c = new Book();

        try {
            c.setAuthorID(authorID);
        } catch (IllegalArgumentException e) {
            AddErrorMessage("Bad Author ID: " + e.getMessage());
        }

        try {
            c.setBirthDate(birthDate);
        } catch (IllegalArgumentException e) {
            AddErrorMessage("Bad Birth Date: " + e.getMessage());
        }

        try {
            c.setName(name);
        } catch (IllegalArgumentException e) {
            AddErrorMessage("Bad Full Name: " + e.getMessage());
        }

        if (!errorMessage.isEmpty()) {
            throw new IllegalArgumentException("Client build error: \n\n" + errorMessage);
        }

        return c;
    }

    private static void AddErrorMessage (String message) {
        if (!errorMessage.isEmpty()) {
            errorMessage += "\n";
        }
        errorMessage += message;
    }

    public long getClientID() {
        return bookID;
    }

    public void setAuthorID(long authorID) {
        try {
            Checker.longIsPositive(authorID);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
        this.bookID = authorID;
    }

    public String getName() {
        return title;
    }

    public void setName(String name) {
        try {
            Checker.minLengthString(name, 6);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
        this.title = name;
    }

    public void setAddress(String street, String city, String zipCode, String country) {
        try {
            Checker.minLengthString(street, 8);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Bad Street: " + e.getMessage());
        }
        try {
            Checker.minLengthString(city, 8);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Bad City: " + e.getMessage());
        }
        try {
            Checker.stringBetweenLength(zipCode, 5, 5);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Bad Zip Code: " + e.getMessage());
        }
        try {
            Checker.minLengthString(country, 3);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Bad Country: " + e.getMessage());
        }
    }

    public String getBirthDate() {
        return releaseDate.toString();
    }

    public void setBirthDate(String birthDate) {
        try {
            this.releaseDate = LocalDate.parse(birthDate, DEFAULT_FORMAT);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}
