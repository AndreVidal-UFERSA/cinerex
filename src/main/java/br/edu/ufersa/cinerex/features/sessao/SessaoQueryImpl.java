package br.edu.ufersa.cinerex.features.sessao;

import java.util.Optional;

class SessaoQueryImpl implements SessaoQuery {
    private final SessaoRepository repository;
    private final SessaoMapper mapper;

    public SessaoQueryImpl(SessaoRepository repository, SessaoMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Optional<SessaoDTO> buscar(Long id) {
        return repository.findById(id).map(mapper::toDTO);
    }
}
