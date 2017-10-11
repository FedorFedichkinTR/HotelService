package com.epam.exceptions;

public class UserDoesNotExist extends Exception {

    public UserDoesNotExist(String message) {
        super(message);
    }
}
