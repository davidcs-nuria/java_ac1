package com.example.deliverybooks.domain.shared.valueobjects;

import java.util.regex.Pattern;

public record Phone(String phone) {
    // Constructor compacto para validar el formato español

        // private static final Pattern REGEX_PHONE_ES = Pattern.compile( "(?:(?:\\+34|0034)[ -]?)?[6789]\\\\d{8}");
        private static final Pattern REGEX_PHONE_ES = Pattern.compile( "(\\+34|0034|34)?[ -]*(6|7)[ -]*([0-9][ -]*){8}");

        public Phone {
            if (phone == null || !REGEX_PHONE_ES.matcher(phone).matches()) {
                throw new IllegalArgumentException(
                    "El teléfono español debe tener 9 dígitos y empezar por 6, 7, 8 o 9."
                );
            }
        }

        /**
         * Devuelve el número de teléfono con el prefijo internacional de España.
         */
        public String conPrefijoInternacional() {
            return "+34" + phone;
        }

        public String getValue() {
            return phone;
        }
}
