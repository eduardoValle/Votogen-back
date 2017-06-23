package org.develop.guru.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.develop.guru.security.SystemUser;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 *
 * Created by Luiz Eduardo on 23/03/2017.
 */

@Entity
@Table
public class Life {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private SystemUser user;

    @Column
    private LocalDateTime dataCadastro;

    @Column
    private LocalDateTime dataExpiracao;

    @Column
    private LocalDateTime dataConsumo;


    public Life() {
        super();
    }

    public Life(SystemUser user, LocalDateTime dataCadastro, LocalDateTime dataExpiracao, LocalDateTime dataConsumo) {
        super();
        this.user = user;
        this.dataCadastro = dataCadastro;
        this.dataExpiracao = dataExpiracao;
        this.dataConsumo = dataConsumo;
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

    public LocalDateTime getDataConsumo() {
        return dataConsumo;
    }

    public void setDataConsumo(LocalDateTime dataConsumo) {
        this.dataConsumo = dataConsumo;
    }
}