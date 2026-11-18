package com.example.deliverybooks.domain.shared.valueobjects;

import java.math.BigDecimal;

import com.example.deliverybooks.domain.shared.validators.Checker;

public final class Weight {
    private BigDecimal value;
    private WeightUnit unit;

    public Weight(BigDecimal value, WeightUnit unit) {
        this.setValue(value);
        this.setUnit(unit);
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = Checker.bigDecIsPositive(value);
    }

    public WeightUnit getUnit() {
        return unit;
    }

    public void setUnit(WeightUnit unit) {
        this.unit = unit;
    }
}
