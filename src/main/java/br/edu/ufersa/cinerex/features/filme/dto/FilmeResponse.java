package br.edu.ufersa.cinerex.features.filme.dto;

import br.edu.ufersa.cinerex.features.filme.Classificacao;

public record FilmeResponse(
        Long id,
        String nome,
        Classificacao classificacao,
        Integer ano,
        String diretor
) {}