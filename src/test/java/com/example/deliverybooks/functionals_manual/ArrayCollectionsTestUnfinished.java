package com.example.deliverybooks.functionals_manual;

import java.util.ArrayList;
import java.util.List;

public class ArrayCollectionsTestUnfinished {
    public static void main(String[] args) {
        System.out.println("1. CARGA");
        List<String> libros = new ArrayList<>();
        libros.add("El Quijote");
        libros.add("La Celestina");
        libros.add("Cien años de soledad");
        libros.add("El Quijote");
        libros.addAll(List.of("Rayuela", "Ficción"));
        System.out.println("Libros: " + libros);
        System.out.println("Cantidad: " + libros.size());
        
        System.out.println("\n2. RECORRIDO");

        // tbd

        System.out.println("Primer libro de la lista: " + libros.getFirst() /* podria ser tmb libros.get(0) */);
        System.out.println("Primer libro de la lista: " + libros.getLast() /* podria ser tmb libros.get(libros.size() - 1) */);
        
        System.out.println("\n3. ACTUALIZACIÓN");
        libros.set(1, "La Celestina (2ª revisión)");
    }
}
