package br.edu.ufersa.cinerex.features.sessao;

import java.time.LocalDateTime;

public record SessaoDTO(
        Long id,
        Long filmeId,
        Long salaId,
        LocalDateTime inicio,
        LocalDateTime fim
) {}
