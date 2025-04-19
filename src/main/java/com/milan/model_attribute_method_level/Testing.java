package com.milan.model_attribute_method_level;

import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class Testing {

    public Testing() {
        System.out.println("Object created by spring");
    }
}
