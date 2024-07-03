package com.patika.patika_homework2.service;

import com.patika.patika_homework2.model.Order;
import com.patika.patika_homework2.repostiry.OrderRepostiry;

import java.util.List;
import java.util.stream.Collectors;

public class OrderService {

    private final OrderRepostiry orderRepostiry = new OrderRepostiry();

    public void save(Order order){
        orderRepostiry.addOrder(order);
    }

    public List<Order> findAll(){
        return orderRepostiry.getOrders();
    }

    public List<Order> getAboveAmount(double amount){
        return orderRepostiry.getOrders().stream().filter(order -> order.getTotalAmount()>amount).collect(Collectors.toList());
    }
}
