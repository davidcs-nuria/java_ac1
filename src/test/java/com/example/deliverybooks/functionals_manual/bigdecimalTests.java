package com.example.deliverybooks.functionals_manual;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class bigdecimalTests {
    public static void main(String[] args) {
        BigDecimal valor = BigDecimal.TEN;
        System.out.println(valor);

        valor = new BigDecimal("2.763");
        System.out.println(valor);
        System.out.println(valor.stripTrailingZeros());

        BigDecimal result = valor.multiply(new BigDecimal("1234567890000"));
        System.out.println(result);

        BigDecimal result2 = valor.multiply(new BigDecimal("1234567890000"));
        System.out.println(result2.toPlainString());

        BigDecimal result3 = valor.divide(new BigDecimal("19"), 12, RoundingMode.HALF_UP);
        System.out.println(result3.toPlainString());

        if (result3.compareTo(valor) == 1) {
            System.out.println("Result 3 es mayor: " + result3 + " > " + valor);
        }
        

        if (result3.compareTo(valor) == -1) {
            System.out.println("Result 3 es menor: " + result3 + " < " + valor);
        }

        BigDecimal same = new BigDecimal("2.763");

        if (valor.compareTo(same) == 0) {
            System.out.println("Son el exacto mismo valor: " + same + " == " + valor);
        }
    }
}
