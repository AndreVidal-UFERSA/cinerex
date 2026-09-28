package br.edu.ufersa.cinerex.features.ingresso.dto;

import br.edu.ufersa.cinerex.features.ingresso.IngressoStatus;
import java.math.BigDecimal;

// Parâmetros de devolução do objeto
public record IngressoResponse(
        Long id,
        Boolean meia,
        BigDecimal valor,
        Long sessaoId,
        IngressoStatus status){}
