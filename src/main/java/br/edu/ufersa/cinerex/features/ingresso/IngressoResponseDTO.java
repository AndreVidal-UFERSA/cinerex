package br.edu.ufersa.cinerex.features.ingresso;

import br.edu.ufersa.cinerex.features.sessao.Sessao;

import java.math.BigDecimal;

// Parâmetros de devolução do objeto
public record IngressoResponseDTO(Long id, Boolean meia, BigDecimal valor, Sessao sessao){
    public IngressoResponseDTO{
        if(id == null) throw new IllegalArgumentException("O id é obrigatório");
        if (meia==null) throw new IllegalArgumentException("É obrigatório");
        if (valor==null) throw new IllegalArgumentException("O valor é obrigatório");
        if (sessao == null) throw new IllegalArgumentException("A sessão é obrigatória!");
    }
}
