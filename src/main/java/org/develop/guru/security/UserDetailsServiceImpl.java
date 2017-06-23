package org.develop.guru.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private SystemUserRepository systemUserRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        SystemUser user = this.systemUserRepo.findByEmail(username).orElseThrow(() -> new UsernameNotFoundExceptionImpl(String.format("Não foi encontrado usuário com o nome '%s'.", username)));
        user.setLastActivity(new Date());
        systemUserRepo.save(user);
        return new SpringUser(user);
    }
}
