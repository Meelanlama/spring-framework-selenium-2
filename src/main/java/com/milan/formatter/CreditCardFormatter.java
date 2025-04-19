package com.milan.formatter;

import com.milan.api.CreditCard;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class CreditCardFormatter implements Formatter<CreditCard> {

    @Override
    public CreditCard parse(String creditNumber, Locale locale) throws ParseException {
        System.out.println("Inside credit card formatter");
        CreditCard creditCard = new CreditCard();

        if (creditNumber == null || creditNumber.trim().isEmpty()) {
            throw new ParseException("Credit card number is empty or null", 0);
        }

        String[] creditNumberParts = creditNumber.trim().split("-");

        if (creditNumberParts.length != 4) {
            throw new ParseException("Invalid credit card format. Expected format: XXXX-XXXX-XXXX-XXXX", 0);
        }

        for (String part : creditNumberParts) {
            if (!part.matches("\\d{4}")) { // Ensures exactly 4 digits per section
                throw new IllegalArgumentException("Each section of the credit card must have exactly 4 numeric digits.");
            }
        }

        try{
            creditCard.setFirstFourDigits(Integer.parseInt(creditNumberParts[0]));
            creditCard.setSecondFourDigits(Integer.parseInt(creditNumberParts[1]));
            creditCard.setThirdFourDigits(Integer.parseInt(creditNumberParts[2]));
            creditCard.setLastFourDigits(Integer.parseInt(creditNumberParts[3]));
        }catch (NumberFormatException e){
            throw new ParseException("Credit card number must contain only numeric values", 0);
        }

        return creditCard;
    }

    @Override
    public String print(CreditCard creditObject, Locale locale) {
        return creditObject.getFirstFourDigits() + "-" + creditObject.getSecondFourDigits() + "-"+  creditObject.getThirdFourDigits() + "-" + creditObject.getLastFourDigits();
    }
}
