package com.example.deliverybooks.domain.shared.valueobjects;

public record Nif(String value) implements LegalID {
    public Nif {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("El NIF no puede estar vacío.");
        }
    }

    @Override
    public String getValue() {
        return value;
    }

    public String getType() {
        return "NIF";
    }
}
