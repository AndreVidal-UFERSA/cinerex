package br.edu.ufersa.cinerex.features.sala;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;

@Entity
@Table(name = "sala")
public class Sala {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column (name = "Status", nullable = false)
    private StatusSala Status;

    @Enumerated(EnumType.STRING)
    @Column (name = "Tipo", nullable = false)
    private TipoSala tipoSala;

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

    private static TipoSala validarTipoSala(TipoSala tipoSala) {
        if (tipoSala == null) {
            throw new IllegalArgumentException("O tipo da sala não pode ser nulo");
        }
        return tipoSala;
    }

    private static StatusSala validarStatusSala(StatusSala status) {
        if (status == null) {
            throw new IllegalArgumentException("O status da sala não pode ser nulo");
        }
        return status;
    }

    // Contrutor vazio necessario para o Spring Data JPA
    protected Sala() {}

    public Sala(Integer numero, Integer numeroAssentos, TipoSala tipoSala) {
        this.numero = validarNumero(numero);
        this.numeroAssentos = validarNumeroAssentos(numeroAssentos);
        this.tipoSala = tipoSala;
        this.Status = StatusSala.LIVRE;
    }

    public void alterarNumero(Integer novoNumero) {
        this.numero = validarNumero(novoNumero);
    }

    public void alterarNumeroAssentos(Integer novoNumeroAssentos) {
        this.numeroAssentos = validarNumeroAssentos(novoNumeroAssentos);
    }

    public void alterarStatus(StatusSala novoStatus) {
        if (novoStatus == null) {
            throw new IllegalArgumentException("O status da sala não pode ser nulo");
        }
        this.Status = novoStatus;
    }

    public void alterarTipoSala(TipoSala novoTipoSala) {
        if (novoTipoSala == null) {
            throw new IllegalArgumentException("O tipo da sala não pode ser nulo");
        }
        this.tipoSala = novoTipoSala;
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