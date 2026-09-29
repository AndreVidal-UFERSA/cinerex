package br.edu.ufersa.cinerex.features.auth;

import br.edu.ufersa.cinerex.features.auth.dto.LoginRequest;
import br.edu.ufersa.cinerex.features.auth.dto.RequestRegister;
import br.edu.ufersa.cinerex.features.auth.dto.TokenResponse;
import br.edu.ufersa.cinerex.shared.exceptions.RecursoJaExiste;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/v1/auth")
@Validated
class AuthController {
    private final AuthenticationManager authenticationManager;
    private final AuthService authService;
    private final TokenService tokenService;

    public AuthController(AuthenticationManager authenticationManager, AuthService authService, TokenService tokenService) {
        this.authenticationManager = authenticationManager;
        this.authService = authService;
        this.tokenService = tokenService;
    }

    @PostMapping("/login")
    public ResponseEntity<TokenResponse> login(@RequestBody @Valid LoginRequest loginRequest) {
        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(loginRequest.email(), loginRequest.senha());
        Authentication authentication = authenticationManager.authenticate(authToken);
        String token = tokenService.generateToken((Usuario)authentication.getPrincipal());
        return ResponseEntity.ok(new TokenResponse(token));
    }

    @PostMapping("/register")
    public ResponseEntity<Void> registrar(@RequestBody @Valid RequestRegister requestRegister) {
        try {
            Long idGerado = authService.registrar(requestRegister.email(), requestRegister.senha());
            return ResponseEntity.ok().build();
        } catch (RecursoJaExiste ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }
}
