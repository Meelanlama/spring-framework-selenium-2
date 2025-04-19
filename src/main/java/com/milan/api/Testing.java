package com.milan.api;

import jakarta.validation.constraints.*;

public class Testing {

    @NotNull(message = "pin code cannot be null")
    private int pinCode;

    @Min(value = 18, message = "age should be minimum 18")
    //@Max(value = 150)
    private int age;

    @Past(message = "DOB should be past date") // cannot be present or future date
    // @Future // cannot be past or present date
    private int dateOfBirth;

    @Email(message = "Enter a valid email")
    private String email;
}
