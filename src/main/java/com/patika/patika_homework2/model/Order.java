package com.patika.patika_homework2.model;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class Order {

    private final int orderID;
    private final LocalDate orderDate;
    private final double totalAmount;

    public Order(int orderID, LocalDate orderDate, double totalAmount) {
        this.orderID = orderID;
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
    }
}
