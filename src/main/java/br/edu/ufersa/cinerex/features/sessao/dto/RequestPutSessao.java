package br.edu.ufersa.cinerex.features.sessao.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record RequestPutSessao(
        @NotNull Long filmeId,
        @NotNull Long salaId,
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        @NotNull @Future LocalDateTime inicio,
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        @NotNull @Future LocalDateTime fim
) {}
