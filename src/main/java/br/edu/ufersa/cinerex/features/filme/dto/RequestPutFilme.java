package br.edu.ufersa.cinerex.features.filme.dto;

import br.edu.ufersa.cinerex.features.filme.Classificacao;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;

public record RequestPutFilme(
        @NotBlank @Size(max = 100) String nome,
        @NotNull Classificacao classificacao,
        @NotNull @Positive Integer ano,
        @NotBlank @Size(max = 100) String diretor,
        @NotNull @Positive BigDecimal preco
) {}