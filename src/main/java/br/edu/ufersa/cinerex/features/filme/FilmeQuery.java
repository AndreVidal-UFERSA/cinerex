package br.edu.ufersa.cinerex.features.filme;

import br.edu.ufersa.cinerex.features.filme.dto.FilmeResponse;

import java.util.Optional;

public interface FilmeQuery {
    Optional<FilmeResponse> buscar(Long id);
}
