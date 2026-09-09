package br.edu.ufersa.cinerex.domain.entity;

import java.math.BigDecimal;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tipo_ingresso")
public class TipoIngresso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(nullable = false, unique = true, length = 50)
    private String nome;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal valor;


    // Metodos de validacao

    private static String validarNome(String nome) {
        Objects.requireNonNull(nome, "Nome do tipo de ingresso nao pode ser null");

        if (nome.isBlank())
            throw new IllegalArgumentException("Nome do tipo de ingresso nao pode ser vazio");

        return nome;
    }

    private static BigDecimal validarValor(BigDecimal valor) {
        Objects.requireNonNull(valor, "Valor nao pode ser null");

        if (valor.compareTo(BigDecimal.ZERO) <= 0)
            throw new IllegalArgumentException("Valor nao pode ser menor ou igual a zero");

        return valor;
    }


    // Construtor vazio necessario para o Spring Data JPA
    protected TipoIngresso() {}


    public TipoIngresso(String nome, BigDecimal valor) {
        this.nome = validarNome(nome);
        this.valor = validarValor(valor);
    }

    public void alterarNome(String novoNome) {
        this.nome = validarNome(novoNome);
    }

    public void alterarValor(BigDecimal novoValor) {
        this.valor = validarValor(novoValor);
    }


    public Long getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public BigDecimal getValor() {
        return valor;
    }
}
