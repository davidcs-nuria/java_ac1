package com.example.deliverybooks.domain.shared.valueobjects;

import com.example.deliverybooks.domain.shared.validators.Checker;

public record Addressr(
    String street,
    String city,
    String zipCode,
    String country
) {
    public Addressr {
        Checker.minLengthString(street, 5);
        Checker.minLengthString(city, 3);
        Checker.stringBetweenLength(zipCode, 5, 5);
        Checker.minLengthString(country, 3);
    }

    public String getValue() {
        return "street="+street+
                ",city="+city+
                ",zipCode="+zipCode+
                ",country="+country;
    }

    /*public void streetSet(String s) {
        street = Checker.maxLengthString(s, 3, 20);
    }*/
}
