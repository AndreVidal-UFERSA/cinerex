package br.edu.ufersa.cinerex.features.auth.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record RequestRegister(
        @NotBlank String nome,
        @NotBlank @Email String email,
        @NotBlank String senha
) {}
