package com.example.deliverybooks.domain.shared.valueobjects;

import java.util.regex.Pattern;

import com.example.deliverybooks.domain.shared.validators.Checker;

public record Isbn(
    String isbn
) {
    private static final Pattern ISBN_13_PATTERN = Pattern.compile(
        "^97[89][-\\\\s]?84[-\\\\s]?[0-9]{1,5}[-\\\\s]?[0-9]{1,7}[-\\\\s]?[0-9]$"
    );

    private static final Pattern ISBN_10_PATTERN = Pattern.compile(
        "^84[-\\\\s]?[0-9]{1,5}[-\\\\s]?[0-9]{1,7}[-\\\\s]?[0-9Xx]$"
    );

    public Isbn {
        try {isbn = Checker.minLengthString(isbn, 10);} catch (IllegalArgumentException e) {throw new IllegalArgumentException("El ISBN es muy corto o vacio");}

        if (!ISBN_13_PATTERN.matcher(isbn).matches() || !ISBN_10_PATTERN.matcher(isbn).matches()) throw new IllegalArgumentException("El formato del ISBN es incorrecto");
    }

}
