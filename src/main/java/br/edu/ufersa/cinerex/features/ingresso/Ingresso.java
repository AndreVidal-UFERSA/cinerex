package br.edu.ufersa.cinerex.features.ingresso;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

import br.edu.ufersa.cinerex.features.sessao.Sessao;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ingresso")
public class Ingresso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Boolean meia;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal valor;

    @ManyToOne
    @JoinColumn(name = "sessao_id", nullable = false)
    private Sessao sessao;


    // Metodos de validacao

    private static BigDecimal validarValor(BigDecimal valor) {
        Objects.requireNonNull(valor, "Valor não pode ser null");

        if (valor.compareTo(BigDecimal.ZERO) <= 0)
            throw new IllegalArgumentException("Valor não pode ser menor ou igual a zero");

        return valor;
    }

    private static Sessao validarSessao(Sessao sessao) {
        Objects.requireNonNull(sessao, "Sessão não pode ser null");
        return sessao;
    }

    private static Boolean validarMeia(Boolean meia) {
        Objects.requireNonNull(meia, "Meia nao pode ser null");
        return meia;
    }


    // Construtor vazio necessario para o Spring Data JPA

    protected Ingresso() {}


    public Ingresso(Sessao sessao, BigDecimal valor, Boolean meia) {
        this.sessao = validarSessao(sessao);
        this.meia = validarMeia(meia);
        this.valor = validarValor(valor);
        if (meia)
            this.valor = this.valor.divide(BigDecimal.TWO, RoundingMode.HALF_EVEN);
    }

    public void alterarSessao(Sessao novaSessao) {
        this.sessao = validarSessao(novaSessao);
    }

    public Long getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public Sessao getSessao() {
        return sessao;
    }

    public Boolean isMeia() {
        return meia;
    }
}