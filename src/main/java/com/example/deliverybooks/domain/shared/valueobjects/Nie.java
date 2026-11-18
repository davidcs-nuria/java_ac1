package com.example.deliverybooks.domain.shared.valueobjects;

public record Nie(String value) implements LegalID {
    public Nie {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("El NIE no puede estar vacío.");
        }
    }

    @Override
    public String getValue() {
        return value;
    }

    public String getType() {
        return "NIE";
    }
}