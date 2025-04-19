package com.milan.PropertyEditor;

import com.milan.api.CreditCard;

import java.beans.PropertyEditorSupport;

public class CreditCardEditor extends PropertyEditorSupport {

    @Override
    public String getAsText() {
        //Converting into CreditCard type object
        CreditCard creditCard = (CreditCard)getValue();
        return "Sample: " + creditCard;
    }

    @Override
    public void setAsText(String creditNumber) throws IllegalArgumentException {
        System.out.println("Inside credit card property editor");

        //creating credit card object
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
        setValue(creditCard);
    }
}
