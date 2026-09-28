package br.edu.ufersa.cinerex.features.ingresso;

import br.edu.ufersa.cinerex.features.ingresso.dto.IngressoCreate;
import br.edu.ufersa.cinerex.features.ingresso.dto.IngressoResponse;
import br.edu.ufersa.cinerex.shared.exceptions.RecursoNaoEncontrado;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
class IngressoApplicationService {
    private final IngressoRepository repository;
    private final IngressoMapper mapper;
    private final IngressoDomainService ingressoDomainService;


    public IngressoApplicationService(IngressoRepository repository, IngressoMapper mapper, IngressoDomainService ingressoDomainService) {
        this.repository = repository;
        this.mapper = mapper;
        this.ingressoDomainService = ingressoDomainService;
    }

    @Transactional
    public IngressoResponse criar(IngressoCreate ingressoCreate) {
        ingressoDomainService.validarCriacao(ingressoCreate);
        Ingresso ingresso = mapper.toEntity(ingressoCreate);
        Ingresso criado = repository.save(ingresso);
        return mapper.toResponse(criado);
    }

    public List<IngressoResponse> listar() {
        return repository.findAll().stream().map(mapper::toResponse).toList();
    }

    public IngressoResponse encontrar(long id) {
        Optional<Ingresso> ingressoOptional = repository.findById(id);
        if (ingressoOptional.isEmpty()) {
            throw new RecursoNaoEncontrado("Ingresso não encontrado");
        }
        Ingresso ingresso = ingressoOptional.get();
        return mapper.toResponse(ingresso);
    }

    @Transactional
    public void cancelar(long id) {
        Optional<Ingresso> ingressoOptional = repository.findById(id);
        if (ingressoOptional.isEmpty()) {
            throw new RecursoNaoEncontrado("Ingresso não encontrado");
        }
        Ingresso ingresso = ingressoOptional.get();
        ingresso.cancelar();
    }

    @Transactional
    public void utilizar(long id) {
        Optional<Ingresso> ingressoOptional = repository.findById(id);
        if (ingressoOptional.isEmpty()) {
            throw new RecursoNaoEncontrado("Ingresso não encontrado");
        }
        Ingresso ingresso = ingressoOptional.get();
        ingresso.utilizar();
    }

}
