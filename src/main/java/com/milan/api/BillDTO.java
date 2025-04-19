package com.milan.api;

import com.milan.formatter.CurrencyFormatter;
import jakarta.validation.Valid;

import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

public class BillDTO {
    @Valid
    private CreditCard creditCard;
    private Amount amount;
    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    // Temporary field for combined input (not stored in Amount)
    private String amountString;

    public String getAmountString() {
        return amountString;
    }

    public void setAmountString(String amountString) {
        this.amountString = amountString;
        this.amount = parseAmount(amountString); // Convert automatically
    }

    private Amount parseAmount(String amountString) {
        if (amountString == null || amountString.trim().isEmpty())
            return null;

        CurrencyFormatter formatter = new CurrencyFormatter(); // Use your formatter
        try {
            return formatter.parse(amountString, Locale.US); // Use appropriate locale
        } catch (ParseException e) {
            System.out.println("Error parsing amount: " + e.getMessage());
            return null;
        }
    }
    public Amount getAmount() {
        return amount;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    public void setAmount(Amount amount) {
        this.amount = amount;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }
}
