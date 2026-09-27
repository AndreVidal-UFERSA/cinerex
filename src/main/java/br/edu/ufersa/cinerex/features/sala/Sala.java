package br.edu.ufersa.cinerex.features.sala;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "sala")
class Sala {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero", nullable = false, unique = true)
    private Integer numero;

    @Column(name = "numero_assentos", nullable = false)
    private Integer numeroAssentos;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo", nullable = false, length = 20)
    private TipoSala tipoSala;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 20)
    private StatusSala status;

    // Metodos de validacao
    private static Integer validarNumero(Integer numero) {
        if (numero == null || numero <= 0) throw new IllegalArgumentException("Numero da sala deve ser maior que zero");
        return numero;
    }

    private static Integer validarNumeroAssentos(Integer numeroAssentos) {
        if (numeroAssentos == null || numeroAssentos <= 0) throw new IllegalArgumentException("Numero de assentos deve ser maior que zero");
        return numeroAssentos;
    }

    private static TipoSala validarTipoSala(TipoSala tipoSala) {
        if (tipoSala == null) throw new IllegalArgumentException("O tipo da sala nao pode ser nulo");
        return tipoSala;
    }

    private static StatusSala validarStatus(StatusSala status) {
        if (status == null) throw new IllegalArgumentException("O status da sala nao pode ser nulo");
        return status;
    }

    // Construtor vazio necessario para o Spring Data JPA
    protected Sala() {}

    public Sala(Integer numero, Integer numeroAssentos, TipoSala tipoSala) {
        this.numero = validarNumero(numero);
        this.numeroAssentos = validarNumeroAssentos(numeroAssentos);
        this.tipoSala = validarTipoSala(tipoSala);
        this.status = StatusSala.NORMAL;
    }

    public void alterarNumero(Integer novoNumero) {
        this.numero = validarNumero(novoNumero);
    }

    public void alterarNumeroAssentos(Integer novoNumeroAssentos) {
        this.numeroAssentos = validarNumeroAssentos(novoNumeroAssentos);
    }

    public void alterarStatus(StatusSala novoStatus) {
        this.status = validarStatus(novoStatus);
    }

    public void alterarTipoSala(TipoSala novoTipoSala) {
        this.tipoSala = validarTipoSala(novoTipoSala);
    }

    public Long getId() {
        return id;
    }

    public Integer getNumero() {
        return numero;
    }

    public Integer getNumeroAssentos() {
        return numeroAssentos;
    }

    public TipoSala getTipoSala() {
        return tipoSala;
    }

    public StatusSala getStatus() {
        return status;
    }
}