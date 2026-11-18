package com.example.deliverybooks.functionals_manual;

import com.example.deliverybooks.domain.shared.valueobjects.Addressr;
import com.example.deliverybooks.domain.shared.valueobjects.Addressc;

public class ValueObjectsTests {
    public static void main(String[] args) {
        System.out.println("FUNCTIONAL MANUAL TESTS");

        try {
            Addressr adr = new Addressr("Carrer", "Barcelona", "08001", "España");
            System.out.println(adr.getValue());
            // System.out.println(adr.toString());
            System.out.println(adr.country());
            // adr.country() = "Francia";                   --> Se valida imputabilidad
            Addressr adr2 = new Addressr("Carrer", "Barcelona", "08001", "España");

            if (adr == adr2) {          //  Salta falso porque no son la misma variable.
                System.out.println("The given adresses are the same!");
            } else {
                System.out.println("The given adresses are NOT the same!!");
            }

            if (adr.equals(adr2)) {     //  Salta verdadero porque los datos son los mismos.
                System.out.println("The given adresses are the same!");
            } else {
                System.out.println("The given adresses are NOT the same!!");
            }
        } catch (IllegalArgumentException e) {
            System.err.println("ERROR: "+e.getMessage());
        }

        try {
            Addressc adc = new Addressc("Carrer", "Barcelona", "08001", "España");
            System.out.println(adc.toString());
            // System.out.println(adr.toString());
            adc.setCountry("Portugal");
            System.out.println(adc.getCity() + " : " + adc.getCountry());
        } catch (IllegalArgumentException e) {
            System.err.println("ERROR: "+e.getMessage());
        }
    }
}
