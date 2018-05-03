package murach.business;

import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;

public class Invoice {

    // the instance variables
    private ArrayList<murach.business.LineItem> lineItems;
    private LocalDateTime invoiceDate;

    // the constructor
    public Invoice() {
        lineItems = new ArrayList<>();
        invoiceDate = LocalDateTime.now();
    }

    public void addItem(murach.business.LineItem lineItem) {
        lineItems.add(lineItem);
    }

    public ArrayList<murach.business.LineItem> getLineItems() {
        return lineItems;
    }

    public double getTotal() {
        double invoiceTotal = 0;
        for (murach.business.LineItem lineItem : lineItems) {
            invoiceTotal += lineItem.getTotal();
        }
        return invoiceTotal;
    }

    public String getTotalFormatted() {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        return currency.format(getTotal());
    }

    public void setInvoiceDate(LocalDateTime invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public LocalDateTime getInvoiceDate() {
        return invoiceDate;
    }


    public String getInvoiceDateFormatted() {
        DateTimeFormatter dtf = DateTimeFormatter.ofLocalizedDate(
                FormatStyle.MEDIUM);
        return dtf.format(invoiceDate);
    }

    public LocalDateTime getDueDate() {
        LocalDateTime dueDate = invoiceDate.plusDays(30);
        return dueDate;
    }

    public String getDueDateFormatted() {
        DateTimeFormatter dtf = DateTimeFormatter.ofLocalizedDate(
                FormatStyle.MEDIUM);
        return dtf.format(getDueDate());
    }
}