package br.edu.ufersa.cinerex.domain.entity;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "sala")
public class Sala {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero", nullable = false, unique = true)
    private Integer numero;

    @Column(name = "numero_assentos", nullable = false)
    private Integer numeroAssentos;

    // Metodos de validacao
    private static Integer validarNumero(Integer numero) {
        if (numero <= 0) throw new IllegalArgumentException("Numero da sala deve ser maior que zero");
        return numero;
    }

    private static Integer validarNumeroAssentos(Integer numeroAssentos) {
        if (numeroAssentos <= 0) throw new IllegalArgumentException("Numero de assentos deve ser maior que zero");
        return numeroAssentos;
    }

    // Contrutor vazio necessario para o Spring Data JPA
    protected Sala() {}

    public Sala(Integer numero, Integer numeroAssentos) {
        this.numero = validarNumero(numero);
        this.numeroAssentos = validarNumeroAssentos(numeroAssentos);
    }

    public void alterarNumero(Integer novoNumero) {
        this.numero = validarNumero(novoNumero);
    }

    public void alterarNumeroAssentos(Integer novoNumeroAssentos) {
        this.numeroAssentos = validarNumeroAssentos(novoNumeroAssentos);
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
}