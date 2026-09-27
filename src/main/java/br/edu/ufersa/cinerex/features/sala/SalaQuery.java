package br.edu.ufersa.cinerex.features.sala;

import br.edu.ufersa.cinerex.features.sala.dto.SalaResponse;

import java.util.Optional;

public interface SalaQuery {
    Optional<SalaResponse> buscar(Long id);
}
