package br.edu.ufersa.cinerex.features.sala;

import br.edu.ufersa.cinerex.features.sala.dto.SalaResponse;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
class SalaQueryImpl implements SalaQuery {
    private final SalaMapper mapper;
    private final SalaRepository repository;

    public SalaQueryImpl(SalaMapper mapper, SalaRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    @Override
    public Optional<SalaResponse> buscar(Long id) {
        return repository.findById(id).map(mapper::toResponse);
    }
}
