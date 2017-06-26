package org.develop.votogen.security;

import javax.validation.constraints.NotNull;

public class CheckCodeRequest {
    @NotNull
    private String codigo;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
