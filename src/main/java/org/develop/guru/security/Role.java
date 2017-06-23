package org.develop.guru.security;

import org.springframework.security.core.GrantedAuthority;

/**
 * Created by Ivan on 19/09/2016.
 */
public enum Role implements GrantedAuthority {
    ADMIN;

    @Override
    public String getAuthority() {
        return "ROLE_" + name();
    }
}
