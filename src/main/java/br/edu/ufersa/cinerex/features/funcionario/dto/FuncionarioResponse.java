package br.edu.ufersa.cinerex.features.funcionario.dto;

import java.math.BigDecimal;

public record FuncionarioResponse(
        String nome,
        BigDecimal salario
)
{}
