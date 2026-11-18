package com.example.deliverybooks.domain.shared.valueobjects;
import com.example.deliverybooks.domain.shared.validators.Checker;

public final class Addressc {
    private String street, city, zipCode, country;

    public Addressc(String street, String city, String zipCode, String country) {
        this.setStreet(street);
        this.setCity(city);
        this.setZipCode(zipCode);
        this.setCountry(country);
    }

    @Override
    public String toString() {
        return "Addressc [street=" + street + ", city=" + city + ", zipCode=" + zipCode + ", country=" + country + "]";
    }

    public String getStreet() {
        return this.street;
    }

    public void setStreet(String street) {
        this.street = Checker.minLengthString(street, 5);
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = Checker.minLengthString(city, 3);
    }

    public String getZipCode() {
        return this.zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = Checker.stringBetweenLength(zipCode, 5, 5);
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = Checker.minLengthString(country, 5);
    }

    public String getValue() {
        return this.street + ", " + this.city + ", " + this.zipCode + ", " + this.country;
    }
}
