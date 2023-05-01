package com.vrx.user.service.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.function.Supplier;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException() {
        super("User not Found!!");
    }

    public UserNotFoundException(String message) {
        super(message);
    }
}
