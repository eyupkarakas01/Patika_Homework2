package com.patika.patika_homework2.model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Customer {

    private final String firstName;

    private final String sector;

    private final List<Order> orders;

    private final List<Invoice> invoices;

    public Customer(String firstName, String sector) {
        this.firstName = firstName;
        this.sector = sector;
        this.orders = new ArrayList<>();
        this.invoices = new ArrayList<>();
    }

    public void addOrder(Order order) {
        orders.add(order);
    }
    public void addInvoice(Invoice invoice) {
        invoices.add(invoice);
    }

}
