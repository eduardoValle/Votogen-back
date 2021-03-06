package org.develop.votogen.security;

import org.develop.votogen.config.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class AuthenticationService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenUtils tokenUtils;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private SystemUserRepository systemUserRepo;

    public Response login(String username, String password) {
        Response r = new Response();
        r.setId(((SpringUser) this.userDetailsService.loadUserByUsername(username)).getId());
        UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);

        if (BCrypt.checkpw(password, userDetails.getPassword()) && username.equals(userDetails.getUsername())) {
            Authentication authentication = this.authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(username, password));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            r.setToken(this.tokenUtils.generateToken(userDetails));
            return r;
        } else {
            return null;
        }

    }

    public Response loginFacebook(String username) {
        // no cadastro pelo facebook a senha é null
        SystemUser user = systemUserRepo.findByEmail(username).orElse(register(username, null, null, null));
        Response r = new Response();
        r.setId(user.getId());
        r.setToken(this.tokenUtils.generateToken(new SpringUser(user)));
        return r;
    }

    public String refresh(String token) {
        return null;
    }

    public SystemUser register(String username, String password, String name, Date dateNasc) {
        if (!systemUserRepo.findByEmail(username).isPresent()) {
            SystemUser user = new SystemUser();
            user.setEmail(username);
            user.setEncryptedPassword(password);
            user.setName(name);
            user.setDate(dateNasc);
            return systemUserRepo.save(user);
        }
        return null;
    }


    public SystemUser edit(String username, String password, String name, Date dateNasc) {
        SystemUser user = ((SpringUser) this.userDetailsService.loadUserByUsername(username)).getSystemUser();

        if (!username.equals(null) && !password.equals(null) && !name.equals(null) && !dateNasc.equals(null)) {
            user.setEmail(username);
            user.setEncryptedPassword(password);
            user.setName(name);
            user.setDate(dateNasc);

            return systemUserRepo.save(user);
        }
        return user;

    }

    public SystemUser edit(String username, String name, Date dateNasc) {
        Optional<SystemUser> user = systemUserRepo.findByEmail(username);
        if (user.isPresent()) {
            user.get().setEmail(username);
            user.get().setName(name);
            user.get().setDate(dateNasc);
            try {
                return systemUserRepo.save(user.get());
            } catch (Exception e) {
                return null;
            }
        } else {
            return null;
        }
    }

    public SystemUser newPassword(int id, String newPassword) {
        Optional<SystemUser> user = systemUserRepo.findById(id);
        System.out.println(user);
        if (user != null) {
            user.get().setLastPasswordChange(user.get().getEncryptedPassword());
            user.get().setEncryptedPassword(newPassword);
            try {
                return systemUserRepo.save(user.get());
            } catch (Exception e) {
                return null;
            }
        } else {
            return null;
        }
    }

    public SystemUser checkEmail(String username) {
        Optional<SystemUser> user = systemUserRepo.findByEmail(username);
        if (user.isPresent()) {
            user.get().getEmail();
            user.get().getName();
            try {
                return user.get();
            } catch (Exception e) {
                return null;
            }
        } else {
            return null;
        }
    }
}
