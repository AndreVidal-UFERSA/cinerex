package br.edu.ufersa.cinerex.domain.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "venda")
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal valorTotal;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Ingresso> ingressos;

    // Metodos de validacao

    private static List<Ingresso> validarIngressos(List<Ingresso> ingressos) {
        Objects.requireNonNull(ingressos, "Lista de ingressos nao pode ser null");

        if (ingressos.isEmpty())
            throw new IllegalArgumentException("A venda deve possuir pelo menos um ingresso");

        for (Ingresso ingresso : ingressos) {
            Objects.requireNonNull(ingresso, "Ingresso nao pode ser null");
        }

        return ingressos;
    }

    private static BigDecimal calcularValorTotal(List<Ingresso> ingressos) {
        BigDecimal total = BigDecimal.ZERO;

        for (Ingresso ingresso : ingressos) {
            total = total.add(ingresso.getValor());
        }

        return total;
    }


    // Construtor vazio necessario para o Spring Data JPA

    protected Venda() {}


    public Venda(List<Ingresso> ingressos) {
        this.ingressos = validarIngressos(ingressos);
        this.valorTotal = calcularValorTotal(ingressos);
    }


    public void adicionarIngresso(Ingresso ingresso) {
        Objects.requireNonNull(ingresso, "Ingresso nao pode ser null");

        this.ingressos.add(ingresso);
        this.valorTotal = calcularValorTotal(this.ingressos);
    }

    public void removerIngresso(Ingresso ingresso) {
        Objects.requireNonNull(ingresso, "Ingresso nao pode ser null");

        if (!this.ingressos.remove(ingresso))
            throw new IllegalArgumentException("Ingresso nao pertence a esta venda");

        this.valorTotal = calcularValorTotal(this.ingressos);
    }


    public Long getCodigo() {
        return codigo;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public List<Ingresso> getIngressos() {
        return ingressos;
    }
}