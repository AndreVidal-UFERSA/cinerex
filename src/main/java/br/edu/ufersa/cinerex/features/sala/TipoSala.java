package br.edu.ufersa.cinerex.features.sala;

import java.math.BigDecimal;

public enum TipoSala {
    PADRAO(BigDecimal.ZERO),
    PREMIUM(BigDecimal.TEN);

    private final BigDecimal valorExtra;

    TipoSala(BigDecimal valorExtra) {
        this.valorExtra = valorExtra;
    }

    public BigDecimal getValorExtra() {
        return valorExtra;
    }
}
