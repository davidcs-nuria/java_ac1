package com.example.deliverybooks.domain.shared.valueobjects;

public enum Genre {
    NOVEL("Novel"),
    ESSAY("Essay"),
    POETRY("Poetry"),
    DRAMA("Drama"),
    COMIC("Comic & Graphic Novel"),
    CHILDREN("Children's & Young Adult"),
    TECHNICAL("Technical & Academic"),
    BIOGRAPHY("Biography");

    public final String genre;

    Genre(String genre) {
        this.genre = genre;
    }

    public String getGenre() {
        return this.genre;
    }
}
