package br.edu.ufersa.cinerex.features.ingresso;

import br.edu.ufersa.cinerex.features.ingresso.dto.IngressoCreate;
import br.edu.ufersa.cinerex.features.sessao.SessaoQuery;
import br.edu.ufersa.cinerex.shared.exceptions.RecursoNaoEncontrado;

class IngressoDomainService {

    private final SessaoQuery sessaoQuery;
    public IngressoDomainService(SessaoQuery sessaoQuery) {
        this.sessaoQuery = sessaoQuery;
    }

    public void validarCriacao(IngressoCreate dto) {
        var resultado = sessaoQuery.buscar(dto.sessaoId());
        if (resultado.isEmpty()) {
            throw new RecursoNaoEncontrado("A sessão é inexistente");
        }
    }
}
