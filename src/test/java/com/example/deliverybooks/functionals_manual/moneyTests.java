package com.example.deliverybooks.functionals_manual;

import java.math.BigDecimal;
import java.util.Currency;

import com.example.deliverybooks.domain.shared.valueobjects.Money;

public class moneyTests {
    public static void main(String[] args) {
        System.out.print("---- PRUEBA DE MONEY ----\n");
        try {
            Money m = new Money(new BigDecimal("6.9"), Currency.getInstance("EUR"));
            System.out.print(m.toString());
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }
}
