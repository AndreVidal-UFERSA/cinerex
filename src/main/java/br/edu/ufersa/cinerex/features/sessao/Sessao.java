package br.edu.ufersa.cinerex.features.sessao;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "sessao")
class Sessao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "filme_id", nullable = false)
    private Long filmeId;

    @Column(name = "sala_id", nullable = false)
    private Long salaId;

    @Column(nullable = false)
    private LocalDateTime inicio;

    @Column(nullable = false)
    private LocalDateTime fim;

    protected Sessao() {}

    public Sessao(Long filmeId, Long salaId, LocalDateTime inicio, LocalDateTime fim) {
        this.filmeId = Objects.requireNonNull(filmeId);
        this.salaId = Objects.requireNonNull(salaId);
        this.inicio = Objects.requireNonNull(inicio);
        if (inicio.isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("Sessao nao pode ja ter comecada");
        }
        this.fim = Objects.requireNonNull(fim);
        if (fim.isBefore(inicio)) {
            throw new IllegalArgumentException("Sessao termina antes de comecar");
        }
    }

    public Long getId() {
        return id;
    }

    public void atualizar(Long filmeId, Long salaId, LocalDateTime inicio, LocalDateTime fim) {
        this.filmeId = Objects.requireNonNull(filmeId);
        this.salaId = Objects.requireNonNull(salaId);
        this.inicio = Objects.requireNonNull(inicio);
        if (inicio.isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("Sessao nao pode ja ter comecada");
        }
        this.fim = Objects.requireNonNull(fim);
        if (fim.isBefore(inicio)) {
            throw new IllegalArgumentException("Sessao termina antes de comecar");
        }
    }

    public Long getFilmeId() {
        return filmeId;
    }

    public Long getSalaId() {
        return salaId;
    }

    public LocalDateTime getInicio() {
        return inicio;
    }

    public LocalDateTime getFim() {
        return fim;
    }
}
