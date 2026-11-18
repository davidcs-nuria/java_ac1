package com.example.deliverybooks.domain.shared.valueobjects;

import java.util.regex.Pattern;

import com.example.deliverybooks.domain.shared.validators.Checker;

public record Emailr(String email) {
    private static final Pattern EMAIL_PATTERN = Pattern.compile(
        "[a-z0-9!#$%&\'*+/=?^_\'{|}~-]+(?:.[a-z0-9!#$%&\'*+/=?^_\'{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?"
    );

    public Emailr {
        try {email = Checker.minLengthString(email, 10);} catch (IllegalArgumentException e) {throw new IllegalArgumentException("El correo no puede estar vacío");};
    
        email = email.strip().toLowerCase();

        if (!EMAIL_PATTERN.matcher(email).matches()) throw new IllegalArgumentException("El formato del correo es incorrecto");
    }

    public String getDomain() {
        return email.substring(email.indexOf("@") + 1);
    }
}
