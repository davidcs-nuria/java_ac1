package com.example.deliverybooks.domain.shared.validators;

import java.math.BigDecimal;

public class Checker {
    public static String notNullString(String s) {
        if (s == null) {
            throw new IllegalArgumentException("A Null string was given.");
        }
        return s;
    }
    public static String notEmptyString(String s) {
        String result = notNullString(s).trim();
        if (result.isEmpty()) {
            throw new IllegalArgumentException("An empty string was given.");
        }
        return result;
    }
    public static Integer intIsPositive(Integer n) {
        if (n < 0) {
            throw new IllegalArgumentException("The integer given is NOT positive.");
        }
        return n;
    }
    public static Integer intIsNegative(Integer n) {
        if (n >= 0) {
            throw new IllegalArgumentException("The integer given is NOT negative.");
        }
        return n;
    }
    public static long longIsPositive(long n) {
        if (n < 0) {
            throw new IllegalArgumentException("The long given is NOT positive.");
        }
        return n;
    }
    public static long longIsNegative(long n) {
        if (n >= 0) {
            throw new IllegalArgumentException("The long given is NOT negative.");
        }
        return n;
    }
    public static BigDecimal bigDecIsPositive(BigDecimal n) {
        if (n.compareTo(BigDecimal.ZERO) == 1) {
            return n;
        }
        throw new IllegalArgumentException("The Big Decimal given is NOT positive.");
    }
    public static BigDecimal bigDecIsNegative(BigDecimal n) {
        if (n.compareTo(BigDecimal.ZERO) == -1) {
            return n;
        }
        throw new IllegalArgumentException("The Big Decimal given is NOT negative.");
    }
    public static String minLengthString(String s, int minLength) {
        String result = s.trim();
        if (notEmptyString(result) == result && result.length() < minLength) {
            throw new IllegalArgumentException("The given string has less characters than specified.");
        }
        return result;
    }
    public static String stringBetweenLength(String s, int minLength, int maxLength) {
        String result = s.trim();
        if (minLengthString(result, minLength) == result && result.length() > maxLength) {
            throw new IllegalArgumentException("The given string has more characters than specified.");
        }
        return result;
    }
}
