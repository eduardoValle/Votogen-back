package org.develop.votogen.security;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class SecurityService {

    public SpringUser getCurrentUser() {
        return (SpringUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

}
