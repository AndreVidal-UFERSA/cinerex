package br.edu.ufersa.cinerex.features.ingresso;

import br.edu.ufersa.cinerex.features.sessao.Sessao;
import java.math.BigDecimal;

//Se passam os parâmetros necessários para CRIAR um objeto
public record IngressoCreateDTO(Boolean meia, BigDecimal valor, Sessao sessao) {
    public IngressoCreateDTO{
        if (meia==null) meia = false;
        if (valor==null) valor = BigDecimal.ZERO;
        if (sessao == null) throw new IllegalArgumentException("A sessão é obrigatória!");
    }
}
