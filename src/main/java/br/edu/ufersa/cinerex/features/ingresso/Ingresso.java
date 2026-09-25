package br.edu.ufersa.cinerex.features.ingresso;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ingresso")
class Ingresso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Boolean meia;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal valor;

    @Column(name = "sessao_id", nullable = false)
    private Long sessaoId;

    // Metodos de validacao

    private static BigDecimal validarValor(BigDecimal valor) {
        Objects.requireNonNull(valor, "Valor não pode ser null");

        if (valor.compareTo(BigDecimal.ZERO) <= 0)
            throw new IllegalArgumentException("Valor não pode ser menor ou igual a zero");

        return valor;
    }

    private static Long validarSessaoId(Long sessaoId) {
        Objects.requireNonNull(sessaoId, "Sessão não pode ser null");
        return sessaoId;
    }

    private static Boolean validarMeia(Boolean meia) {
        Objects.requireNonNull(meia, "Meia nao pode ser null");
        return meia;
    }

    // Construtor vazio necessario para o Spring Data JPA
    protected Ingresso() {}

    public Ingresso(Long sessaoId, BigDecimal valor, Boolean meia) {
        this.sessaoId = validarSessaoId(sessaoId);
        this.meia = validarMeia(meia);
        this.valor = validarValor(valor);
        if (meia)
            this.valor = this.valor.divide(BigDecimal.TWO, RoundingMode.HALF_EVEN);
    }

    public void alterarSessao(Long sessaoId) {
        this.sessaoId = validarSessaoId(sessaoId);
    }

    public Long getId() {
        return id;
    }
    public BigDecimal getValor() {
        return valor;
    }
    public Long getSessaoId() {
        return sessaoId;
    }
    public Boolean isMeia() {
        return meia;
    }
}