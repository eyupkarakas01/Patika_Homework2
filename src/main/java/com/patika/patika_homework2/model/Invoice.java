package com.patika.patika_homework2.model;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class Invoice {
    private final double amount;
    private final LocalDate date;
    private final int orderID;

    public Invoice(double amount, LocalDate date, int orderID) {
        this.amount = amount;
        this.date = date;
        this.orderID = orderID;
    }
}
