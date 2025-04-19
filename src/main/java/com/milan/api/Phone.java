package com.milan.api;

import com.milan.CustomAnnotations.PhoneAnno;

public class Phone {
    private String countryCode;
    @PhoneAnno
    private String userNumber;

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(String userNumber) {
        this.userNumber = userNumber;
    }

    @Override
    public String toString() {
       return getCountryCode() + "-" + getUserNumber();
    }
}
