package com.example.deliverybooks.functionals_manual;

import com.example.deliverybooks.domain.shared.valueobjects.Cif;
import com.example.deliverybooks.domain.shared.valueobjects.LegalID;
import com.example.deliverybooks.domain.shared.valueobjects.Nie;
import com.example.deliverybooks.domain.shared.valueobjects.Nif;

public class LegalIDtests {
    public static void main(String[] args) {
        System.out.println("=== PRUEBAS DE DETECCIÓN AUTOMÁTICA DE LEGAL ID ===");

        // 1. Strings de prueba (sin especificar el tipo)
        String[] inputs = {
            "91587344X", // Debería ser Nif
            "X9637144Y", // Debería ser Nie
            "A12626628"  // Debería ser Cif
        };

        // 2. Detección automática mediante la factoría
        for (String input : inputs) {
            try {
                LegalID id = LegalID.of(input);
                printIdDetails(id);
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        // 3. Prueba de formato no reconocido
        try {
            LegalID.of("999999999");
        } catch (IllegalArgumentException e) {
            System.out.println("\n[ÉXITO] Detección de formato inválido: " + e.getMessage());
        }
    }

    // Método que utiliza pattern matching para switch para comprobar el tipo asignado
    public static void printIdDetails(LegalID id) {
        String tipo = switch (id) {
            case Cif c -> "Detectado CIF (Empresa) -> " + c.value();
            case Nif n -> "Detectado NIF (Particular) -> " + n.value();
            case Nie e -> "Detectado NIE (Extranjero) -> " + e.value();
        };
        
        System.out.println(tipo);
    }
}
