package com.example.deliverybooks.functionals_manual;

import com.example.deliverybooks.domain.shared.valueobjects.Emailr;
import com.example.deliverybooks.domain.shared.valueobjects.Phone;

public class PhoneTests {
    public static void main(String[] args) {
        try {
            Phone p = new Phone ("davidcampna.cefpnuria@gmail.com");
            System.out.println("Correo aceptado: "+p.phone());
        }
        catch (IllegalArgumentException e) {
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
