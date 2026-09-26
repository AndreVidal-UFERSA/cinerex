package br.edu.ufersa.cinerex.features.filme;

import br.edu.ufersa.cinerex.features.filme.dto.FilmeResponse;
import br.edu.ufersa.cinerex.features.filme.dto.RequestPostFilme;
import br.edu.ufersa.cinerex.features.filme.dto.RequestPutFilme;
import br.edu.ufersa.cinerex.shared.exceptions.RecursoNaoEncontrado;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
class FilmeApplicationService {
    private final FilmeRepository repository;
    private final FilmeMapper mapper;

    public FilmeApplicationService(FilmeRepository repository, FilmeMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Long criar(RequestPostFilme requestPostFilme) {
        Filme filme = mapper.toEntity(requestPostFilme);
        Filme criado = repository.save(filme);
        return criado.getId();
    }

    public List<FilmeResponse> listar() {
        return repository.findAll().stream().map(mapper::toResponse).toList();
    }

    public Optional<FilmeResponse> encontrar(long id) {
        return repository.findById(id).map(mapper::toResponse);
    }

    public void atualizarTotal(long id, RequestPutFilme mudancas) {
        Optional<Filme> filmeOptional = repository.findById(id);
        if (filmeOptional.isEmpty())
            throw new RecursoNaoEncontrado("Filme com id " + id + " não encontrado");
        Filme filme = filmeOptional.get();
        filme.alterarNome(mudancas.nome());
        filme.alterarClassificacao(mudancas.classificacao());
        filme.alterarAno(mudancas.ano());
        filme.alterarDiretor(mudancas.diretor());
        repository.save(filme);
    }

    public void removerFilme(long id) {
        Optional<Filme> filmeOptional = repository.findById(id);
        if (filmeOptional.isEmpty())
            throw new RecursoNaoEncontrado("Filme com id " + id + " não encontrado");
        repository.deleteById(id);
    }
}