package br.edu.ufersa.cinerex.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tipo-ingresso")
public class IngressoController {

    //CREATE
    @PostMapping
    public ResponseEntity<Void> postIngresso(@RequestBody Object postIngressoRequest) {
        // TODO: Implementar a lógica de criação de ingresso
        return null;
    }

    @GetMapping
    public List<Object> getIngresso() {
        // TODO: Implementar a listagem de ingresso
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getIngresso(@PathVariable Long id) {
        // TODO: Implementar a busca de ingresso por ID
        return null;
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Void> putIngresso(@PathVariable Long id, @RequestBody Object putIngressoRequest) {
        // TODO: Implementar a atualização de ingresso
        return null;
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIngresso(@PathVariable Long id) {
        // TODO: Implementar a deleção de ingresso
        return null;
    }
}


