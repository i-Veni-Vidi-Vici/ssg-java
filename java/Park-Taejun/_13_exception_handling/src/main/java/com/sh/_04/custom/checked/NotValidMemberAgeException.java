package com.sh._04.custom.checked;

public class NotValidMemberAgeException extends RuntimeException {
    public NotValidMemberAgeException(String message) {
        super(message);
    }
}
