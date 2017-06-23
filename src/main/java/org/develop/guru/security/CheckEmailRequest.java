package org.develop.guru.security;

import javax.validation.constraints.NotNull;

public class CheckEmailRequest {
    @NotNull
    private String email;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
