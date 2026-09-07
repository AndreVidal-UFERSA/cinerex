package br.edu.ufersa.cinerex.api.dto;

import java.math.BigDecimal;
import java.util.Objects;

public record PutFuncionarioRequest(String cpf, String nome, String login, String senha, BigDecimal salario) {
    public PutFuncionarioRequest {
        Objects.requireNonNull(cpf, "CPF nao pode ser null");
        Objects.requireNonNull(nome, "Nome nao pode ser null");
        Objects.requireNonNull(login, "Login nao pode ser null");
        Objects.requireNonNull(senha, "Senha nao pode ser null");
        Objects.requireNonNull(salario, "Salario nao pode ser null");
    }
}
