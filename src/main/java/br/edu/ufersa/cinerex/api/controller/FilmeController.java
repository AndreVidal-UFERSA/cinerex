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
@RequestMapping("/api/v1/filme")
public class FilmeController {

    // CREATE
    @PostMapping
    public ResponseEntity<Void> postFilme(@RequestBody Object postFilmeRequest) {
        // TODO: Implementar a lógica de criação de filme
        return null;
    }

    // READ
    @GetMapping
    public List<Object> getFilmes() {
        // TODO: Implementar a listagem de filmes
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getFilme(@PathVariable Long id) {
        // TODO: Implementar a busca de filme por ID
        return null;
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Void> putFilme(@PathVariable Long id, @RequestBody Object putFilmeRequest) {
        // TODO: Implementar a atualização de filme
        return null;
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFilme(@PathVariable Long id) {
        // TODO: Implementar a deleção de filme
        return null;
    }
}
