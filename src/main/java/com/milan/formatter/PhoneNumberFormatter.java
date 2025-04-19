package com.milan.formatter;

import com.milan.api.Phone;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class PhoneNumberFormatter implements Formatter<Phone> {

    @Override
    public Phone parse(String completePhoneNumber, Locale locale) throws ParseException {
        System.out.println("Inside PhoneNumberFormatter parse");

        Phone phone = new Phone();

        if (completePhoneNumber == null || completePhoneNumber.isEmpty()) {
            // Handle invalid input scenario
            phone.setCountryCode("977"); // Default country code
            phone.setUserNumber(""); // Empty number
            return phone;
        }

        //Split the string phone number received from the user
        // Will get two array[0,1], one will get code and another number
        String[] phoneNumbers = completePhoneNumber.split("-");

        //whether the number consists of - which is country code
       int index = completePhoneNumber.indexOf('-');

        // if - country code is not found which returns -1 index then add 977 as default country code
        // if the - index is in 0 index, then add default country code. Ex: if user enters -9863837952 without code
        if(index == -1 || completePhoneNumber.startsWith("-")){
           phone.setCountryCode("977");
           if(index == -1){
               phone.setUserNumber(phoneNumbers[0]);
           } else {
               phone.setUserNumber(phoneNumbers[1]);
           }
       }else {
            phone.setCountryCode(phoneNumbers[0]);
            phone.setUserNumber(phoneNumbers[1]);
        }
        return phone;
    }

    @Override
    public String print(Phone phoneObject, Locale locale) {
        return phoneObject.getCountryCode() + "-" + phoneObject.getUserNumber();
    }
}
