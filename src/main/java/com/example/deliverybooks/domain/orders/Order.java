package com.example.deliverybooks.domain.orders;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import com.example.deliverybooks.domain.orders.valueobjects.OrderDetails;

import com.example.deliverybooks.domain.clients.Client;

public class Order {
    private long id;
    private Client client;
    private LocalDateTime orderTime;
    private HashSet<OrderDetails> items;

    private DateTimeFormatter DEFAULT_FORMAT = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    private static String errorMessage = "";

    protected Order () {}

    public static Order of(long id, Client client, LocalDateTime orderTime, HashSet<OrderDetails> items) {
        var o = new Order();

        try {
            o.setId(id);
        }
        catch (IllegalArgumentException e) {
            AddErrorMessage("Bad ID: " + e.getMessage());
        }

        try {
            o.setClient(client);
        }
        catch (IllegalArgumentException e) {
            AddErrorMessage("Bad Client: " + e.getMessage());
        }

        try {
            o.setOrderTime(orderTime);
        }
        catch (IllegalArgumentException e) {
            AddErrorMessage("Bad Order Time: " + e.getMessage());
        }

        try {
            o.setItems(items);
        }
        catch (IllegalArgumentException e) {
            AddErrorMessage("Bad Items: " + e.getMessage());
        }

        if (!errorMessage.isEmpty()) {
            throw new IllegalArgumentException("Client build error: \n\n" + errorMessage);
        }

        return o;
    }

    private static void AddErrorMessage (String message) {
        if (!errorMessage.isEmpty()) {
            errorMessage += "\n";
        }
        errorMessage += message;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
    }

    public HashSet<OrderDetails> getItems() {
        return items;
    }

    public void setItems(HashSet<OrderDetails> items) {
        this.items = items;
    }
}
