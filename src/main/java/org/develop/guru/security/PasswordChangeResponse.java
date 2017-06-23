package org.develop.guru.security;

/**
 * Created by Ivan on 18/09/2016.
 */
public class PasswordChangeResponse {
    private String message;

    public PasswordChangeResponse() {
    }

    public PasswordChangeResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
