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
@Table(name = "funcionario")
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false, length=14)
    private String cpf;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(unique = true, nullable = false, length = 100)
    private String login;

    @Column(nullable = false, length = 100)
    private String senha;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal salario;

    // Metodos de validacao
    private static String validarCpf(String cpf) {
        Objects.requireNonNull(cpf, "CPF nao pode ser null");
        if (cpf.isBlank())
            throw new IllegalArgumentException("CPF nao pode ser vazio");
        if (!cpf.matches("^\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}$"))
            throw new IllegalArgumentException("CPF tem formatacao incorreta");
        return cpf;
    }

    private static String validarNome(String nome) {
        Objects.requireNonNull(nome, "Nome nao pode ser null");
        if (nome.isBlank()) throw new IllegalArgumentException("Nome nao pode ser vazio");
        return nome;
    }

    private static String validarLogin(String login) {
        Objects.requireNonNull(login, "Login nao pode ser null");
        if (login.isBlank()) throw new IllegalArgumentException("Login nao pode ser vazio");
        return login;
    }

    private static String validarSenha(String senha) {
        Objects.requireNonNull(senha, "Senha nao pode ser null");
        if (senha.isBlank()) throw new IllegalArgumentException("Senha nao pode ser vazia");
        if (senha.length() < 8) throw new IllegalArgumentException("Senha deve ter pelo menos 8 caracteres");
        return senha;
    }

    private static BigDecimal validarSalario(BigDecimal salario) {
        Objects.requireNonNull(salario, "Salario nao pode ser null");
        if (salario.compareTo(BigDecimal.ZERO) <= 0)
            throw new IllegalArgumentException("Salario nao pode ser menor ou igual a zero");
        return salario;
    }

    // Contrutor vazio necessario para o Spring Data JPA
    protected Funcionario() {}

    public Funcionario(String cpf, String nome, String login, String senha, BigDecimal salario) {
        this.cpf = validarCpf(cpf);
        this.nome = validarNome(nome);
        this.login = validarLogin(login);
        this.senha = validarSenha(senha);
        this.salario = validarSalario(salario);
    }

    public void alterarCpf(String novoCpf) {
        this.cpf = validarCpf(novoCpf);
    }

    public void alterarNome(String novoNome) {
        this.nome = validarNome(novoNome);
    }

    public void alterarLogin(String novoLogin) {
        this.login = validarLogin(novoLogin);
    }

    public void alterarSenha(String novaSenha) {
        this.senha = validarSenha(novaSenha);
    }

    public void alterarSalario(BigDecimal novoSalario) {
        this.salario = validarSalario(novoSalario);
    }

    public Long getId() {
        return id;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public BigDecimal getSalario() {
        return salario;
    }
}
