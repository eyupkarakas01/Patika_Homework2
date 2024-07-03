package com.patika.patika_homework2.repostiry;

import com.patika.patika_homework2.model.Invoice;

import java.util.ArrayList;
import java.util.List;

public class InvoiceRepostiry {

    private final List<Invoice> invoices=new ArrayList<>();

    public void add(Invoice invoice) {

        invoices.add(invoice);

    }

    public List<Invoice> getInvoices() {
        return invoices;
    }
}
