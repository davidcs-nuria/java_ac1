package com.example.deliverybooks.domain.orders.valueobjects;

import com.example.deliverybooks.domain.books.Book;
import com.example.deliverybooks.domain.shared.valueobjects.Money;

public final class OrderDetails {
    private Book book;
    private Integer quant;
    private Money salePrice;

    public OrderDetails(Book book, Integer quant, Money salePrice) {
        this.setBook(book);
        this.setQuant(quant);
        this.setSalePrice(salePrice);
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Integer getQuant() {
        return quant;
    }

    public void setQuant(Integer quant) {
        this.quant = quant;
    }

    public Money getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Money salePrice) {
        this.salePrice = salePrice;
    }
}
