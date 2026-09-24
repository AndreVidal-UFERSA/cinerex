package br.edu.ufersa.cinerex.features.ingresso.api.dto;

import br.edu.ufersa.cinerex.features.sessao.Sessao;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

//Se passam os parâmetros necessários para CRIAR um objeto
public record IngressoCreateDTO(
        @NotNull(message = "O tipo do ingresso é obrigatório")
        Boolean meia,

        @NotNull(message = "O valor é obrigatório")
        @Positive
        BigDecimal valor,

        @NotNull(message = "A sessão é obrigatória")
        Sessao sessao){ }
