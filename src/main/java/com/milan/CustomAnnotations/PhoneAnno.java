package com.milan.CustomAnnotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
@Constraint(validatedBy = PhoneValidator.class)
public @interface PhoneAnno {
    String message() default "{invalidPhoneMessage}";

    //    int min() default 10;
//    int max() default 10;
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
