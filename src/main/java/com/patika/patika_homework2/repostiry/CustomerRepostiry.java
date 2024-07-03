package com.patika.patika_homework2.repostiry;

import com.patika.patika_homework2.model.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomerRepostiry {
    List<Customer> customers=new ArrayList<>();

    public void add(Customer customer){

        customers.add(customer);

    }

    public List<Customer> getCustomers() {

        return customers;

    }

    public Optional<Customer> getCustomerByName(String name){

        return customers.stream().filter(customer -> customer.getFirstName().equals(name)).findFirst();

    }
}
