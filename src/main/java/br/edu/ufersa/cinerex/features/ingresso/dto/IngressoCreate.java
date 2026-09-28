package br.edu.ufersa.cinerex.features.ingresso.dto;

import jakarta.validation.constraints.NotNull;

//Se passam os parâmetros necessários para CRIAR um objeto
public record IngressoCreate(
        @NotNull(message = "O tipo do ingresso é obrigatório")
        Boolean meia,

        @NotNull(message = "A sessão é obrigatória")
        Long sessaoId){ }
