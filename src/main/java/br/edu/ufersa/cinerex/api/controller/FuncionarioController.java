package br.edu.ufersa.cinerex.api.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import br.edu.ufersa.cinerex.api.dto.PutFuncionarioRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ufersa.cinerex.api.dto.GetFuncionarioResponse;
import br.edu.ufersa.cinerex.api.dto.PostFuncionarioRequest;
import br.edu.ufersa.cinerex.domain.entity.Funcionario;
import br.edu.ufersa.cinerex.domain.exception.FuncionarioJaExisteException;
import br.edu.ufersa.cinerex.domain.exception.FuncionarioNaoExisteException;
import br.edu.ufersa.cinerex.domain.service.FuncionarioService;

@RestController
@RequestMapping("/api/v1/funcionario")
public class FuncionarioController {
    private final FuncionarioService funcionarioService;

    public FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    // CREATE
    @PostMapping
    public ResponseEntity<Void> postFuncionario(@RequestBody PostFuncionarioRequest postFuncionarioRequest) {
        try {
            Funcionario funcionarioCriado = funcionarioService.criarFuncionario(
                    postFuncionarioRequest.cpf(),
                    postFuncionarioRequest.nome(),
                    postFuncionarioRequest.login(),
                    postFuncionarioRequest.senha(),
                    postFuncionarioRequest.salario()
            );
            URI uri = URI.create("/api/v1/funcionario/" + funcionarioCriado.getId());
            return ResponseEntity.created(uri).build();
        } catch (FuncionarioJaExisteException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    // READ
    @GetMapping
    public List<GetFuncionarioResponse> getFuncionarios() {
        return funcionarioService.listar().stream().map(GetFuncionarioResponse::fromEntity).toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetFuncionarioResponse> getFuncionario(@PathVariable Long id) {
        Optional<Funcionario> funcionarioOptional = funcionarioService.buscarPorId(id);
        if (funcionarioOptional.isEmpty())
            return ResponseEntity.notFound().build();
        Funcionario funcionario = funcionarioOptional.get();
        GetFuncionarioResponse getFuncionarioResponse = GetFuncionarioResponse.fromEntity(funcionario);
        return ResponseEntity.ok(getFuncionarioResponse);
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Void> putFuncionario(@PathVariable Long id, @RequestBody PutFuncionarioRequest putFuncionarioRequest) {
        try {
            funcionarioService.atualizarFuncionario(
                    id,
                    putFuncionarioRequest.cpf(),
                    putFuncionarioRequest.nome(),
                    putFuncionarioRequest.login(),
                    putFuncionarioRequest.senha(),
                    putFuncionarioRequest.salario()
            );
            return ResponseEntity.noContent().build();
        } catch (FuncionarioNaoExisteException e) {
            return ResponseEntity.notFound().build();
        } catch (FuncionarioJaExisteException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFuncionario(@PathVariable Long id) {
        try {
            funcionarioService.deletarPorId(id);
            return ResponseEntity.noContent().build();
        } catch (FuncionarioNaoExisteException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
