package br.edu.ufersa.cinerex.features.sessao;

import br.edu.ufersa.cinerex.features.sessao.dto.SessaoResponse;

import java.util.Optional;

public interface SessaoQuery {
    Optional<SessaoResponse> buscar(Long id);
}
