package br.edu.ufersa.cinerex.features.ingresso;

import br.edu.ufersa.cinerex.features.sessao.Sessao;

import java.math.BigDecimal;

public record IngressoPatchDTO(Boolean meia, BigDecimal valor, Sessao sessao){

}
