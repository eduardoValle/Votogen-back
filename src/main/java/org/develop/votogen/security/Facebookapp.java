package org.develop.votogen.security;

/**
 * Created by donat on 24-May-17.
 */
public class Facebookapp {
    private String access_token;
    private String email;

    public Facebookapp(String access_token, String email) {
        this.access_token = access_token;
        this.email = email;
    }

    public Facebookapp() {
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
