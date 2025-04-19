package com.milan.CustomAnnotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class AgeValidator implements ConstraintValidator<Age, Integer> {
    private int upper; // capturing whatever developer sets the age by overriding default value
    private int lower;
    @Override
    public void initialize(Age age) {
        // I can write the post construct work right here,We will do our initialization stuffs
         this.lower = age.lower();
         this.upper = age.upper();
    }

    @Override
    public boolean isValid(Integer ageValue, ConstraintValidatorContext constraintValidatorContext) {
        // need to write my logic here
        if(ageValue == null){
            return false;
        }

        if (ageValue < this.lower || ageValue > this.upper) {
            return false; // validation fail
        }
        return true; // validation pass
    }
}
