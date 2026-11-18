package com.example.deliverybooks.domain.shared.valueobjects;

import java.util.regex.Pattern;

public record Email(String email) {
    private static final Pattern EMAIL_PATTERN = Pattern.compile(
        "^[A-Za-z0-9+_&*-]+(?:\\.[A-Za-z0-9+_&*-]+)*@(?:[A-Za-z0-9.-]+\\.)+[A-Za-z]{2,7}$*"
    );

    public Email {
        if (email == null || email.trim().isEmpty()) throw new IllegalArgumentException("El correo no puede estar vacío");
    
        email = email.strip().toLowerCase();

        if (!EMAIL_PATTERN.matcher(email).matches()) throw new IllegalArgumentException("El formato del correo es incorrecto");
    }

    public String getDomain() {
        return email.substring(email.indexOf("@") + 1);
    }

    public String getValue() {
        return email;
    }
}
