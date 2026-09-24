package br.edu.ufersa.cinerex.features.funcionario.application;

import java.math.BigDecimal;

public record CriarFuncionarioCommand(
        String cpf,
        String nome,
        String login,
        String senha,
        BigDecimal salario
) {}
