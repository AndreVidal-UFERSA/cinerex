package br.edu.ufersa.cinerex.features.sala.dto;

import br.edu.ufersa.cinerex.features.sala.StatusSala;
import br.edu.ufersa.cinerex.features.sala.TipoSala;

public record SalaResponse(
        Long id,
        Integer numero,
        Integer numeroAssentos,
        TipoSala tipoSala,
        StatusSala statusSala
) {}
