package br.edu.ufersa.cinerex.features.auth;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "funcionario")
class Funcionario implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String senha;

    @Enumerated(EnumType.STRING)
    private UserRole userRole;

    protected Funcionario() {}

    private static String validarNome(String nome) {
        if (nome == null) throw new IllegalArgumentException("Nome nao pode ser null");
        if (nome.isBlank()) throw new IllegalArgumentException("Nome nao pode ser vazio");
        return nome;
    }

    private static String validarEmail(String email) {
        if (email == null) throw new IllegalArgumentException("Email nao pode ser null");
        return email;
    }

    private static String validarSenha(String senha) {
        if (senha == null) throw new IllegalArgumentException("Senha nao pode ser null");
        if (senha.isBlank()) throw new IllegalArgumentException("Senha nao pode ser vazia");
        if (senha.length() < 8) throw new IllegalArgumentException("Senha deve ter pelo menos 8 caracteres");
        return senha;
    }

    public Funcionario(String nome, String email, String senha, UserRole userRole) {
        this.nome = validarNome(nome);
        this.email = validarEmail(email);
        this.senha = validarSenha(senha);
        this.userRole = Objects.requireNonNull(userRole);
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    // UserDetails

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.userRole == UserRole.ADMINISTRADOR) {
            return List.of(
                    new SimpleGrantedAuthority("ROLE_USUARIO"),
                    new SimpleGrantedAuthority("ROLE_ADMINISTRADOR")
            );
        }
        else {
            return List.of(
                    new SimpleGrantedAuthority("ROLE_USUARIO")
            );
        }
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}