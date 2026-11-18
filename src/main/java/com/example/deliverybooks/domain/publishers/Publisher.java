package com.example.deliverybooks.domain.publishers;

import java.time.format.DateTimeFormatter;
import java.util.HashSet;

import com.example.deliverybooks.domain.books.Book;
import com.example.deliverybooks.domain.shared.validators.Checker;
import com.example.deliverybooks.domain.shared.valueobjects.Addressc;
import com.example.deliverybooks.domain.shared.valueobjects.Email;
import com.example.deliverybooks.domain.shared.valueobjects.LegalID;
import com.example.deliverybooks.domain.shared.valueobjects.Phone;
import com.example.deliverybooks.domain.shared.valueobjects.SocialMediaProfile;
import com.example.deliverybooks.domain.shared.valueobjects.WebSite;

public class Publisher {
    private LegalID legalID;
    private long clientID;
    private long publisherID;
    private String name;
    private Email email;
    private Phone phone;
    private Addressc address;
    private WebSite website;
    private HashSet<SocialMediaProfile> profiles;
    private HashSet<Book> bibliography;

    private DateTimeFormatter DEFAULT_FORMAT = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    private static String errorMessage = "";

    protected Publisher() {

    }

    public static Publisher of(String street, String city, String zipCode, String country, long clientID, String email, String name, String legalID, String phone) {
        var c = new Publisher();
        
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

    public long getPublisherID() {
        return publisherID;
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

    public DateTimeFormatter getDEFAULT_FORMAT() {
        return DEFAULT_FORMAT;
    }

    public void setDEFAULT_FORMAT(DateTimeFormatter DEFAULT_FORMAT) {
        this.DEFAULT_FORMAT = DEFAULT_FORMAT;
    }

    @Override
    public String toString() {
        return "Publisher [legalID=" + legalID + ", clientID=" + clientID + ", publisherID=" + publisherID + ", name="
                + name + ", email=" + email + ", phone=" + phone + ", address=" + address + ", website=" + website
                + ", profiles=" + profiles + ", bibliography=" + bibliography + "]";
    }
}
