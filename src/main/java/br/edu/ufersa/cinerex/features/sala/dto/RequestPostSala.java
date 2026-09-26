package br.edu.ufersa.cinerex.features.sala.dto;

import br.edu.ufersa.cinerex.features.sala.TipoSala;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record RequestPostSala(
        @NotNull @Positive Integer numero,
        @NotNull @Positive Integer numeroAssentos,
        @NotNull TipoSala tipoSala
) {
}