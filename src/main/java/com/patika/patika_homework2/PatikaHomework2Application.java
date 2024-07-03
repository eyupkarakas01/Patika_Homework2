package com.patika.patika_homework2;

import com.patika.patika_homework2.model.Customer;
import com.patika.patika_homework2.model.Invoice;
import com.patika.patika_homework2.model.Order;
import com.patika.patika_homework2.service.CustomerService;
import com.patika.patika_homework2.service.InvoiceService;
import com.patika.patika_homework2.service.OrderService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class PatikaHomework2Application {

	public static void main(String[] args) {

		InvoiceService invoiceService = new InvoiceService();
		OrderService orderService = new OrderService();
		CustomerService customerService = new CustomerService(orderService,invoiceService);

		Customer customer1 = new Customer("Eyüp","software");
		Customer customer2 = new Customer("Ceren","education");
		Customer customer3 = new Customer("Hasan","textile");
		Customer customer4 = new Customer("Burhan","software");

		customerService.addCustomer(customer1);
		customerService.addCustomer(customer2);
		customerService.addCustomer(customer3);
		customerService.addCustomer(customer4);

		Order order1 = new Order(1, LocalDate.of(2024,7,15),300);
		Order order2 = new Order(2, LocalDate.of(2024,6,15),700);
		Order order3 = new Order(3, LocalDate.of(2024,6,15),700);

		orderService.save(order1);
		orderService.save(order2);
		orderService.save(order3);

		customerService.addOrderToCustomer("Selma",order1);
		customerService.addOrderToCustomer("Eren",order2);
		customerService.addOrderToCustomer("Hasan",order3);

		Invoice invoice1 = new Invoice(1200,LocalDate.of(2024,6,15),1);
		Invoice invoice2 = new Invoice(200,LocalDate.of(2024,5,10),2);
		Invoice invoice3 = new Invoice(2000,LocalDate.of(2024,6,20),3);

		customerService.addInvoicetoCustomer("Selma",invoice1);
		customerService.addInvoicetoCustomer("Eren",invoice2);
		customerService.addInvoicetoCustomer("Hasan",invoice3);

		System.out.println("All Customers :");
		customerService.getAllCustomers().forEach(c-> System.out.println(c.getFirstName()));

		System.out.println("Customer with letter 'C' ");
		customerService.getCustomersC().forEach(c-> System.out.println(c.getFirstName()));

		System.out.println("Total Amount Of Invoices of customer who registered in June :");
		System.out.println(invoiceService.june());

		System.out.println("All invoices :");
		invoiceService.findAll().forEach(invoice -> System.out.println(invoice.getAmount()));

		System.out.println("Invoices over 1500 :");
		invoiceService.getInvoice1500().forEach(invoice -> System.out.println(invoice.getAmount()));

		System.out.println("Average of invoices over 1500 :");
		System.out.println(invoiceService.getAvarage());

		System.out.println("Names of customers with invoices under 500 :");
		customerService.customerNamesWithBelow500().forEach(name -> System.out.println(name));

		System.out.println("Sectors of the companies with average invoices below 750 in June :");
		customerService.getSectorsWithJuneInvoiceBelow750().forEach(System.out::println);

		System.out.println("All orders :");
		orderService.findAll().forEach(order -> System.out.println("ID :"+order.getOrderID()+" Total Amount:"+order.getTotalAmount()));

		System.out.println("Orders over 1500 :");
		orderService.getAboveAmount(1500).forEach(order -> System.out.println("ID :"+order.getOrderID()+" Total Amount:"+order.getTotalAmount()));




	}

}
