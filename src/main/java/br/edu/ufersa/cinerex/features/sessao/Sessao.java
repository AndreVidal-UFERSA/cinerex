package br.edu.ufersa.cinerex.features.sessao;

import jakarta.persistence.*;

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

    protected Sessao() {}
}
