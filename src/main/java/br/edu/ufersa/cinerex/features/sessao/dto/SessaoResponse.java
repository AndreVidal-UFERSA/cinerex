package br.edu.ufersa.cinerex.features.sessao.dto;

import java.time.LocalDateTime;

public record SessaoResponse(
        Long id,
        Long filmeId,
        Long salaId,
        LocalDateTime inicio,
        LocalDateTime fim
) {}
