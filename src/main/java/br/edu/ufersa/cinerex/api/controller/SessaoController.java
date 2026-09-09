package br.edu.ufersa.cinerex.api.controller;

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
@RequestMapping("/api/v1/sessao")
public class SessaoController {
    // CREATE

    @PostMapping
    public ResponseEntity<Void> putSessao(@RequestBody Object sessao) {
        return null;
    }

    // READ

    @GetMapping
    public ResponseEntity<Void> getSessoes() {
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Void> getSessao(@PathVariable Long id) {
        return null;
    }

    // UPDATE

    @PutMapping("/{id}")
    public ResponseEntity<Void> putSessao(@PathVariable Long id) {
        return null;
    }

    // DELETE

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSessao(@PathVariable Long id) {
        return null;
    }
}
