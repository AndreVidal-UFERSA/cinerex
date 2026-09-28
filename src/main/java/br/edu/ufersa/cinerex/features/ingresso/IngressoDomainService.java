package br.edu.ufersa.cinerex.features.ingresso;

import br.edu.ufersa.cinerex.features.filme.FilmeQuery;
import br.edu.ufersa.cinerex.features.ingresso.dto.IngressoCreate;
import br.edu.ufersa.cinerex.features.sala.SalaQuery;
import br.edu.ufersa.cinerex.features.sessao.SessaoQuery;
import br.edu.ufersa.cinerex.shared.exceptions.RecursoNaoEncontrado;

import java.math.BigDecimal;

class IngressoDomainService {
    private final FilmeQuery filmeQuery;
    private final SalaQuery salaQuery;
    private final SessaoQuery sessaoQuery;

    public IngressoDomainService(FilmeQuery filmeQuery, SalaQuery salaQuery, SessaoQuery sessaoQuery) {
        this.filmeQuery = filmeQuery;
        this.salaQuery = salaQuery;
        this.sessaoQuery = sessaoQuery;
    }

    public void validarCriacao(IngressoCreate dto) {
        var resultado = sessaoQuery.buscar(dto.sessaoId());
        if (resultado.isEmpty()) {
            throw new RecursoNaoEncontrado("A sessão é inexistente");
        }
    }

    public BigDecimal calcularValor(IngressoCreate dto) {

        var sessao = sessaoQuery.buscar(dto.sessaoId());
        if (sessao.isEmpty()) {
            throw new RecursoNaoEncontrado("A sessão é inexistente");
        }

        var filme = filmeQuery.buscar(sessao.get().filmeId());
        if (filme.isEmpty()) {
            throw new RecursoNaoEncontrado("O filme é inexistente");
        }

        var sala = salaQuery.buscar(sessao.get().salaId());
        if (sala.isEmpty()) {
            throw new RecursoNaoEncontrado("A sala é inexistente");
        }

        BigDecimal precoFilme = filme.get().preco();
        BigDecimal valorExtraSala =
                sala.get().tipoSala().getValorExtra();

        return precoFilme.add(valorExtraSala);
    }

}
