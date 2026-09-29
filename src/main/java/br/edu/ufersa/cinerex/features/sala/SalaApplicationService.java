package br.edu.ufersa.cinerex.features.sala;

import br.edu.ufersa.cinerex.features.sala.dto.RequestPostSala;
import br.edu.ufersa.cinerex.features.sala.dto.RequestPutSala;
import br.edu.ufersa.cinerex.features.sala.dto.SalaResponse;
import br.edu.ufersa.cinerex.shared.exceptions.RecursoJaExiste;
import br.edu.ufersa.cinerex.shared.exceptions.RecursoNaoEncontrado;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
class SalaApplicationService {
    private final SalaRepository repository;
    private final SalaMapper mapper;

    public SalaApplicationService(SalaRepository repository, SalaMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Long criar(RequestPostSala requestPostSala) {
        if (repository.existsByNumero(requestPostSala.numero()))
            throw new RecursoJaExiste("Sala com numero " + requestPostSala.numero() + " ja existe");
        Sala sala = mapper.toEntity(requestPostSala);
        Sala criada = repository.save(sala);
        return criada.getId();
    }

    public List<SalaResponse> listar() {
        return repository.findAll().stream().map(mapper::toResponse).toList();
    }

    public Optional<SalaResponse> encontrar(long id) {
        return repository.findById(id).map(mapper::toResponse);
    }

    public void atualizarTotal(long id, RequestPutSala mudancas) {
        Optional<Sala> salaOptional = repository.findById(id);
        if (salaOptional.isEmpty())
            throw new RecursoNaoEncontrado("Sala com id " + id + " nao encontrada");
        Sala sala = salaOptional.get();

        boolean numeroMudou = !mudancas.numero().equals(sala.getNumero());
        if (numeroMudou && repository.existsByNumero(mudancas.numero()))
            throw new RecursoJaExiste("Sala com numero " + mudancas.numero() + " ja existe");

        sala.alterarNumero(mudancas.numero());
        sala.alterarNumeroAssentos(mudancas.numeroAssentos());
        sala.alterarTipoSala(mudancas.tipoSala());
        sala.alterarStatusSala(mudancas.statusSala());
        repository.save(sala);
    }

    public void removerSala(long id) {
        Optional<Sala> salaOptional = repository.findById(id);
        if (salaOptional.isEmpty())
            throw new RecursoNaoEncontrado("Sala com id " + id + " nao encontrada");
        repository.deleteById(id);
    }
}