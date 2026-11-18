package com.example.deliverybooks.domain.shared.valueobjects;

public sealed interface LegalID permits Cif, Nif, Nie {
    
    String getValue();

    // Método factoría para detectar y asignar el record automáticamente
    static LegalID of(String value) {
        if (value.trim() == null || value.trim().isBlank()) {
            throw new IllegalArgumentException("El identificador no puede estar vacío");
        }

        String cleaned = value.trim().replace("-", "").replace(" ", "").toUpperCase();

        // 1. Validar NIE (X, Y, Z + 7 dígitos + Letra de control)
        if (cleaned.matches("^[XYZ]\\d{7}[A-Z]$")) {
            if (!isValidNie(cleaned)) {
                throw new IllegalArgumentException("NIE inválido (la letra de control no coincide): " + cleaned);
            }
            return new Nie(cleaned);
        }
        // 2. Validar NIF (8 dígitos + Letra de control)
        else if (cleaned.matches("^\\d{8}[A-Z]$")) {
            if (!isValidNif(cleaned)) {
                throw new IllegalArgumentException("NIF inválido (la letra de control no coincide): " + cleaned);
            }
            return new Nif(cleaned);
        }
        // 3. Validar CIF (Letra + 7 dígitos + Dígito/Letra de control)
        else if (cleaned.matches("^[ABCDEFGHJKLMNPQRSUVW]\\d{7}[0-9A-J]$")) {
            if (!isValidCif(cleaned)) {
                throw new IllegalArgumentException("CIF inválido (el dígito/letra de control no coincide): " + cleaned);
            }
            return new Cif(cleaned);
        } else {
            throw new IllegalArgumentException("Formato de identificador no reconocido: " + value);
        }
    }
    
    private static boolean isValidNif(String nif) {
        String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
        int dniNumber = Integer.parseInt(nif.substring(0, 8));
        char expectedLetter = letras.charAt(dniNumber % 23);
        return nif.charAt(8) == expectedLetter;
    }

    private static boolean isValidNie(String nie) {
        char firstChar = nie.charAt(0);
        String convertedPrefix = switch (firstChar) {
            case 'X' -> "0";
            case 'Y' -> "1";
            case 'Z' -> "2";
            default -> "0";
        };
        // Sustituimos la letra inicial por su número equivalente y validamos como un NIF
        String equivalentNif = convertedPrefix + nie.substring(1);
        return isValidNif(equivalentNif);
    }

    private static boolean isValidCif(String cif) {
        int sumaPares = 0;
        int sumaImpares = 0;
        
        for (int i = 1; i <= 6; i += 2) {
            int digito = Character.getNumericValue(cif.charAt(i));
            sumaPares += digito;
        }

        for (int i = 2; i <= 7; i += 2) {
            int digito = Character.getNumericValue(cif.charAt(i)) * 2;
            sumaImpares += (digito / 10) + (digito % 10); // Sumar los dígitos si el resultado es de 2 cifras
        }

        int sumaTotal = sumaPares + sumaImpares;
        int unidadControl = (10 - (sumaTotal % 10)) % 10;
        
        char expectedControlChar = cif.charAt(8);
        char expectedControlDigit = (char) ('0' + unidadControl);
        
        // Algunas letras de control de CIF pueden ser letras (J, A-I) según el tipo de entidad
        String letrasControl = "JABCDEFGHI";
        char expectedControlLetter = letrasControl.charAt(unidadControl);

        // Comprobamos si coincide con el dígito numérico o su equivalente en letra
        return expectedControlChar == expectedControlDigit || expectedControlChar == expectedControlLetter;
    }
}