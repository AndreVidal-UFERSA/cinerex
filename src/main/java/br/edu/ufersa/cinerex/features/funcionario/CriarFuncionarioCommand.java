package br.edu.ufersa.cinerex.features.funcionario;

import java.math.BigDecimal;

record CriarFuncionarioCommand(
        String cpf,
        String nome,
        String login,
        String senha,
        BigDecimal salario
) {}
