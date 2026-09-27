package br.edu.ufersa.cinerex.features.sessao.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record RequestPutSessao(
        @NotNull Long filmeId,
        @NotNull Long salaId,
        @NotNull @Future LocalDateTime inicio,
        @NotNull @Future LocalDateTime fim
) {}
