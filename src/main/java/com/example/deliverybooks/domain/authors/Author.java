package com.example.deliverybooks.domain.authors;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.HashSet;

import com.example.deliverybooks.domain.books.Book;
import com.example.deliverybooks.domain.shared.validators.Checker;
import com.example.deliverybooks.domain.shared.valueobjects.Genre;
import com.example.deliverybooks.domain.shared.valueobjects.Saga;
import com.example.deliverybooks.domain.shared.valueobjects.SocialMediaProfile;
import com.example.deliverybooks.domain.shared.valueobjects.WebSite;

public class Author {
    private long authorID;
    private String name, biography;
    private LocalDate birthDate;
    private WebSite website;
    private HashSet<SocialMediaProfile> profiles;
    private HashSet<Book> bibliography;
    private HashSet<Genre> genres;
    private HashSet<Saga> sagas;


    private final DateTimeFormatter DEFAULT_FORMAT = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    private static String errorMessage = "";

    protected Author() {

    }

    public static Author of(long authorID, String name, String biography, LocalDate birthDate, WebSite website, HashSet<SocialMediaProfile> profiles, HashSet<Book> bibliography, HashSet<Genre> genres, HashSet<Saga> sagas) {
        var c = new Author();

        try {
            c.setAuthorID(authorID);
        } catch (IllegalArgumentException e) {
            AddErrorMessage("Bad Author ID: " + e.getMessage());
        }

        try {
            c.setName(name);
        } catch (IllegalArgumentException e) {
            AddErrorMessage("Bad Full Name: " + e.getMessage());
        }

        try {
            c.setBibliography(bibliography);
        } catch (IllegalArgumentException e) {
            AddErrorMessage("Bad Bibliography: " + e.getMessage());
        }

        try {
            c.setBirthDate(birthDate);
        } catch (IllegalArgumentException e) {
            AddErrorMessage("Bad Birth Date: " + e.getMessage());
        }

        try {
            c.setWebsite(website);
        } catch (IllegalArgumentException e) {
            AddErrorMessage("Bad Birth Date: " + e.getMessage());
        }

        try {
            c.setBirthDate(birthDate);
        } catch (IllegalArgumentException e) {
            AddErrorMessage("Bad Birth Date: " + e.getMessage());
        }

        try {
            c.setBirthDate(birthDate);
        } catch (IllegalArgumentException e) {
            AddErrorMessage("Bad Birth Date: " + e.getMessage());
        }

        try {
            c.setBirthDate(birthDate);
        } catch (IllegalArgumentException e) {
            AddErrorMessage("Bad Birth Date: " + e.getMessage());
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        try {
            Checker.minLengthString(name, 6);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
        this.name = name;
    }

    public long getAuthorID() {
        return authorID;
    }

    public void setAuthorID(long authorID) {
        try {
            Checker.longIsPositive(authorID);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
        this.authorID = authorID;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public String getBirthDate() {
        return birthDate.toString();
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public WebSite getWebsite() {
        return website;
    }

    public void setWebsite(WebSite website) {
        this.website = website;
    }

    public HashSet<SocialMediaProfile> getProfiles() {
        return profiles;
    }

    public void setProfiles(HashSet<SocialMediaProfile> profiles) {
        this.profiles = profiles;
    }

    public HashSet<Book> getBibliography() {
        return bibliography;
    }

    public void setBibliography(HashSet<Book> bibliography) {
        this.bibliography = bibliography;
    }

    public HashSet<Genre> getGenres() {
        return genres;
    }

    public void setGenres(HashSet<Genre> genres) {
        this.genres = genres;
    }

    public HashSet<Saga> getSagas() {
        return sagas;
    }

    public void setSagas(HashSet<Saga> sagas) {
        this.sagas = sagas;
    }

    public void setBirthDate(String birthDate) {
        try {
            this.birthDate = LocalDate.parse(birthDate, DEFAULT_FORMAT);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "Author [authorID=" + authorID + ", name=" + name + ", biography=" + biography + ", birthDate="
                + birthDate + ", website=" + website + ", profiles=" + profiles + ", bibliography=" + bibliography
                + ", genres=" + genres + ", sagas=" + sagas + "]";
    }
}
