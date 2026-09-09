package br.edu.ufersa.cinerex.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tipo-ingresso")
public class TipoIngressoController {

    //CREATE
    @PostMapping
    public ResponseEntity<Void> postTipoIngresso(@RequestBody Object postTipoIngressoRequest) {
        // TODO: Implementar a lógica de criação de tipos de ingresso
        return null;
    }

    @GetMapping
    public List<Object> getTiposIngresso() {
        // TODO: Implementar a listagem de tipos de ingresso
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getTiposIngresso(@PathVariable Long id) {
        // TODO: Implementar a busca de tipos de ingresso por ID
        return null;
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Void> putTipoIngresso(@PathVariable Long id, @RequestBody Object putTipoIngressoRequest) {
        // TODO: Implementar a atualização de tipos de ingresso
        return null;
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTipoIngresso(@PathVariable Long id) {
        // TODO: Implementar a deleção de tipos de ingresso
        return null;
    }
}

