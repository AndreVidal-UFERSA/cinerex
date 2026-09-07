package br.edu.ufersa.cinerex.api.dto;

import java.math.BigDecimal;
import java.util.Objects;

public record PostFuncionarioRequest(String cpf, String login, String nome, String senha, BigDecimal salario) {
    public PostFuncionarioRequest {
        Objects.requireNonNull(cpf, "CPF nao pode ser null");
        Objects.requireNonNull(login, "Login nao pode ser null");
        Objects.requireNonNull(nome, "Nome nao pode ser null");
        Objects.requireNonNull(senha, "Senha nao pode ser null");
        Objects.requireNonNull(salario, "Salario nao pode ser null");
    }
}
