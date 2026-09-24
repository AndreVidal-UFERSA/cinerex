package br.edu.ufersa.cinerex.features.sessao;

import java.util.Optional;

public interface SessaoQuery {
    Optional<SessaoDTO> buscar(Long id);
}
