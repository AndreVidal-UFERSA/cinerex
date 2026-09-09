package br.edu.ufersa.cinerex.domain.entity;

import java.math.BigDecimal;
import java.util.Objects;

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

    @ManyToOne
    @JoinColumn(name = "tipo_ingresso_id", nullable = false)
    private TipoIngresso tipo;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal valor;

    @ManyToOne
    @JoinColumn(name = "sessao_id", nullable = false)
    private Sessao sessao;


    // Metodos de validacao

    private static TipoIngresso validarTipo(TipoIngresso tipo) {
        Objects.requireNonNull(tipo, "Tipo do ingresso não pode ser null");
        return tipo;
    }

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


    // Construtor vazio necessario para o Spring Data JPA

    protected Ingresso() {}


    public Ingresso(TipoIngresso tipo, Sessao sessao) {
        this.tipo = validarTipo(tipo);
        this.valor = validarValor(tipo.getValor());
        this.sessao = validarSessao(sessao);
    }


    public void alterarTipo(TipoIngresso novoTipo) {
        this.tipo = validarTipo(novoTipo);
        this.valor = validarValor(novoTipo.getValor());
    }

    public void alterarSessao(Sessao novaSessao) {
        this.sessao = validarSessao(novaSessao);
    }


    public Long getId() {
        return id;
    }

    public TipoIngresso getTipo() {
        return tipo;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public Sessao getSessao() {
        return sessao;
    }
}