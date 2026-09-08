package br.edu.ufersa.cinerex.domain.entity;

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
@Table(name = "sala")
public class Sala {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero", nullable = false, unique = true)
    private int numero;

    @Column(name = "numero_assentos", nullable = false)
    private int numeroAssentos;

    @ManyToOne
    @JoinColumn(name = "filme_id")
    private Filme filme;

    // Metodos de validacao
    private static int validarNumero(int numero) {
        if (numero <= 0) throw new IllegalArgumentException("Numero da sala deve ser maior que zero");
        return numero;
    }

    private static int validarNumeroAssentos(int numeroAssentos) {
        if (numeroAssentos <= 0) throw new IllegalArgumentException("Numero de assentos deve ser maior que zero");
        return numeroAssentos;
    }

    // Contrutor vazio necessario para o Spring Data JPA
    protected Sala() {}

    public Sala(int numero, int numeroAssentos) {
        this.numero = validarNumero(numero);
        this.numeroAssentos = validarNumeroAssentos(numeroAssentos);
        this.filme = null;
    }

    public Sala(int numero, int numeroAssentos, Filme filme) {
        this.numero = validarNumero(numero);
        this.numeroAssentos = validarNumeroAssentos(numeroAssentos);
        this.filme = filme;
    }

    public void alterarNumero(int novoNumero) {
        this.numero = validarNumero(novoNumero);
    }

    public void alterarNumeroAssentos(int novoNumeroAssentos) {
        this.numeroAssentos = validarNumeroAssentos(novoNumeroAssentos);
    }

    public void definirFilme(Filme novoFilme) {
        this.filme = novoFilme;
    }

    public void removerFilme() {
        this.filme = null;
    }

    public Long getId() {
        return id;
    }

    public int getNumero() {
        return numero;
    }

    public int getNumeroAssentos() {
        return numeroAssentos;
    }

    public Filme getFilme() {
        return filme;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sala)) return false;
        Sala sala = (Sala) o;
        return Objects.equals(id, sala.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}