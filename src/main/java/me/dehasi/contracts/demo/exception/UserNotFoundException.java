package me.dehasi.contracts.demo.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String userId) {
        super(userId);
    }
}
