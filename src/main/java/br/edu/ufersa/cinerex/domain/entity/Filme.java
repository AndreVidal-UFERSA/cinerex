package br.edu.ufersa.cinerex.domain.entity;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "filme")
public class Filme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private Classificacao classificacao;

    @Column(nullable = false, length = 4)
    private Integer ano;

    @Column(nullable = false, length = 100)
    private String diretor;

    // Metodos de validacao
    private static String validarNome(String nome) {
        Objects.requireNonNull(nome, "Nome nao pode ser null");
        if (nome.isBlank()) throw new IllegalArgumentException("Nome nao pode ser vazio");
        return nome;
    }

    private static Classificacao validarClassificacao(Classificacao classificacao) {
        Objects.requireNonNull(classificacao, "Classificacao nao pode ser null");
        return classificacao;
    }

    private static Integer validarAno(Integer ano) {
        if (ano <= 0) throw new IllegalArgumentException("Ano deve ser maior que zero");
        return ano;
    }

    private static String validarDiretor(String diretor) {
        Objects.requireNonNull(diretor, "Diretor nao pode ser null");
        if (diretor.isBlank()) throw new IllegalArgumentException("Diretor nao pode ser vazio");
        return diretor;
    }

    // Construtor vazio necessario para o Spring Data JPA
    protected Filme() {}

    public Filme(String nome, Classificacao classificacao, Integer ano, String diretor) {
        this.nome = validarNome(nome);
        this.classificacao = validarClassificacao(classificacao);
        this.ano = validarAno(ano);
        this.diretor = validarDiretor(diretor);
    }

    public void alterarNome(String novoNome) {
        this.nome = validarNome(novoNome);
    }

    public void alterarClassificacao(Classificacao novaClassificacao) {
        this.classificacao = validarClassificacao(novaClassificacao);
    }

    public void alterarAno(Integer novoAno) {
        this.ano = validarAno(novoAno);
    }

    public void alterarDiretor(String novoDiretor) {
        this.diretor = validarDiretor(novoDiretor);
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Classificacao getClassificacao() {
        return classificacao;
    }

    public Integer getAno() {
        return ano;
    }

    public String getDiretor() {
        return diretor;
    }
}
