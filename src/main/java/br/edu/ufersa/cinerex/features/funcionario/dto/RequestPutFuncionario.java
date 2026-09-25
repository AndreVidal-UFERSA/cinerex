package br.edu.ufersa.cinerex.features.funcionario.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public record RequestPutFuncionario(
        @NotBlank @Size(max = 100) String nome,
        @NotBlank @Size(max = 100) String login,
        @NotBlank @Size(max = 100) String senha,
        @Positive BigDecimal salario
) {}