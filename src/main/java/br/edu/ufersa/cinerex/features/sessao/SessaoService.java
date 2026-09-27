package br.edu.ufersa.cinerex.features.sessao;

import br.edu.ufersa.cinerex.features.filme.FilmeQuery;
import br.edu.ufersa.cinerex.features.filme.dto.FilmeResponse;
import br.edu.ufersa.cinerex.features.sala.SalaQuery;
import br.edu.ufersa.cinerex.features.sala.dto.SalaResponse;
import br.edu.ufersa.cinerex.shared.exceptions.RecursoNaoEncontrado;
import org.springframework.stereotype.Service;
import java.util.Objects;
import java.util.Optional;

@Service
class SessaoService {
    private final SessaoRepository repository;
    private final FilmeQuery filmeQuery;
    private final SalaQuery salaQuery;

    public SessaoService(SessaoRepository repository, FilmeQuery filmeQuery, SalaQuery salaQuery) {
        this.repository = repository;
        this.filmeQuery = filmeQuery;
        this.salaQuery = salaQuery;
    }

    public void validarSessao(Sessao sessao) {
        Objects.requireNonNull(sessao, "Sessao nao pode ser null");
        // Validar existencia de filme
        Optional<FilmeResponse> filmeResponseOptional = filmeQuery.buscar(sessao.getFilmeId());
        if (filmeResponseOptional.isEmpty())
            throw new RecursoNaoEncontrado("Sessao referencia filme inexistente");
        FilmeResponse filmeResponse = filmeResponseOptional.get();
        // Validar existencia da sala
        Optional<SalaResponse> salaResponseOptional = salaQuery.buscar(sessao.getSalaId());
        if (salaResponseOptional.isEmpty())
            throw new RecursoNaoEncontrado("Sessao referencia sala inexistente");
        // COLOCAR OUTRAS REGRAS AQUI
    }
}
