package com.example.deliverybooks.domain.clients;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import com.example.deliverybooks.domain.shared.validators.Checker;
import com.example.deliverybooks.domain.shared.valueobjects.Addressc;
import com.example.deliverybooks.domain.shared.valueobjects.Email;
import com.example.deliverybooks.domain.shared.valueobjects.LegalID;
import com.example.deliverybooks.domain.shared.valueobjects.Phone;

public class Client {
    private LegalID legalID;
    private long clientID;
    private String name;
    private Email email;
    private Phone phone;
    private Addressc address;
    private LocalDate creationDate, birthDate;
    private DateTimeFormatter DEFAULT_FORMAT = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    private static String errorMessage = "";

    protected Client() {

    }

    public static Client of(String street, String city, String zipCode, String country, String birthDate, long clientID, String creationDate, String email, String name, String legalID, String phone) {
        var c = new Client();
        
        try {
            c.setLegalID(legalID);
        } catch (IllegalArgumentException e) {
            AddErrorMessage("Bad Legal ID: " + e.getMessage());
        }

        try {
            c.setClientID(clientID);
        } catch (IllegalArgumentException e) {
            AddErrorMessage("Bad Client ID: " + e.getMessage());
        }

        try {
            c.setAddress(street, city, zipCode, country);
        } catch (IllegalArgumentException e) {
            AddErrorMessage("Bad Address: " + e.getMessage());
        }

        try {
            c.setBirthDate(birthDate);
        } catch (IllegalArgumentException e) {
            AddErrorMessage("Bad Birth Date: " + e.getMessage());
        }

        try {
            c.setCreationDate(creationDate);
        } catch (IllegalArgumentException e) {
            AddErrorMessage("Bad Creation Date: " + e.getMessage());
        }

        try {
            c.setEmail(email);
        } catch (IllegalArgumentException e) {
            AddErrorMessage("Bad Email: " + e.getMessage());
        }

        try {
            c.setName(name);
        } catch (IllegalArgumentException e) {
            AddErrorMessage("Bad Full Name: " + e.getMessage());
        }

        try {
            c.setPhone(phone);
        } catch (IllegalArgumentException e) {
            AddErrorMessage("Bad Phone: " + e.getMessage());
        }

        if (!errorMessage.isEmpty()) {
            throw new IllegalArgumentException("Client build error: \n\n" + errorMessage);
        }

        return c;
    }

    private static void AddErrorMessage (String message) {
        if (!errorMessage.isEmpty()) {
            errorMessage += "\n";
        }
        errorMessage += message;
    }

    public String getLegalID() {
        return legalID.getValue();
    }

    public void setLegalID(String legalID) {
        try {
            Checker.stringBetweenLength(legalID, 9, 9);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
        this.legalID = LegalID.of(legalID);
    }

    public long getClientID() {
        return clientID;
    }

    public void setClientID(long clientID) {
        try {
            Checker.longIsPositive(clientID);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
        this.clientID = clientID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        try {
            Checker.minLengthString(name, 6);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
        this.name = name;
    }

    public String getEmail() {
        try {
            Checker.minLengthString(name, 6);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
        return email.toString();
    }

    public void setEmail(String email) {
        try {
            Checker.minLengthString(email, 6);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
        this.email = new Email(email);
    }

    public String getPhone() {
        return phone.toString();
    }

    public void setPhone(String phone) {
        try {
            Checker.minLengthString(phone, 9);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
        this.phone = new Phone(phone);
    }

    public String getAddress() {
        return address.toString();
    }

    public void setAddress(String street, String city, String zipCode, String country) {
        try {
            Checker.minLengthString(street, 8);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Bad Street: " + e.getMessage());
        }
        try {
            Checker.minLengthString(city, 8);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Bad City: " + e.getMessage());
        }
        try {
            Checker.stringBetweenLength(zipCode, 5, 5);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Bad Zip Code: " + e.getMessage());
        }
        try {
            Checker.minLengthString(country, 3);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Bad Country: " + e.getMessage());
        }
        this.address = new Addressc(street, city, zipCode, country);
    }

    public String getCreationDate() {
        return creationDate.toString();
    }

    public void setCreationDate(String creationDate) {
        try {
            this.creationDate = LocalDate.parse(creationDate, DEFAULT_FORMAT);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public String getBirthDate() {
        return birthDate.toString();
    }

    public void setBirthDate(String birthDate) {
        try {
            this.birthDate = LocalDate.parse(birthDate, DEFAULT_FORMAT);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public DateTimeFormatter getDEFAULT_FORMAT() {
        return DEFAULT_FORMAT;
    }

    public void setDEFAULT_FORMAT(DateTimeFormatter DEFAULT_FORMAT) {
        this.DEFAULT_FORMAT = DEFAULT_FORMAT;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Client{");
        sb.append("legalID=").append(legalID.getValue()).append("(").append(legalID.getClass()).append(")");
        sb.append(", clientID=").append(clientID);
        sb.append(", fullname=").append(name);
        sb.append(", email=").append(email.getValue());
        sb.append(", phone=").append(phone.getValue());
        sb.append(", address=").append("{").append(address.getValue()).append("}");
        sb.append(", creationDate=").append(creationDate);
        sb.append(", birthDate=").append(birthDate);
        sb.append("}\n\n");
        return sb.toString();
    }



}
