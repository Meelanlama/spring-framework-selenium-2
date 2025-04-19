package com.milan.formatter;

import com.milan.api.Amount;
import org.springframework.format.Formatter;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Currency;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CurrencyFormatter implements Formatter<Amount> {

    private static final Pattern AMOUNT_PATTERN = Pattern.compile("([0-9]+(\\.[0-9]+)?)\\s*([A-Za-z]{3})?");

    @Override
    public Amount parse(String text, Locale locale) throws ParseException {
        if (text == null || text.trim().isEmpty()) {
            throw new ParseException("Amount cannot be empty", 0);
        }

        Matcher matcher = AMOUNT_PATTERN.matcher(text.trim());
        if (!matcher.matches()) {
            throw new ParseException("Invalid amount format. Expected format: '10 USD'", 0);
        }

        Amount amount = new Amount();
        amount.setBillAmount(new BigDecimal(matcher.group(1))); // Extract numeric value

        if (matcher.group(3) != null) {
            amount.setLocaleDefinition(matcher.group(3)); // Extract currency if provided
        } else {
            amount.setLocaleDefinition("USD"); // Default currency if missing
        }

        return amount;
    }

    @Override
    public String print(Amount amount, Locale locale) {
        if (amount == null || amount.getBillAmount() == null) {
            return "";
        }

        try {
            // Get the correct currency based on the amount's localeDefinition (USD, EUR, etc.)
            Currency currency = Currency.getInstance(amount.getLocaleDefinition());

            // Use NumberFormat to format with the correct currency symbol
            NumberFormat format = NumberFormat.getCurrencyInstance(locale);

            format.setCurrency(currency);
            // Return the formatted amount
            return format.format(amount.getBillAmount());
        } catch (IllegalArgumentException e) {
            return amount.getBillAmount() + " " + amount.getLocaleDefinition(); // Fallback
        }
    }
}
