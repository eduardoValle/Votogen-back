package org.develop.votogen.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.validation.Valid;

@Component
@ConfigurationProperties(prefix = "system")
public class Properties {

    @Valid
    private TokenProperties token;


    public TokenProperties getToken() {
        return token;
    }

    public void setToken(TokenProperties token) {
        this.token = token;
    }

}
