package br.edu.ufersa.cinerex.features.ingresso.api.dto;

import br.edu.ufersa.cinerex.features.sessao.Sessao;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

// Parâmetros de devolução do objeto
public record IngressoResponseDTO(
        @NotNull(message = "O id é obrigatório")
        Long id,

        @NotNull(message = "O tipo do ingresso é obrigatório")
        Boolean meia,

        @NotNull(message = "O valor é obrigatório")
        @Positive
        BigDecimal valor,

        @NotNull(message = "A sessão é obrigatória")
                Sessao sessao){ }
