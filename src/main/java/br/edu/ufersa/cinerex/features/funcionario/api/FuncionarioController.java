package br.edu.ufersa.cinerex.features.funcionario.api;

import java.net.URI;
import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ufersa.cinerex.features.funcionario.api.dto.FuncionarioPostRequest;
import br.edu.ufersa.cinerex.features.funcionario.application.CriarFuncionarioCommand;
import br.edu.ufersa.cinerex.features.funcionario.application.FuncionarioApplicationService;

@RestController
@RequestMapping("/api/v1/funcionario")
public class FuncionarioController {
    private final FuncionarioApplicationService applicationService;
    private final FuncionarioMapper mapper;

    public FuncionarioController(FuncionarioApplicationService applicationService, FuncionarioMapper mapper) {
        this.applicationService = applicationService;
        this.mapper = mapper;
    }

    // CREATE

    @PostMapping
    public ResponseEntity<Void> postFuncionario(@Valid @RequestBody FuncionarioPostRequest postFuncionarioRequest) {
        CriarFuncionarioCommand command = mapper.toCommand(postFuncionarioRequest);
        Long idCriado = applicationService.criar(command);
        URI location = URI.create("/api/v1/funcionario/" + idCriado);
        return ResponseEntity.created(location).build();
    }

    // READ

    @GetMapping
    public ResponseEntity<Void> getFuncionarios() {
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getFuncionario(@PathVariable Long id) {
        return null;
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Void> putFuncionario(@PathVariable Long id, @RequestBody Object putFuncionarioRequest) {
        return null;
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFuncionario(@PathVariable Long id) {
        return null;
    }
}
