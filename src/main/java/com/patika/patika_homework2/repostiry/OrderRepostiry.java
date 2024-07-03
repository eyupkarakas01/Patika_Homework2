package com.patika.patika_homework2.repostiry;

import com.patika.patika_homework2.model.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderRepostiry {

    private final List<Order> orders = new ArrayList<>();

    public void addOrder(Order order){
        orders.add(order);
    }
    public List<Order> getOrders(){
        return orders;
    }

}
