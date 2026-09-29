package br.edu.ufersa.cinerex.features.auth;

public enum UserRole {
    USUARIO("ROLE_USUARIO"),
    ADMINISTRADOR("ROLE_ADMINISTRADOR");

    private final String funcao;

    UserRole(String funcao) {
        this.funcao = funcao;
    }

    public String getFuncao() {
        return funcao;
    }
}
