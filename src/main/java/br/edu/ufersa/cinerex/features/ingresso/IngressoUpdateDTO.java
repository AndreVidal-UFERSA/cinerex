package br.edu.ufersa.cinerex.features.ingresso;

import br.edu.ufersa.cinerex.features.sessao.Sessao;
import java.math.BigDecimal;

//Se passam os parâmetros necessários para CRIAR um objeto
public record IngressoUpdateDTO(Boolean meia, BigDecimal valor, Sessao sessao) {
    public IngressoUpdateDTO{
        if (meia==null) throw new IllegalArgumentException("É obrigatório informar o tipo de ingresso!");
        if (valor==null) throw new IllegalArgumentException("O valor é obrigatória!");
        if (sessao == null) throw new IllegalArgumentException("A sessão é obrigatória!");
    }
}
