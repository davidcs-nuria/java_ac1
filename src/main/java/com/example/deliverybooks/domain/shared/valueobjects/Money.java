package com.example.deliverybooks.domain.shared.valueobjects;

import java.math.BigDecimal;
import java.util.Currency;

import com.example.deliverybooks.domain.shared.validators.Checker;

public record Money(
    BigDecimal value,
    Currency currency
) {
    public Money {
        Checker.bigDecIsPositive(value);
    }
}
