package com.example.deliverybooks.domain.shared.valueobjects;

public record ZipCodeAI(String codigo) {
    
    // Constructor compacto para validar el formato español
    public ZipCodeAI {
        if (codigo == null || !codigo.matches("\\d(0-9){5}")) {
            throw new IllegalArgumentException("El código postal de España debe tener exactamente 5 dígitos.");
        }
    }
}

