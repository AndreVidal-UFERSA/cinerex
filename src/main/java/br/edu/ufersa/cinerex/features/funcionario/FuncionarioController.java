package br.edu.ufersa.cinerex.features.funcionario;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import br.edu.ufersa.cinerex.features.funcionario.dto.RequestPutFuncionario;
import br.edu.ufersa.cinerex.shared.exceptions.RecursoNaoEncontrado;
import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ufersa.cinerex.features.funcionario.dto.FuncionarioResponse;
import br.edu.ufersa.cinerex.features.funcionario.dto.RequestPostFuncionario;

@RestController
@RequestMapping("/api/v1/funcionario")
@Validated
class FuncionarioController {
    private final FuncionarioApplicationService applicationService;

    public FuncionarioController(FuncionarioApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    // CREATE

    @PostMapping
    public ResponseEntity<Void> postFuncionario(@Valid @RequestBody RequestPostFuncionario requestPostFuncionario) {
        Long idCriado = applicationService.criar(requestPostFuncionario);
        URI location = URI.create("/api/v1/funcionario/" + idCriado);
        return ResponseEntity.created(location).build();
    }

    // READ
    @GetMapping
    public ResponseEntity<List<FuncionarioResponse>> getFuncionarios() {
        return ResponseEntity.ok(applicationService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FuncionarioResponse> getFuncionario(@PathVariable Long id) {
        Optional<FuncionarioResponse> funcionarioResponseOptional = applicationService.encontrar(id);
        if (funcionarioResponseOptional.isEmpty())
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.ok(funcionarioResponseOptional.get());
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Void> putFuncionario(@PathVariable Long id, @RequestBody RequestPutFuncionario requestPutFuncionario) {
        try {
            applicationService.atualizarTotal(id, requestPutFuncionario);
        }
        catch (RecursoNaoEncontrado ex) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFuncionario(@PathVariable Long id) {
        try {
            applicationService.removerFuncionario(id);
        } catch (RecursoNaoEncontrado ex) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}
