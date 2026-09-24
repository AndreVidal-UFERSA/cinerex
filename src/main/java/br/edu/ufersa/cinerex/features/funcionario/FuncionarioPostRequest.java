package br.edu.ufersa.cinerex.features.funcionario;

import java.math.BigDecimal;

import jakarta.validation.constraints.*;

record FuncionarioPostRequest(
        @NotBlank String cpf,
        @NotBlank @Size(max = 100) String nome,
        @NotBlank @Size(max = 100) String login,
        @NotBlank @Size(max = 100) String senha,
        @Positive BigDecimal salario
) {}
