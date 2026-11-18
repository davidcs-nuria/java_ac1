package com.example.deliverybooks.functionals_manual;

import com.example.deliverybooks.domain.clients.Client;

public class clientTests {
    public static void main(String[] args) {
        System.out.print("---- PRUEBA DE CLIENTE ----\n");
        try {
            Client c = Client.of("Avinguda del Milenari", "Viladecans", "08840", "España", "21-09-2007", 0000001, "14-10-2026", "davidcampna.cefpnuria@gmail.com", "David Camnpaña", "12345678Z", "689233413");
            System.out.print(c.toString());
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }

        try {
            Client c = Client.of("Av. F", "W", "novfe", "Hey", "78-12-1344", 0, "14-10-2026", "@.", "NO", "38512412T", "124553124");
            System.out.print(c.toString());
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }
}
