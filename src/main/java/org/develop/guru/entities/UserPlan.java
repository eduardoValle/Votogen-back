package org.develop.guru.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.develop.guru.security.SystemUser;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 *
 * Created by Luiz Eduardo on 12/04/2017.
 */
@Entity
@Table
public class UserPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private SystemUser user;

    @Column
    private String name;

    @Column
    private LocalDateTime dataCadastro;

    @Column
    private LocalDateTime dataExpiracao;

    @Column
    private Boolean active;


    public UserPlan() {
        super();
    }

    public UserPlan(SystemUser user, LocalDateTime dataCadastro, LocalDateTime dataExpiracao, Boolean active) {
        super();
        this.user = user;
        this.dataCadastro = dataCadastro;
        this.dataExpiracao = dataExpiracao;
        this.active = active;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public SystemUser getUser() {
        return user;
    }

    public void setUser(SystemUser user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public LocalDateTime getDataExpiracao() {
        return dataExpiracao;
    }

    public void setDataExpiracao(LocalDateTime dataExpiracao) {
        this.dataExpiracao = dataExpiracao;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
