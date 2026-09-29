package br.edu.ufersa.cinerex.features.auth;

import br.edu.ufersa.cinerex.features.auth.dto.TokenResponse;
import br.edu.ufersa.cinerex.shared.exceptions.RecursoJaExiste;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
class AuthService {
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Long registrar(String email, String senha) {
        if (usuarioRepository.existsByEmail(email))
            throw new RecursoJaExiste("Usuario com login fornecido ja existe");
        String senhaCriptografada = passwordEncoder.encode(senha);
        Usuario novoUsuario = new Usuario(email, senhaCriptografada, UserRole.USUARIO);
        Usuario usuarioSalvo = usuarioRepository.save(novoUsuario);
        return usuarioSalvo.getId();
    }
}
