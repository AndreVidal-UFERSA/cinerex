package br.edu.ufersa.cinerex.api.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/funcionario")
public class FuncionarioController {
    // CREATE

    @PostMapping
    public ResponseEntity<Void> postFuncionario(@RequestBody Object postFuncionarioRequest) {
        return null;
    }

    // READ

    @GetMapping
    public List<Object> getFuncionarios() {
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
