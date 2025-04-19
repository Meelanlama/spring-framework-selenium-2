package com.milan.Converter;

import com.milan.api.CreditCard;
import org.springframework.core.convert.converter.Converter;

public class CreditToString implements Converter<CreditCard,String> {

    @Override
    public String convert(CreditCard creditCard) {
        return "Converter: " + creditCard.toString();
    }
}
