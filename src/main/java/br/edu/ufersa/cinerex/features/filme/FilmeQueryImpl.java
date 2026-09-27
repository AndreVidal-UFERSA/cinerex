package br.edu.ufersa.cinerex.features.filme;

import br.edu.ufersa.cinerex.features.filme.dto.FilmeResponse;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
class FilmeQueryImpl implements FilmeQuery {
    private final FilmeMapper mapper;
    private final FilmeRepository repository;

    public FilmeQueryImpl(FilmeMapper mapper, FilmeRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    @Override
    public Optional<FilmeResponse> buscar(Long id) {
        return repository.findById(id).map(mapper::toResponse);
    }
}
