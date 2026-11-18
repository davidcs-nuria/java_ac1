package com.example.deliverybooks.domain.shared.valueobjects;

import java.math.BigDecimal;

public enum WeightUnit {
    GRAM(new BigDecimal("1.0"), "g"),
    KILOGRAM(new BigDecimal("1000.0"), "kg"),
    OUNCE(new BigDecimal("28.349523125"), "oz"),
    POUND(new BigDecimal("453.59237"), "lb");

    private final BigDecimal gramsPerUnit;
    private final String abbreviation;

    WeightUnit(BigDecimal gramsPerUnit, String abbreviation) {
        this.gramsPerUnit = gramsPerUnit;
        this.abbreviation = abbreviation;
    }

    public BigDecimal getGramsPerUnit() {
        return gramsPerUnit;
    }

    public String getAbbreviation() {
        return abbreviation;
    }
}
