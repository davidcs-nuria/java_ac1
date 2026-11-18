package com.example.deliverybooks.domain.shared.valueobjects;

public record Cif(String value) implements LegalID {

    // Constructor compacto para validar que el CIF no sea nulo ni esté vacío
    public Cif {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("El CIF no puede estar vacío.");
        }
        // Opcional: Aquí podrías añadir una expresión regular para validar el formato oficial del CIF
    }

    @Override
    public String getValue() {
        return value;
    }

    public String getType() {
        return "CIF";
    }
}
