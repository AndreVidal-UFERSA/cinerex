package br.edu.ufersa.cinerex.features.sessao;

import br.edu.ufersa.cinerex.features.sessao.dto.SessaoResponse;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
class SessaoQueryImpl implements SessaoQuery {
    private final SessaoMapper mapper;
    private final SessaoRepository repository;

    public SessaoQueryImpl(SessaoMapper mapper, SessaoRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    @Override
    public Optional<SessaoResponse> buscar(Long id) {
        return repository.findById(id).map(mapper::toDTO);
    }
}
