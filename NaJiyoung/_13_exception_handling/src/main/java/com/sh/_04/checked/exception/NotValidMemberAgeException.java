package com.sh._04.checked.exception;

public class NotValidMemberAgeException extends RuntimeException {
    public NotValidMemberAgeException(String message) {
        super(message);
    }
}
