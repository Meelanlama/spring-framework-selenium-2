package com.milan.api;

public class CreditCard {
    private Integer firstFourDigits;
    private Integer secondFourDigits;
    private Integer thirdFourDigits;
    private Integer lastFourDigits;

    public Integer getFirstFourDigits() {
        return firstFourDigits;
    }

    public void setFirstFourDigits(Integer firstFourDigits) {
        this.firstFourDigits = firstFourDigits;
    }

    public Integer getLastFourDigits() {
        return lastFourDigits;
    }

    public void setLastFourDigits(Integer lastFourDigits) {
        this.lastFourDigits = lastFourDigits;
    }

    public Integer getThirdFourDigits() {
        return thirdFourDigits;
    }

    public void setThirdFourDigits(Integer thirdFourDigits) {
        this.thirdFourDigits = thirdFourDigits;
    }

    public Integer getSecondFourDigits() {
        return secondFourDigits;
    }

    public void setSecondFourDigits(Integer secondFourDigits) {
        this.secondFourDigits = secondFourDigits;
    }

    @Override
    public String toString() {
        return firstFourDigits + "-" + secondFourDigits + "-" + thirdFourDigits + "-" + lastFourDigits;
    }

}
