package org.develop.votogen.security;

import org.springframework.security.core.GrantedAuthority;

public enum Authority implements GrantedAuthority {
    ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }

}
