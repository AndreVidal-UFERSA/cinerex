package br.edu.ufersa.cinerex.features.filme.dto;

import br.edu.ufersa.cinerex.features.filme.Classificacao;
import java.math.BigDecimal;

public record FilmeResponse(
        Long id,
        String nome,
        Classificacao classificacao,
        Integer ano,
        String diretor,
        BigDecimal preco
) {}