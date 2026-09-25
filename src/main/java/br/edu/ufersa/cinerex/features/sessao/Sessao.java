package br.edu.ufersa.cinerex.features.sessao;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "sessoes")
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
}
