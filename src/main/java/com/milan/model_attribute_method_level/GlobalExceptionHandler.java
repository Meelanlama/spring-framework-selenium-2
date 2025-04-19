package com.milan.model_attribute_method_level;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.IOException;

@ControllerAdvice
public class GlobalExceptionHandler {

    //Exception handler methods:
    @ExceptionHandler(value = NullPointerException.class)
    public String handleNullPointerException() {
        return "null-pointer-page";
    }

    @ExceptionHandler(value = IOException.class)
    public String handleIOException() {
        return "null-pointer-page";
    }

    @ExceptionHandler(value = Exception.class)
    public String handleExceptions() {
        return "exception-page";
    }
}
