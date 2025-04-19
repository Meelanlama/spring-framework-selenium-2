package com.milan.CustomAnnotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PhoneValidator implements ConstraintValidator<PhoneAnno, String> {

    @Override
    public boolean isValid(String userNumber, ConstraintValidatorContext constraintValidatorContext) {
        if(userNumber == null || userNumber.isEmpty()) {
            return false; // Null is not allowed
        }
        return userNumber.matches("\\d{10}"); // Ensures only digits and exactly 10 digits
    }

//    private int min;
//    private int max;
//
//    @Override
//    public void initialize(PhoneAnno phone) {
//        this.min = phone.min();
//        this.max = phone.max();
//    }
}
