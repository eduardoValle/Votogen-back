package org.develop.votogen.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.validation.constraints.NotNull;

/**
 * Created by donat on 06-Apr-17.
 */
public class UserRequest {
    @NotNull
    private int id;
    private String password;
    private String confirm;

    public UserRequest() {
        super();
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = new BCryptPasswordEncoder().encode(password);
    }

    public String getConfirm() {
        return this.confirm;
    }

    public void setConfirm(String confirm) {
        this.confirm = confirm;
    }
}
