package com.milan.CustomAnnotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
@Constraint(validatedBy = AgeValidator.class)
public @interface Age {
String message() default "{invalidMessage}";
int lower() default 18;
int upper() default 45;

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
