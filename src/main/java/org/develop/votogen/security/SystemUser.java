package org.develop.votogen.security;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.develop.votogen.entities.Historic;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.OneToMany;

@Entity
public class SystemUser {
    private static final long serialVersionUID = 7740893708926140114L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @JsonIgnore
    private String encryptedPassword;
    @Column(unique = true)
    private String email;
    @Column
    private String name;
    @ElementCollection(fetch = FetchType.EAGER, targetClass = Authority.class)
    @Enumerated(EnumType.STRING)
    private Set<Authority> authorities;
    @ElementCollection(fetch = FetchType.EAGER, targetClass = Role.class)
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;
    private String lastPasswordChange;
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastActivity;
    @Column
    private Date dateNasc;

    @OneToMany(mappedBy = "user")
    private Set<Historic> historic = new HashSet<Historic>();

    public SystemUser() {
        super();
    }

    public SystemUser(String email, String encryptedPassword) {
        super();
        this.encryptedPassword = encryptedPassword;
        this.email = email;
    }

    public SystemUser(String email) {
        super();
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public Date getDate() {
        return dateNasc;
    }

    public void setDate(Date dateNasc) {
        this.dateNasc = dateNasc;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }

    public void setPassword(String password) {
        this.encryptedPassword = new BCryptPasswordEncoder().encode(password);
    }

    public String getLastPasswordChange() {
        return lastPasswordChange;
    }

    public void setLastPasswordChange(String lastPasswordChange) {
        this.lastPasswordChange = lastPasswordChange;
    }

    public Date getLastActivity() {
        return lastActivity;
    }

    public void setLastActivity(Date lastActivity) {
        this.lastActivity = lastActivity;
    }

    public Set<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<Authority> authorities) {
        this.authorities = authorities;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Set<Historic> getHistoric() {
        return historic;
    }

    public void setHistoric(Set<Historic> historic) {
        this.historic = historic;
    }

}