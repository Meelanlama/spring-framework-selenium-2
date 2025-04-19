package com.milan.api;

import java.math.BigDecimal;

public class Amount {
    private BigDecimal billAmount;
    //bind the string format to sign
    private String localeDefinition; // e.g., USD, EUR

    public BigDecimal getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(BigDecimal billAmount) {
        this.billAmount = billAmount;
    }

    public String getLocaleDefinition() {
        return localeDefinition;
    }

    public void setLocaleDefinition(String localeDefinition) {
        this.localeDefinition = localeDefinition;
    }

    @Override
    public String toString() {
        return getLocaleDefinition();
    }
}
