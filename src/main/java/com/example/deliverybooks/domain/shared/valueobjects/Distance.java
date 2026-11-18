package com.example.deliverybooks.domain.shared.valueobjects;

import java.math.BigDecimal;
import java.util.Objects;

public class Distance {
    // --- Sistema Métrico ---
    MILLIMETER(new BigDecimal("1.0"), "mm"),
    CENTIMETER(new BigDecimal("10.0"), "cm"),
    METER(new BigDecimal("1000.0"), "m"),
    KILOMETER(new BigDecimal("1000000.0"), "km"),

    // --- Sistema Imperial / Anglosajón ---
    INCH(new BigDecimal("25.4"), "in"),          // 1 pulgada = 25.4 mm exactos
    FOOT(new BigDecimal("304.8"), "ft"),         // 1 pie = 12 pulgadas = 304.8 mm exactos
    YARD(new BigDecimal("914.4"), "yd"),         // 1 yarda = 3 pies = 914.4 mm exactos
    MILE(new BigDecimal("1609344.0"), "mi"),     // 1 milla = 1609.344 metros = 1609344 mm exactos

    // --- Unidad de Gran Escala ---
    ASTRONOMICAL_UNIT(new BigDecimal("149597870700000.0"), "au"); // 1 UA en mm exactos

    private final BigDecimal millimetersPerUnit;
    private final String abbreviation;

    Distance(BigDecimal millimetersPerUnit, String abbreviation) {
        this.millimetersPerUnit = millimetersPerUnit;
        this.abbreviation = abbreviation;
    }

    public BigDecimal getMillimetersPerUnit() {
        return millimetersPerUnit;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public Distance multiplicar(BigDecimal factor) {
        Objects.requireNonNull(factor, "El factor no puede ser nulo");
        return new Distance(this.millimetersPerUnit.multiply(factor), "mm");
    }
}
