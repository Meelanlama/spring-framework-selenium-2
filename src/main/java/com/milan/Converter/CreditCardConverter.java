package com.milan.Converter;

import com.milan.api.CreditCard;
import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;

//I want to convert string object to a Credit card object
public class CreditCardConverter implements Converter<String, CreditCard> {

    @Override
    public CreditCard convert(String creditNumber) {
        System.out.println("Inside credit card converter");

        CreditCard creditCard = new CreditCard();

        if (creditNumber == null || creditNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("Credit card number is empty or null");
        }

        String[] creditNumberParts = creditNumber.trim().split("-");

        if (creditNumberParts.length != 4) {
            throw new IllegalArgumentException("Invalid credit card format. Expected format: XXXX-XXXX-XXXX-XXXX");
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
            throw new IllegalArgumentException("Credit card number must contain only numeric values");
        }
        return creditCard;
    }
}
