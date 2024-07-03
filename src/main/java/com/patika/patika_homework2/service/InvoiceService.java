package com.patika.patika_homework2.service;

import com.patika.patika_homework2.model.Invoice;
import com.patika.patika_homework2.repostiry.InvoiceRepostiry;

import java.time.Month;
import java.util.List;
import java.util.stream.Collectors;

public class InvoiceService {
    private final InvoiceRepostiry  invoiceRepostiry = new InvoiceRepostiry();

    public void save(Invoice invoice) {

        invoiceRepostiry.add(invoice);

    }

    public List<Invoice> findAll() {

        return invoiceRepostiry.getInvoices();

    }

    public List<Invoice> getInvoice1500(){

        return invoiceRepostiry.getInvoices().stream().
                filter(invoice -> invoice.getAmount()>1500).
                collect(Collectors.toList());

    }

    public double getAvarage(){

        return invoiceRepostiry.getInvoices().stream()
                .filter(invoice -> invoice.getAmount()>1500).
                mapToDouble(Invoice::getAmount).average().orElse(0);

    }

    public double june(){
        return invoiceRepostiry.getInvoices().stream()
                .filter(invoice -> invoice.getDate().getMonth()== Month.JUNE)
                .mapToDouble(Invoice::getAmount).sum();
    }
}
