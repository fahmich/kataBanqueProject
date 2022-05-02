package com.example.demo.exception;

public class AccountNotFoundException extends Exception {
    public AccountNotFoundException(String accountNumber) {
        super(String.format("Account number %s has not been found.", accountNumber));
    }
}
