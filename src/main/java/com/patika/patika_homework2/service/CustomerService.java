package com.patika.patika_homework2.service;

import com.patika.patika_homework2.model.Customer;
import com.patika.patika_homework2.model.Invoice;
import com.patika.patika_homework2.model.Order;
import com.patika.patika_homework2.repostiry.CustomerRepostiry;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class CustomerService {

   private final CustomerRepostiry customerRepostiry=new CustomerRepostiry();

   private final InvoiceService invoiceService;

   private final OrderService orderService;

    public CustomerService(OrderService orderService,InvoiceService invoiceService) {
        this.orderService = orderService;
        this.invoiceService = invoiceService;
    }

    public void addCustomer(Customer customer) {
        customerRepostiry.add(customer);
    }

    public void addInvoicetoCustomer(String customerName, Invoice invoice) {
        customerRepostiry.getCustomerByName(customerName).ifPresent(customer ->{
            customer.addInvoice(invoice);
            invoiceService.save(invoice);
             }
        );
    }

    public void addOrderToCustomer(String customerName, Order order) {

        customerRepostiry.getCustomerByName(customerName)
                .ifPresent(customer ->{customer.addOrder(order);orderService.save(order);});

    }

    public List<Customer> getAllCustomers() {

        return customerRepostiry.getCustomers();

    }

    public List<Customer> getCustomersC(){

        return customerRepostiry.getCustomers().stream()
                .filter(customer -> customer.getFirstName().toLowerCase(Locale.ROOT)
                        .contains("c")).collect(Collectors.toList());

    }

    public List<String> customerNamesWithBelow500(){
        return customerRepostiry.getCustomers().stream().filter(customer -> customer.getInvoices()
                        .stream().anyMatch(invoice -> invoice.getAmount()<500))
                .map(Customer::getFirstName).collect(Collectors.toList());
    }

    public List<String> getSectorsWithJuneInvoiceBelow750(){
        return customerRepostiry.getCustomers().stream().
                filter(customer -> customer.getInvoices().stream().filter(invoice -> invoice.getDate().getMonth()== Month.JUNE)
                .mapToDouble(Invoice::getAmount).average().orElse(0)<750).map(Customer::getSector)
                .collect(Collectors.toList());
    }
}
