package org.develop.guru.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.develop.guru.security.SystemUser;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 *
 * Created by Luiz Eduardo on 06/06/2017.
 */

@Entity
@Table
public class PagamentoLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private SystemUser user;

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private Products produto;

    @Column
    private String codigoPagamento;

    @Column
    private String statusPagamento;

    @Column
    private LocalDateTime dataCadastro;

    @Column
    private LocalDateTime ultimaMudancaStatus;

    public PagamentoLog() {
        super();
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

    public Products getProduto() {
        return produto;
    }

    public void setProduto(Products produto) {
        this.produto = produto;
    }

    public String getCodigoPagamento() {
        return codigoPagamento;
    }

    public void setCodigoPagamento(String codigoPagamento) {
        this.codigoPagamento = codigoPagamento;
    }

    public String getStatusPagamento() {
        return statusPagamento;
    }

    public void setStatusPagamento(String statusPagamento) {
        this.statusPagamento = statusPagamento;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public LocalDateTime getUltimaMudancaStatus() {
        return ultimaMudancaStatus;
    }

    public void setUltimaMudancaStatus(LocalDateTime ultimaMudancaStatus) {
        this.ultimaMudancaStatus = ultimaMudancaStatus;
    }
}
