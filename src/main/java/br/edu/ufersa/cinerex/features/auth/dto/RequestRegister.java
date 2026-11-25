package br.edu.ufersa.cinerex.features.auth.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record RequestRegister(
        @NotBlank @Email String email,
        @NotBlank String senha,
        @NotBlank String nome
) {}
