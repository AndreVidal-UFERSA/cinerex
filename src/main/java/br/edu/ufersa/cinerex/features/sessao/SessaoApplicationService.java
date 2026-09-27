package br.edu.ufersa.cinerex.features.sessao;

import br.edu.ufersa.cinerex.features.sessao.dto.RequestPostSessao;
import br.edu.ufersa.cinerex.features.sessao.dto.RequestPutSessao;
import br.edu.ufersa.cinerex.features.sessao.dto.SessaoResponse;
import br.edu.ufersa.cinerex.shared.exceptions.RecursoNaoEncontrado;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
class SessaoApplicationService {
    private final SessaoMapper mapper;
    private final SessaoRepository repository;
    private final SessaoService service;

    public SessaoApplicationService(SessaoMapper mapper, SessaoRepository repository, SessaoService service) {
        this.mapper = mapper;
        this.repository = repository;
        this.service = service;
    }

    public Long criar(RequestPostSessao requestPostSessao) {
        Sessao sessao = mapper.toEntity(requestPostSessao);
        service.validarSessao(sessao);
        return repository.save(sessao).getId();
    }

    public List<SessaoResponse> listar() {
        return repository.findAll().stream().map(mapper::toDTO).toList();
    }

    public Optional<SessaoResponse> buscar(Long id) {
        return repository.findById(id).map(mapper::toDTO);
    }

    public void atualizarTotal(Long id, RequestPutSessao requestPutSessao) {
        Optional<Sessao> sessaoOptional = repository.findById(id);
        if (sessaoOptional.isEmpty())
            throw new RecursoNaoEncontrado("Sessao com ID fornecido nao encontrado");
        Sessao sessao = sessaoOptional.get();
        sessao.atualizar(
                requestPutSessao.filmeId(),
                requestPutSessao.salaId(),
                requestPutSessao.inicio(),
                requestPutSessao.fim()
        );
        repository.save(sessao);
    }

    public void deletar(Long id) {
        Optional<Sessao> sessaoOptional = repository.findById(id);
        if (sessaoOptional.isEmpty())
            throw new RecursoNaoEncontrado("Sessao com ID fornecido nao encontrado");
        repository.delete(sessaoOptional.get());
    }
}
