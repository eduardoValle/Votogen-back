package org.develop.guru.service;

/**
 * Created by donat on 06-Apr-17.
 */
public class UserResponse {

    private String message;

    public UserResponse(String message){

        this.message = message;

    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
