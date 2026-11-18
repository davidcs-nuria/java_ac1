package com.example.deliverybooks.functionals_manual;

import com.example.deliverybooks.domain.shared.valueobjects.Emailr;

public class EmailTests {
    public static void main(String[] args) {
        try {
            Emailr e = new Emailr ("davidcampna.cefpnuria@gmail.com");
            System.out.println("Correo aceptado: "+e.email());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            Emailr e = new Emailr ("");
            System.out.println("Correo aceptado: "+e.email());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            Emailr e = new Emailr ("_2763...@ytt.tr");
            System.out.println("Correo aceptado: "+e.email());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            Emailr e = new Emailr ("");
            System.out.println("Correo aceptado: "+e.email());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            Emailr e = new Emailr ("");
            System.out.println("Correo aceptado: "+e.email());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
